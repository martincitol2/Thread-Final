import java.util.List;

public class ThreadPrincipal extends Thread {
	
	@Override
	public void run() {
		
		TransferenciaDAOImpl tr = new TransferenciaDAOImpl();
		
		List<Transferencia> lista = tr.transferenciasPendientesSinImagen();
		

		
		TransferenciaThread hilo1 = new TransferenciaThread(lista.subList(0, 25));
		
		TransferenciaThread hilo2 = new TransferenciaThread(lista.subList(25, 50));
		
		TransferenciaThread hilo3 = new TransferenciaThread(lista.subList(50, 75));
		
		TransferenciaThread hilo4 = new TransferenciaThread(lista.subList(75, 100));
		
		hilo1.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			System.out.println("hilo1" + e.getMessage());
		}
		
		System.out.println("hilo1");
		
		hilo2.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("hilo 2");

		hilo3.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("hilo 3");

		hilo4.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("hilo 4");

	}
	
}


