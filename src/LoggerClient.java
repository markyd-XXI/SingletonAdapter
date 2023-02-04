public class LoggerClient {
    private String clientId = "";
    private ILegacyDbLogger logger;

    LoggerClient(ILegacyDbLogger logger, String clientId){
        this.clientId = clientId;
        this.logger = logger;
    }

    public void logSomeStuffOut(String message, int severityLevel){
        logger.outLog(message, severityLevel);
    }

    public String getClientId() {
        return clientId;
    }

    //This is only here to prove that the logger is a singleton, normally there would be no need to access this logger like this
    public ILegacyDbLogger getLogger() {
        return logger;
    }
}
