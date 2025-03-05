//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.openqa.selenium.Alert;
//
//import org.openqa.selenium.WebDriver;
//import org.w3c.dom.Document;
//import org.xml.sax.SAXException;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
////import io.appium.java_client.android.AndroidDriver;
////import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import java.net.MalformedURLException;
//
//public class Base {
//
//    //Attributes
//
//    //public static WebDriver driver;
//    private static WebDriver driver;
//    static String configPath = "C:/Users/annas/Automation course/SumTar/src/testData/config.xml";
//    //report
//    static ExtentReports extent;
//    static ExtentTest test;
//
//    @BeforeAll
//    public static void setUp() throws ParserConfigurationException, IOException, SAXException {
//        //Initialize Extent report
//        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", "13");
//        capabilities.setCapability("deviceName", "9B041FFBA008M1");
//
//        capabilities.setCapability("browserName", "Chrome");
//        capabilities.setCapability("noReset", true);
//        capabilities.setCapability("newCommandTimeout", 300);
//
//        //capabilities.setCapability("appPackage", "com.example.app");
//        //capabilities.setCapability("appActivity", "com.example.app.MainActivity");
//
//        URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
////        driver = new AndroidDriver(appiumServerURL, capabilities);
//        driver.get("https://www.google.com");
//    }
//
//    public static String readFromFile(String keyData, String pathName) throws ParserConfigurationException, IOException, SAXException {
//        String value = null;
//        try {
//            // Load the XML file
//            File xmlFile = new File(pathName.toString());
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(xmlFile);
//
//            // Normalize the document
//            doc.getDocumentElement().normalize();
//
//            // Extract values from XML
//            value = doc.getElementsByTagName(keyData).item(0).getTextContent();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return value;
//    }
//
//    public static void confirmAlert(){
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//    }
//
//    @BeforeEach
//    public void initializing() throws ParserConfigurationException, IOException, SAXException {
//
//        driver.get(readFromFile("path", configPath));
//    }
//
//    @AfterAll
//    public static void close(){
//        driver.quit();
//        extent.flush();
//    }
//
//}


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;

public class Base {

    private static WebDriver driver;
    static ExtentReports extent;
    static ExtentTest test;

    @BeforeAll
    public static void setUp() throws Exception {
        // Initialize Extent report
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("appium:deviceName", "Android Device");
        capabilities.setCapability("appium:appPackage", "com.android.chrome");//
        capabilities.setCapability("appium:appActivity", "com.google.android.apps.chrome.Main");
        capabilities.setCapability("appium:newCommandTimeout", 120);
        capabilities.setCapability("appium:hideKeyboard", true);
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);


//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", "13");
//        capabilities.setCapability("deviceName", "9B041FFBA008M1");  // Device ID or name
//        capabilities.setCapability("browserName", "Chrome");  // Web testing in Chrome
//        capabilities.setCapability("noReset", true);  // Optional: preserve app state
//        capabilities.setCapability("newCommandTimeout", 300);  // Optional: command timeout
//        capabilities.setCapability("chromedriverExecutable", "path/to/chromedriver");
//        // Optional: set the path to Chromedriver (if needed)
//        // capabilities.setCapability("chromedriverExecutable", "path/to/chromedriver");

//        // Start Appium server URL
//        URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
//        driver = new AndroidDriver(appiumServerURL, capabilities);

        // Launch Google in Chrome
        driver.get("https://www.google.com");

        // Test action or verification can go here
    }
}