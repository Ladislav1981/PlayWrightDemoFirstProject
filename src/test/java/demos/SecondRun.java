package demos;

import com.microsoft.playwright.*;

public class SecondRun {

    public static void main(String[] args) {

        Playwright playwright =Playwright.create();

        Browser browser= playwright.chromium().launch(// можно менять поисковики//
                new BrowserType.LaunchOptions()
                        .setHeadless(false)// без показания графики изначально True//
                        .setChannel("chrome")
                        .setSlowMo(100)//устанавливаем скорость печатания//
        );

        Page page = browser.newPage();

        page.navigate("https://www.saucedemo.com/");

        String title = page.title();

        String url = page.url();

        System.out.println("title = " + title);

        System.out.println("url = " + url);


        Locator userNameType = page.locator("#user-name");//assigned variable userNameType//
        userNameType .type("Ladislav"); //поиск по id//
        page.waitForTimeout(2000); // мили секунды//
       // userNameType.clear(); //стирает напичатанное//


       // userNameType .type("Kantarovich"); //поиск по id//
      //  page.waitForTimeout(2000); // мили секунды//
      //  userNameType.clear(); //стирает напичатанное//




        Locator userNamepassword= page.locator("[data-test='password']"); //поиск по атрибуту//
        userNamepassword.type("12345678");
        //fill это тоже опция ведения текста работает как копи паст-работает только с input может стирать предедущее значение//
         //при помощи объявления пременной мы можем только вставлять наши данные и не писать каждый раз команды Locator//


        page.locator(".submit-button").click();

      String errorMessage= page.locator("[data-test='error']").textContent();//Сообщение об ошибке//
        System.out.println("errorMessage = " + errorMessage);


        page.waitForTimeout(3000); // мили секунды//



        page.close();
        browser.close();
        playwright.close();


    }
}
