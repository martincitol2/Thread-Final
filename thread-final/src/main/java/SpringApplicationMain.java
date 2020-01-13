


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.web.client.RestTemplate;



public class SpringApplicationMain {
	static Logger logger = Logger.getLogger(SpringApplicationMain.class);

	public static void main(String[] args) throws Exception {

		DOMConfigurator.configure("log4j.xml");

		logger.debug("Log4j appender configuration is successful !!");

		getTransferencias();

		ThreadPrincipal newHilo = new ThreadPrincipal();
		newHilo.start();

	}

	private static void getTransferencias() throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		 Transferencia[] result =  restTemplate.getForObject("http://5e1c761edb8a52001414cf97.mockapi.io/transferencia",Transferencia[].class);

		List<Transferencia> listaDeTransferencia = new ArrayList<>();
		for(Transferencia a : result) {
			listaDeTransferencia.add(a);
			System.out.println(a.toString());
			ConexionABaseDeDatos con = new ConexionABaseDeDatos();
			con.enviarDdBb(a);
		}
		
		
	}

}
