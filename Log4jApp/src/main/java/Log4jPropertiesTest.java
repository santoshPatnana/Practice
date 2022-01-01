import org.apache.log4j.Logger;

public class Log4jPropertiesTest {
	
	static Logger log = Logger.getLogger(Log4jPropertiesTest.class);
	
	public static void main(String[] args) {
		log.debug("hello debug...");//Merge Testing.
		log.warn("hello warn");//new comment
		log.info("hello info");
		log.error("hello error");
		log.fatal("hello fatal....");
	}

}
