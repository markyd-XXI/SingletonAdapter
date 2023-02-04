public class Logger implements ILogger{
    private static Logger loggerSingletonInstance;

    private Logger(){}

    public static synchronized Logger getInstance(){
        if(loggerSingletonInstance == null){
            loggerSingletonInstance =  new Logger();
        }
        return loggerSingletonInstance;
    }

    public void outLog(String severityLevel, String message){
        System.out.println("Modern logger message going to modern log storage:");
        System.out.printf("{\"message\":\"%s\",\"security_level\":\"%s\"}", message, severityLevel);
    }
}
