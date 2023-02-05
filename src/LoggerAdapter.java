public class LoggerAdapter implements ILegacyDbLogger{
    ILogger logger = Logger.getInstance();

    @Override
    public void outLog(String message, int severityLevel) {
        if(severityLevel == 1){
            logger.outLog("Info", message);
        }
        if(severityLevel == 2){
            logger.outLog("Warning", message);
        }
        if(severityLevel == 3){
            logger.outLog("Error", message);
        }
    }

    //This is only here to prove that the logger is a singleton, normally there would be no need to access this service like this
    public ILogger getLogger() {
        return logger;
    }
}
