import java.util.List;

public class TransferenciaThread extends Thread {

	@Override
	public void run() {

		while (true) {
			try {
				TransferenciaDAOImpl tr = new TransferenciaDAOImpl();
				List<Transferencia> lista = tr.transferenciasPendientesSinImagen();
				if (!lista.equals(null)) {
					for (Transferencia transferencia : lista) {
						System.out.println(transferencia.getId());
						if (transferencia.getImagen()) {

							ConexionABaseDeDatos nc = new ConexionABaseDeDatos();
							nc.realizarTransferencia(transferencia.getCbuEntrada(), transferencia.getCbuSalida(),
									transferencia.getMonto());
							ConexionABaseDeDatos nce = new ConexionABaseDeDatos();
							nce.cambiarTransferencia((long) transferencia.getId());
						}
					}
					Thread.sleep(10000);
				} else {
					
					System.out.println("error");
				}
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}

