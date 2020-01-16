//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//
//public class UpdateTransfer {
//	
//public static void main(String[] args) {
//		
//		// create session factory
//		SessionFactory factory = new Configuration()
//								.configure("hibernate.cfg.xml")
//								.addAnnotatedClass(Transferencia.class)
//								.buildSessionFactory();
//		
//		// create session
//		Session session = factory.getCurrentSession();
//		
//		try {
//			
//			long id = 1;
//			
//			// now get a new session and start transaction
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// retrieve student based on the id: primary key
//			System.out.println("\nGetting transfer:  " + id);
//			
//			Transferencia transferencia = session.get(Transferencia.class, id);
//			
//			System.out.println("Updating estado transfer...");
//			transferencia.setEstado("por cancelar");
//			
//			// commit the transaction
//			session.getTransaction().commit();
//			
//			
//			// NEW CODE
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// update email for all students
//			System.out.println("Update email for all students");
//			session.createQuery("update Transferencia set estado='Pendiente'").executeUpdate();
//			
//			// commit transaction
//			session.getTransaction().commit();
//			
//			System.out.println("Done!");
//		}
//		finally {
//			factory.close();
//			session.close();
//		}
//		
//	}
//
//}
