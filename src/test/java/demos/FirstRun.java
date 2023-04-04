package demos;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstRun {
    public static void main(String[] args) {


        Playwright playwright =Playwright.create();

        Browser browser= playwright.chromium().launch(// можно менять поисковики//
                new BrowserType.LaunchOptions()
                        .setHeadless(false)// без показания графики изначально True//
                        .setChannel("chromium")
        );

        Page page = browser.newPage();

        page.navigate("https://playwright.dev/java/docs/intro");

        String title = page.title();

        String url = page.url();

        System.out.println("title = " + title);

        System.out.println("url = " + url);

        page.waitForTimeout(3000); // мили секунды//



        page.close();
        browser.close();
        playwright.close();


    }
}
