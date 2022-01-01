import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;


public class PatternLayoutTest {
	
	static Logger log = Logger.getLogger(PatternLayoutTest.class);

	public static void main(String[] args) {
		Layout patternLayout = new PatternLayout("%d{dd-mm-yy hh:mm:ss} - %p - %c[%M] : : %m <%L> %n");
		Appender appender = new ConsoleAppender(patternLayout);
		log.addAppender(appender);
		
		log.debug("hello debug");
		log.warn("hello warn");
		log.info("hello info");
		log.error("hello error");
		log.fatal("hello fatal");
	}

}
