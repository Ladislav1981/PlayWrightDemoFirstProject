package homeWork;

import com.microsoft.playwright.*;

import javax.swing.*;

public class FirstExersice {

    public static void main(String[] args) {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome")
                        .setSlowMo(200)

        );

          Page page = browser.newPage();
          page.navigate("https://devexpress.github.io/testcafe/example/");

          String title= page.title();
          String url= page.url();

        System.out.println("title = " + title);
        System.out.println("url = " + url);

        page.locator("#developer-name").type("LadislavK");
         page.waitForTimeout(2000);

         page.locator("#remote-testing").click();
         page.waitForTimeout(1000);
         page.locator("#reusing-js-code").click();
         page.waitForTimeout(1000);
         page.locator("#background-parallel-testing").click();
         page.waitForTimeout(1000);
         page.locator("#continuous-integration-embedding").click();
         page.waitForTimeout(1000);
         page.locator("#traffic-markup-analysis").click();

        page.waitForTimeout(1000);
        page.locator("#tried-test-cafe").click();
        page.waitForTimeout(1000);


       page.locator("#comments").type("Hello My First Project on Playwright");
       page.waitForTimeout(1000);

      page.locator("#submit-button").click();
        page.waitForTimeout(2000);

       String pageMessage  =page.locator("#article-header").textContent();
        System.out.println("pageMessage = " + pageMessage);

        page.waitForTimeout(3000);

        page.close();
        browser.close();
        playwright.close();






    }
}



