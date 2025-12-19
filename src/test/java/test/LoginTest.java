package test;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTest extends BaseTest {
    @Test
       public void test() {
        page.navigate("https://www.saucedemo.com/");

        LoginPage loginPage= new LoginPage(page);
        test.info("Navigating To Login PAge");

        loginPage.login();


//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).click();
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill("Admin");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("admin123");
//            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
//            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My Info")).click();
//            page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("profile picture")).nth(1).click();
//            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
//            page.getByText("Required").click();
//            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
//            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
//            assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time"))).isVisible();
        }
    }
