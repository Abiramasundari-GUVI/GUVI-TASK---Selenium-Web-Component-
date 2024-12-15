package com.selenium.web.component.GuviTask_WebComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class DatePickerAutomation {
    public static void main(String[] args) {
        // Set up the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "E:\\ne guvi java\\chrome-win64\\chromedriver.exe");

        // Initialize WebDriver for Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the target URL
            driver.get("https://jqueryui.com/datepicker/");

            // Add an implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Switch to the iframe containing the datepicker
            WebElement iframe = driver.findElement(By.className("demo-frame"));
            driver.switchTo().frame(iframe);

            // Click on the datepicker input field to make the datepicker visible
            WebElement datepickerInput = driver.findElement(By.id("datepicker"));
            datepickerInput.click();

            // Click the "Next" button to navigate to the next month
            WebElement nextButton = driver.findElement(By.xpath("//a[@title='Next']"));
            nextButton.click();

            // Select the date "22" from the datepicker
            WebElement date = driver.findElement(By.xpath("//a[text()='22']"));
            date.click();

            // Print the selected date to the console
            String selectedDate = datepickerInput.getAttribute("value");
            System.out.println("Selected Date: " + selectedDate);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser window and quit the driver
            driver.quit();
            System.out.println("Browser Closed");
        }
    }
}

