package RestAssuredDemo;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	public class LogFile extends CreateRepo{
	    private static final Logger logger = LoggerFactory.getLogger(CreateRepo.class);

	    public static void main(String[] args) {
	        logger.info("Application started");
	        logger.debug("This is a debug message");
	        logger.error("An error occurred", new RuntimeException("Error details"));
	    }
	}


