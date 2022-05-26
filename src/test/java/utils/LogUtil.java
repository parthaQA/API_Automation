package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {

    public  static Logger logger = LogManager.getLogger(new Throwable()
            .getStackTrace()[0].getClassName());

    public static void logInfo(String message){

        logger.info(message);
    }
    public static void logDebug(String message){

        logger.debug(message);
    }

    public static void logError(String message){

        logger.error(message);
    }
}
