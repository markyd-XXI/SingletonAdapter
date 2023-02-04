public class LegacyDbLoggerImpl implements ILegacyDbLogger{
    @Override
    public void outLog(String message, int severityLevel) {
        System.out.println("Legacy logger message going to the dB:");
        System.out.printf("INSERT INTO LOG_TABLE (sercurity_level, log_message) VALUES ('%s', '%s');", severityLevel, message);
    }

    //This is only here to prove that the logger is a singleton, normally there would be no need to access this service like this
    public ILoggerService getLoggerService() {
        return null;
    }
}
