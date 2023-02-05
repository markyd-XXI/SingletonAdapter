/**
 * This program will demonstrate the singleton and adapter patterns by creating a logger.
 * Logging a system has been done via dB inserts historically. The clients need to be able to log to the new, more modern
 * logging system, but are expecting the legacy type of logger in their constructor.
 */
public class Main {
    public static void main(String[] args) {
        //Target = ILegacyDbLogger = This is what we want all the code to "think" it is using to log messages.
        //Adapter = LoggingServiceAdapter = This is what is going to translate the legacy db logging calls to modern logging system calls.
        //Adaptee = ILoggerService = This is what will actually be handing the modern logging.

        //This logger client is going to log the old way to the dB
        LoggerClient loggerClient1 = new LoggerClient(new LegacyDbLoggerImpl(), "User Login");
        //This logger client is going to log the new way to the log storage system
        LoggerClient loggerClient2 = new LoggerClient(new LoggerAdapter(), "Order Confirmation");
        LoggerClient loggerClient3 = new LoggerClient(new LoggerAdapter(), "Support Request");

        //Both logger clients log the same way because the new logging method uses the LoggingServiceAdapter which makes the
        //Logging service "look" like an ILegacyDbLogger.
        System.out.println("---------------------------------------------------");
        System.out.printf("%s using legacy logger", loggerClient1.getClientId());
        loggerClient1.logSomeStuffOut("User login failed", 2);
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.printf("%s using modern logger", loggerClient2.getClientId());
        loggerClient2.logSomeStuffOut("Order has been sent", 1);
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.printf("%s using modern logger", loggerClient3.getClientId());
        loggerClient2.logSomeStuffOut("Support request #63782643 has been completed", 1);
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println();

        System.out.println("---------------------------------------------------");
        System.out.println("Proof that there is only one instance of Logger Singleton:");
        ILogger loggerSingletonInstance1 = loggerClient2.getLogger().getLogger();
        ILogger loggerSingletonInstance2 = loggerClient3.getLogger().getLogger();
        System.out.println("Comparing the logger singleton instances:");

        if(loggerSingletonInstance2 == loggerSingletonInstance1){
            System.out.println("Logger singleton instance 1 and 2 are them same object!");
        }

        System.out.println("---------------------------------------------------");
    }
}