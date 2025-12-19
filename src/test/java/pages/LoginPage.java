package pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {
    private Page page;

    private final String usernameTextBox = "[data-test=\"username\"]";
    private final String passwordextBox = "[data-test=\"password\"]";
    private final String loginButton = "[data-test=\"login-button\"]";
    private final String userName = "standard_user";
    private final String password = "secret_sauce";



    public LoginPage (Page page) {
        this.page = page;
    }

    public void login()
    {
        page.fill(usernameTextBox, userName);
        page.fill(passwordextBox, password);
        page.click(loginButton);
        assertThat(page.getByText("Swag Labs")).isVisible();
        System.out.println("Login Success");
    }



}
