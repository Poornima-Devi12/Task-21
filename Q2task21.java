package task21;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q2task21 {

	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		// Load the URL using get method
		driver.get("https://the-internet.herokuapp.com/windows");

		// Implicit wait for the element of the page to click them
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Maximise the browser view
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		// Switching to newly opened window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWindow = new ArrayList<>(windowHandles);

		// Switching to window based on the index using get(index)
		driver.switchTo().window(listWindow.get(1));

		// Validating the text with the expected in the new window
		String childText = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();

		if (childText.equals("New Window")) {
			System.out.println("The text present in the new window matches with: " + childText);
		} else {
			System.out.println("The text present in the new window failed to match with: " + childText);
		}

		Thread.sleep(1000);

		// Closing the newly opened window
		driver.close();

		// Switching to parent window
		driver.switchTo().window(listWindow.get(0));

		String parentText = driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();

		// Validating the parent window is active
		if (parentText.equals("Opening a new window")) {
			System.out.println("The parent window is active and contains text: " + parentText);
		} else
			System.out.println("The parent window is not active");

		Thread.sleep(1000);
		
		// closing the browser
		driver.close();
		

	}

}
