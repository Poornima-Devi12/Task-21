package task21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1task21 {

	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		
		// Launch the Chrome browser
				WebDriver driver = new ChromeDriver();

				// Load the URL using get method
				driver.get("https://the-internet.herokuapp.com/iframe");

				// Implicit wait for the element of the page to click them
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				// Maximise the browser view
				driver.manage().window().maximize();

				// Locate the iframe using Xpath
				WebElement frameElement = driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"));

				// Switching to frame by element to enter the text
				driver.switchTo().frame(frameElement);

				// Locate the text inside the <p> tag
				WebElement textElement = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
				textElement.clear();

				// Enter the given text as mentioned "Hello People"
				textElement.sendKeys("Hello People");

				// Printing the entered text to console
				WebElement changedText = driver.findElement(By.tagName("p"));
				System.out.println("The text entered in the P tag is : " + changedText.getText());
				Thread.sleep(1000);

				// Closing the browser
				driver.close();
			
	}

}
