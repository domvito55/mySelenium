import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Calendar;

public class test_0 {
    public static void main(String[] args) {
        long startTime;
        long endTime;

        System.setProperty("webdriver.edge.driver",
                "D:/pCloudFolder/Repositories/Selenium/msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.get("http://studentweb.cencol.ca/mferre39/Comp125/assignment3/photos.htm");

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String orinalWindow = driver.getWindowHandle();

        WebElement fig4 = driver.findElement(By.cssSelector("img[src*='3sm']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fig4,100,0).click().build().perform();
        //Alternative way to click, but not using the offset
//        fig4.click();
//        phoneD.sendKeys("123");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        #############################################################
        int size = driver.getWindowHandles().size();
        String[] windows = new String[size];
        driver.getWindowHandles().toArray(windows);
        int i;
        //As fast as the for(:) approach, but the for(:) needs extra definitions
//        startTime = Calendar.getInstance().getTimeInMillis();
//        driver.getWindowHandles().forEach((window)->{
//            driver.switchTo().window(window);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        endTime = Calendar.getInstance().getTimeInMillis();
//        System.out.println("For each loop: " + (endTime - startTime) + " ms");

        //Similar in speed with Collections.forEach()
//        startTime = Calendar.getInstance().getTimeInMillis();
//        for (String window : windows) {
//            driver.switchTo().window(window);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        endTime = Calendar.getInstance().getTimeInMillis();
//        System.out.println("Enhanced For loop: " + (endTime - startTime) + " ms");
//

        //faster approach
        startTime = Calendar.getInstance().getTimeInMillis();
        for (i=0; i<size; i++){
            driver.switchTo().window(windows[i]);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("For loop: " + (endTime - startTime) + " ms");

        driver.quit();
    }
}
