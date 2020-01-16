import java.util.List;

public class ThreadPrincipal extends Thread {

	private int inicio, fin;


	public ThreadPrincipal() {
		super();
		this.inicio = inicio;
		this.fin = fin;
	}


	public ThreadPrincipal(int start, int size) {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void run() {

		TransferenciaDAOImpl tr = new TransferenciaDAOImpl();

		List<Transferencia> lista = tr.transferenciasPendientesSinImagen();

		Thread [] hilos = new Thread [4];

		int rango = lista.size()/4;

		int start = 0;

		int finish = rango;

		for (int i = 0; i < 4; i++) {
			if(i != 4 -1) {
				hilos[i] = new ThreadPrincipal (start, finish);
				
				hilos[i].start();
				
				start = finish;
				
				finish += rango;
			} else {
				hilos[i] = new ThreadPrincipal (start, lista.size());
				hilos[i].start();
			}
		}
			for(int i = 0; i < 4; i++) {
				try {
					hilos[i].join();
				}catch (Exception e) {
					
				}
			}



		TransferenciaThread hilo1 = new TransferenciaThread(lista.subList(0, 25));

		TransferenciaThread hilo2 = new TransferenciaThread(lista.subList(25, 50));

		TransferenciaThread hilo3 = new TransferenciaThread(lista.subList(50, 75));

		TransferenciaThread hilo4 = new TransferenciaThread(lista.subList(75, 100));

		hilo1.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

			System.out.println("hilo1" + e.getMessage());
		}

		System.out.println("hilo1");

		hilo2.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("hilo 2");

		hilo3.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("hilo 3");

		hilo4.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("hilo 4");

	}



}


