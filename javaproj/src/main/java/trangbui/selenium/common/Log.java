package trangbui.selenium.common;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    private static Logger logger = null;

    // Execute only one time when calling a method first time.
    static {
        // Only use Basic config if no exist log4j.xml
        // BasicConfigurator.configure();
    }

    private static void getCallerClass() {
        logger = LoggerFactory.getLogger(MyDebug.getCallerClassName());
    }

    public static void configure() {
        System.setProperty("logOutputFileName", MyDateUtils.getTodayWithFormat(Constants.LOG_FILE_NAME_FORMAT));
        DOMConfigurator.configure(new Resources().getLOG4J_PATH());
    }

    public static void configure(String classname) {
        System.setProperty("logOutputFileName", classname + "_" + MyDateUtils.getTodayWithFormat(Constants.LOG_FILE_NAME_FORMAT));
        DOMConfigurator.configure(new Resources().getLOG4J_PATH());
    }

    public static void startTestCase(String sTestCaseName, String sOS, String sBrowser) {
        getCallerClass();
        logger.info(MyStringUtils.asterisk());
        logger.info(MyStringUtils.centerTitleWith$(sTestCaseName));
        logger.info(MyStringUtils.centerTitleWith$(sOS + " - " + sBrowser));
        logger.info(MyStringUtils.asterisk());
    }

    public static void endTestCase() {
        getCallerClass();
        logger.info(MyStringUtils.asterisk());
        logger.info(MyStringUtils.centerTitleWith$("END"));
        logger.info(MyStringUtils.asterisk());
    }

    public static void startSection(String message) {
        getCallerClass();
        logger.info(MyStringUtils.dash());
        logger.info("[SECTION]: " + message);
        logger.info(MyStringUtils.dash());
    }

    public static void runStep(String message) {
        getCallerClass();
        logger.info("[Run step]: " + message);
    }

    // Log level: ALL < DEBUG < INFO < WARN < ERROR < FATAL

    public static void debug(String message) {
        getCallerClass();
        logger.debug(message);
    }

    public static void info(String message) {
        getCallerClass();
        logger.info(message);
    }

    public static void warn(String message) {
        getCallerClass();
        logger.warn(message);
    }

    public static void error(String message) {
        getCallerClass();
        logger.error(message);
    }

}
