/*
* usage:
  Log log = new Log(getClass().getName());
  log.logInfo("mu error");
* */

package Game.Logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
    private java.util.logging.Logger logger;

    public Log(String classname){
        logger = logger.getLogger(classname);
    }
    public void logInfo(String logText){
        logger.log(Level.INFO, logText);
    }
    public void logWarning(String logText){
        logger.log(Level.WARNING, logText);
    }
    public void logError(String logText){
        logger.log(Level.SEVERE, logText);
    }
}
