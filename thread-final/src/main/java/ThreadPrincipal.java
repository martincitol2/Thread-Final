
public class ThreadPrincipal extends Thread {
	
	@Override
	public void run() {
		
		TransferenciaThread hilo1 = new TransferenciaThread();
		
		TransferenciaThread hilo2 = new TransferenciaThread();
		
		TransferenciaThread hilo3 = new TransferenciaThread();
		
		TransferenciaThread hilo4 = new TransferenciaThread();
		
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


