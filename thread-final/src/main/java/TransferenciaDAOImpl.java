import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TransferenciaDAOImpl implements TransferenciaDAO {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Transferencia.class)
			.buildSessionFactory();

	Session session = factory.getCurrentSession();

	public List<Transferencia> transferenciasPendientes() {
		try {
			session.beginTransaction();
			return session
					.createNativeQuery("select * from transferencia where estado = 'Pendiente'", Transferencia.class)
					.getResultList();
		} finally {
			factory.close();
		}
	}

	public void cambiarEstadoDeImagen(Long id) {
		try {
			
			session.beginTransaction();
			Query<Transferencia> query = session.createQuery("update Transferencia set imagen = true where id = :id",Transferencia.class);
			query.setParameter("id",(long)id);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("No se pudo cambiar el estado de la imagen: " + e.getMessage());
		}

	}

	public List<Transferencia> transferenciaPendientesSinImagen() {
		List<Transferencia> transferencias = new ArrayList<Transferencia>();
		try {
			session.beginTransaction();
			transferencias = session
					.createNativeQuery("select * from transferencia where estado = 'pendiente' and imagen != true",
							Transferencia.class)
					.getResultList();
		} catch (Exception e) {
			System.out.println("No se pudo consultar las transferencias pendientes: " + e.getMessage());
		}
		return transferencias;
	}

	public void transferir(String cbuLlegada, String cbuSalida, Double monto) {
		try {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Transferencia.class)
					.buildSessionFactory();

			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
			session
					.createSQLQuery("CALL transferir(:cbuLlegada,:cbuSalida,:monto)")
					.addEntity(Transferencia.class)
					.setParameter("cbuLlegada", cbuLlegada)
					.setParameter("cbuSalida", cbuSalida)
					.setParameter("monto", monto)
					.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("No se pudo realizar la transferencia: "+e.getMessage());
		}
		
		
	}

}
