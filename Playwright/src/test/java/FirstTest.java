
import base.BaseTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void verifyTitle(){

    page.navigate("https://google.com/ncr");
     if (page.isVisible("button:has-text('Accept all')")) {
         page.click("button:has-text('Accept all')");
     }
        System.out.println("The Page Title is:"+page.title());
    }

}
