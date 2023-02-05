public interface ILegacyDbLogger {
    void outLog(String message, int severityLevel);

    //This is only here to prove that the logger is a singleton, normally there would be no need to access this service like this
    ILogger getLogger();
}
