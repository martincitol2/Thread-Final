
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
					.createNativeQuery("select * from transferencia where estado = 'PENDIENTE'", Transferencia.class)
					.getResultList();
		} finally {
			session.close();
			factory.close();
		}
	}

	public void cambiarEstadoDeImagen(Long id) {
		try {
			
			session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery("update Transferencia set imagen = true where id = :id");
			query.setParameter("id",(long)id);
			query.executeUpdate();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("No se pudo cambiar el estado de la imagen: " + e.getMessage());
		}finally {
			session.close();
			factory.close();
		}

	}
	
	public List<Transferencia> transferenciaPendientesSinImagen() {
		try {
			session.beginTransaction();
			return session
					.createNativeQuery("select * from transferencia where estado = 'PENDIENTE' and imagen = false", Transferencia.class)
					.getResultList();
		} finally {
			session.close();
			factory.close();
		}
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
		}finally {
			session.close();
			factory.close();
		}
		
	}
	
	@Override
	public void cambiarEstadoTransferencia(Long id) {
		try {
			session.beginTransaction();
			Query<Transferencia> query = session.createQuery("update Transferencia set estado = 'Transferido' where id = :id",Transferencia.class);
			query.setParameter("id",(long)id);
			query.executeUpdate();
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("No se pudo cambiar el estado de la transferencia: "+e.getMessage());
		}finally {
			session.close();
			factory.close();
		}
		
	}

}
