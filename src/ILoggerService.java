public interface ILoggerService {
    void warn(String message);
    void info(String message);
    void error(String message);

    //This is only here to prove that the logger is a singleton, normally there would be no need to access this logger like this
    Logger getLogger();
}
