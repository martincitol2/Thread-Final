import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class SpringApplicationMain {
	static Logger logger = Logger.getLogger(SpringApplicationMain.class);
	public static void main(String[] args) {
		
		
		DOMConfigurator.configure("log4j.xml");

		// Log in console in and log file
		logger.debug("Log4j appender configuration is successful !!");
		Transferencia tr = new Transferencia();
		ConexionABaseDeDatos con = new ConexionABaseDeDatos();
		/*tr.setCbuEntrada("2343243");
		tr.setCbuSalida("23234234");
		tr.setEstado("pendiente");
		tr.setFecha(new Date());
		tr.setMonto((double) 99);
		
		con.enviarDdBb(tr);*/
		con.consultarDdBb("select * from Transferencia where monto >= 100").toString();
	}

}
