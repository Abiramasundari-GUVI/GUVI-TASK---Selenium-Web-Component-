package com.selenium.web.component.GuviTask_WebComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class DragAndDropAutomation {
    public static void main(String[] args) {
        // Set up the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "E:\\ne guvi java\\chrome-win64\\chromedriver.exe");

        // Initialize WebDriver for Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the target URL
            driver.get("https://jqueryui.com/droppable/");

            // Add an implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Switch to the iframe containing the drag-and-drop elements
            WebElement iframe = driver.findElement(By.className("demo-frame"));
            driver.switchTo().frame(iframe);

            // Find the source element ("Drag me to my target")
            WebElement sourceElement = driver.findElement(By.id("draggable"));

            // Find the target element ("Drop here")
            WebElement targetElement = driver.findElement(By.id("droppable"));

            // Perform drag-and-drop operation
            Actions actions = new Actions(driver);
            actions.dragAndDrop(sourceElement, targetElement).perform();

            // Verify the drag-and-drop operation is successful
            // Check the CSS color property of the target element
            String backgroundColor = targetElement.getCssValue("background-color");
            System.out.println("Background color after drop: " + backgroundColor);

            // Verify the text of the target element has changed to "Dropped!"
            String targetText = targetElement.getText();
            if ("Dropped!".equals(targetText)) {
                System.out.println("Drag and drop operation was successful!");
            } else {
                System.out.println("Drag and drop operation failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the driver
            driver.quit();
            System.out.println("Browser Closed");
        }
    }
}

