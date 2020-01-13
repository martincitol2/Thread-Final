import java.util.List;

public class TransferenciaThread extends Thread {

	private List<Transferencia> lista;
	
	public TransferenciaThread(List<Transferencia> lista) {
		this.lista = lista;
	}

	@Override
	public void run() {
			
		while (true) {
			try {
				
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

