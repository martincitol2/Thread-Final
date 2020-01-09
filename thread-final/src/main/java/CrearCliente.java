import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrearCliente {

	// create session factory
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
			.buildSessionFactory();

	// create session
	Session session = factory.getCurrentSession();

	public void crearCliente(Cliente clienteprueba) {

		try {

			// create a student object
			System.out.println("Creating new cliente object...");
			

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the client...");
			session.save(clienteprueba);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}
}
