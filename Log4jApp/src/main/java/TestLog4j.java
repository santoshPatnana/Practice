import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.XMLLayout;

public class TestLog4j {
	
	private static Logger log = Logger.getLogger(TestLog4j.class);
	
	public static void main(String[] args) {
		//Layout layout = new SimpleLayout();
		Layout layout = new HTMLLayout();
		//Layout layout = new XMLLayout();
		//Appender appender = new ConsoleAppender(layout);
		Appender appender = null;
		try {
			//appender = new FileAppender(layout, "d:/logs/xmlFile.xml");
			appender = new FileAppender(layout, "d:/logs/htmlFile.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.addAppender(appender);
		
		log.debug("with in debug");
		log.info("with in info");
		log.warn("with in warn");
		log.error("with in error");
		log.fatal("with in fatal");
	}
	
}
