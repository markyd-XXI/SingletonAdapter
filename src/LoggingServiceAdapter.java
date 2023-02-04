public class LoggingServiceAdapter implements ILegacyDbLogger{
    ILoggerService loggerService = new LoggerServiceImpl(Logger.getInstance());
    @Override
    public void outLog(String message, int severityLevel) {
        if(severityLevel == 1){
            loggerService.info(message);
        }
        if(severityLevel == 2){
            loggerService.warn(message);
        }
        if(severityLevel == 3){
            loggerService.error(message);
        }
    }

    //This is only here to prove that the logger is a singleton, normally there would be no need to access this service like this
    public ILoggerService getLoggerService() {
        return loggerService;
    }
}
