
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ConexionABaseDeDatos {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Transferencia.class)
			.buildSessionFactory();

	Session session = factory.getCurrentSession();

	public void enviarDdBb(Transferencia transferencia) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Transferencia.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {

			System.out.println("Creando nuevo objeto...");
			session.beginTransaction();
			session.save(transferencia);
			session.getTransaction().commit();
			System.out.println("Guardado en Base de Datos!");
		} finally {
			session.close();
			factory.close();
		}
	}

	public Transferencia consultarDdBb(String sql) {
		Transferencia te = new Transferencia();
		try {

			session.beginTransaction();
			Transferencia t = (Transferencia) session.createNativeQuery(sql, Transferencia.class).getResultList();
			te.setCbuEntrada(t.getCbuEntrada());
			te.setCbuSalida(t.getCbuSalida());
			te.setEstado(t.getEstado());
			te.setFecha(t.getFecha());
			te.setMonto(t.getMonto());

		} catch (Exception e) {
			System.out.println("consulta transf" + e.getMessage());

		} finally {
			session.close();
			factory.close();
		}
		return te;
	}

	public void realizarTransferencia(String cbu_entrada, String cbu_salida, double monto) {

		try {
			session.beginTransaction();
			session.createSQLQuery("CALL getTransfers(:cbu_entrada, :cbu_salida, :monto)")
					.addEntity(Transferencia.class).setParameter("cbu_entrada", cbu_entrada)
					.setParameter("cbu_salida", cbu_salida).setParameter("monto", monto).executeUpdate();
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("no se pudo realizar la transferencia" + e.getMessage());
		} finally {
			session.close();
			factory.close();
		}
	}

	public void cambiarTransferencia(long id) {
		try {
			session.beginTransaction();
			session.createSQLQuery("update transferencia set estado = 'TRANSFERIDO' where id = :id")
					.addEntity(Transferencia.class).setParameter("id", (long) id).executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("no se pudo realizar el cambio" + e.getMessage());
		} finally {
			session.close();
			factory.close();
		}
	}

}
