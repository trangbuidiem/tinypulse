package trangbui.selenium.common;

public class Constants {
    public static final int TITLE_BOX_WIDTH = 70;
    public static final int TITLE_TEXT_WIDTH = 60;

    // Selenium configs
    public static final int WAIT_3 = 3;
    public static final int WAIT_10 = 10;
    public static final int WAIT_20 = 20;
    public static final int WAIT_60 = 60;
    public static final int WAIT_120= 120;
    public static final int WAIT_300 = 300;
    public static final String BROWSER = Configs.getProperty("browser");
    public static final boolean HEADLESS = Boolean.valueOf(Configs.getProperty("headless"));
    public static final boolean DISABLE_PDF_VIEWER = Boolean.valueOf(Configs.getProperty("disable_pdf_viewer"));
    public static final boolean MAXIMIZE_WINDOW = Boolean.valueOf(Configs.getProperty("maximize_window"));
    public static final int IMPLICITLY_WAIT = Integer.valueOf(Configs.getProperty("implicitly_wait_in_seconds"));

    // Log configs
    public static final String LOG_FILE_NAME_FORMAT = Configs.getProperty("log_filename_format");

    // Resources name
    public static final String LOG4J_FILE = "log4j.xml";
    public static final String CONFIG_FILE = "application.properties";
    public static final String TEST_DATA_FILE = "test_data.xlsx";
}