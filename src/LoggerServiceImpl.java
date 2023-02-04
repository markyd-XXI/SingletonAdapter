public class LoggerServiceImpl implements ILoggerService{
    public Logger logger;
    public LoggerServiceImpl(Logger logger){
        this.logger = logger;
    }
    @Override
    public void warn(String message){
        logger.outLog("Warning", message);
    }
    @Override
    public void info(String message){
        logger.outLog("Info", message);
    }
    @Override
    public void error(String message){
        logger.outLog("Error", message);
    }

    //This is only here to prove that the logger is a singleton, normally there would be no need to access this logger like this
    public Logger getLogger() {
        return logger;
    }
}
