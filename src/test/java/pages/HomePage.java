package pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private final Page page;

   private final String timelink = ".getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(\"Time\")))";

   public HomePage(Page page){
    this.page = page;
   }

   public void homePage(){
    page.click(timelink);
   }

}
