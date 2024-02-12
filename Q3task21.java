package task21;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q3task21 {

	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		// Load the URL using get method
		driver.get("http://the-internet.herokuapp.com/nested_frames");

		// Implicit wait for the element of the page to click them
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Maximise the browser view
		driver.manage().window().maximize();

		WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		// Switching to top frame
		driver.switchTo().frame(topFrame);

		// Verifying there are three frames on the page
		List<WebElement> frames = driver.findElements(By.tagName("frame"));
		String eleSize = String.valueOf(frames.size());
		if (eleSize.equals("3")) {
			System.out.println("There are three frames present in this page");
		} else {
			System.out.println("There is no three frames present in this page");
		}

		WebElement leftFrame = driver.findElement(By.xpath("//frame[@name='frame-left']"));
		// Switching to left frame
		driver.switchTo().frame(leftFrame);

		// Locating the text inside the HTML tag inside frame tag
		WebElement body1 = driver.findElement(By.tagName("body"));
		String leftText = body1.getText();

		// Verifying that the left frame has the text "LEFT"
		System.out.println("----------------------------------------------");
		if (leftText.equals("LEFT")) {
			System.out.println("The left frame has the text: " + leftText);
		} else {
			System.out.println("The left frame has no text LEFT");
		}

		// Switching back to the top frame
		driver.switchTo().parentFrame();

		WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		// Switching to middle frame
		driver.switchTo().frame(middleFrame);

		// Locating the text inside the HTML tag inside frame tag
		WebElement body2 = driver.findElement(By.tagName("body"));
		String middleText = body2.getText();

		// Verifying that the middle frame has the text "MIDDLE"
		System.out.println("----------------------------------------------");
		if (middleText.equals("MIDDLE")) {
			System.out.println("The middle frame has the text: " + middleText);
		} else {
			System.out.println("The middle frame has no text MIDDLE");
		}

		// Switching back to the top frame
		driver.switchTo().parentFrame();

		WebElement rightFrame = driver.findElement(By.xpath("//frame[@name='frame-right']"));
		// Switching to right frame
		driver.switchTo().frame(rightFrame);

		// Locating the text inside the HTML tag inside frame tag
		WebElement body3 = driver.findElement(By.tagName("body"));
		String rightText = body3.getText();

		// Verifying that the right frame has the text "RIGHT"
		System.out.println("----------------------------------------------");
		if (rightText.equals("RIGHT")) {
			System.out.println("The right frame has the text: " + rightText);
		} else {
			System.out.println("The right frame has no text RIGHT");
		}

		// Switching to the default content
		driver.switchTo().defaultContent();

		WebElement bottomFrame = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		// Switching to bottom frame
		driver.switchTo().frame(bottomFrame);

		// Locating the text inside the HTML tag inside frame tag
		WebElement body4 = driver.findElement(By.tagName("body"));
		String bottomText = body4.getText();

		// Verifying that the bottom frame has the text "BOTTOM"
		System.out.println("----------------------------------------------");
		if (bottomText.equals("BOTTOM")) {
			System.out.println("The bottom frame has the text: " + bottomText);
		} else {
			System.out.println("The bottom frame has no text BOTTOM");
		}

		// Getting the current URL and validating whether the text "nested_frames" is
		// present
		System.out.println("----------------------------------------------");
		String url = driver.getCurrentUrl();

		if (url.contains("nested_frames")) {
			System.out.println("The current page URL has nested_frames in it");
		} else {
			System.out.println("The current page URL doesnot have nested_frames in it");
		}
	}

}
