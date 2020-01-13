import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


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

	public List<Transferencia> transferenciasPendientesSinImagen() {
		try {
			session.beginTransaction();
			return session.createNativeQuery("select * from transferencia where estado = 'PENDIENTE' and imagen = true limit 0, 100",Transferencia.class).getResultList();
		} finally {
			session.close();
			factory.close();
		}
	}
	


}
