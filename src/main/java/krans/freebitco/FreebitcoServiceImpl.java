package krans.freebitco;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FreebitcoServiceImpl implements FreebitcoService{

    @Override
    public void changeIp(){
        try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(), "UTF-8").useDelimiter("\\A")) {
            System.out.println("My current IP address is " + s.next());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void login(String wallet, String password){
        Configuration.browser = "firefox";
        Configuration.baseUrl = "http://freebitco.in";
        Configuration.startMaximized = true;
        Configuration.headless = true;
        open("/?op=signup_page");
        System.out.println("Page is opened");
        $(byText("LOGIN")).click();
        System.out.println("Login tab is shown");
        $(byText("Got it!")).waitUntil(visible, 5000).click();
        System.out.println("Popup is closed");
        $(By.name("btc_address")).val(wallet).pressTab();
        System.out.println("Wallet is entered");
        $(By.cssSelector("#login_form_password")).val(password);
        System.out.println("Password is entered");
        $(By.id("login_button")).click();
        System.out.println("Login is success");
    }

    @Override
    public void getBTC(){
        Selenide.sleep(3000);
        $(byText("PLAY WITHOUT CAPTCHA")).waitUntil(visible, 3000).scrollTo().click();
        System.out.println("Captcha is disabled");
        Selenide.sleep(3000);
        $(By.id("free_play_form_button")).scrollTo().click();
        System.out.println("BTC is sent");
        Selenide.sleep(10000);
        close();
    }
}
