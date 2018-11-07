import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 

// TODO: Auto-generated Javadoc
/**
 * The Class HelloWorld.
 */
public class HelloWorld {
    
    /** The Constant logger. */
    private static final Logger logger = LogManager.getLogger("HelloWorld");
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
    	logger.trace("something");
        logger.info("Hello, World!");
    }
}