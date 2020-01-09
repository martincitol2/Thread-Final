import java.io.File;
import java.util.List;

import javax.transaction.Transactional;

public class Hilo extends Thread {
	@Transactional
	@Override
	public void run() {
		while (true) {
			TransferenciaDAOImpl tr = new TransferenciaDAOImpl();
			try {
				List<Transferencia> list = tr.transferenciaPendientesSinImagen();
				if (!list.equals(null)) {
					for (Transferencia li : list) {
						
			            File file = new File("C:\\aplicaciones\\transferencias\\imagenes\\recibidas",li.getId()+"-"+li.getCbuEntrada()+"-"+li.getCbuSalida()+".jpg");
						if (file.exists()) {
							TransferenciaDAOImpl tr2 = new TransferenciaDAOImpl();
							tr2.cambiarEstadoDeImagen((long)li.getId());
						}
					}
						Thread.sleep(10000);
				} else {
					Thread.sleep(10000);
				}
			} catch (Exception e) {
				System.out.println("No se pudo ejecutar la transaccion: " + e.getMessage());
			}
			
		}
	}

}
