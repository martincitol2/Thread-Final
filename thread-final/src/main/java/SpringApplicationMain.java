
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class SpringApplicationMain {
	static Logger logger = Logger.getLogger(SpringApplicationMain.class);

	public static void main(String[] args) {

		DOMConfigurator.configure("log4j.xml");

		logger.debug("Log4j appender configuration is successful !!");

		ThreadPrincipal newHilo = new ThreadPrincipal();
		newHilo.start();
	}

}
