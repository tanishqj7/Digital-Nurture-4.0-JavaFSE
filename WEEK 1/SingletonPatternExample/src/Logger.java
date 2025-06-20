public class Logger {
    private static Logger log;

    private Logger() {
        System.out.println("Logger Started.");
    }

    public static Logger getInstance() {
        if (log == null) {
            log = new Logger();
        }
        return log;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
