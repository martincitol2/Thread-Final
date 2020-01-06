import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConexionABaseDeDatos {
	
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Transferencia.class).buildSessionFactory();
	
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
			System.out.println(e.getMessage());
			 
		}
		return te;
	}
}
