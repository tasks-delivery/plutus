package krans.freebitco;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FreebitcoServiceImpl implements FreebitcoService{

    @Override
    public void login(String wallet, String password){
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        Configuration.headless = false;
        open("http://freebitco.in/?op=signup_page");
        $(byText("LOGIN")).click();
        $(byText("Got it!")).waitUntil(visible, 5000).click();
        $(By.name("btc_address")).val(wallet).pressTab();
        $(By.cssSelector("#login_form_password")).val(password);
        $(By.id("login_button")).click();
    }

    @Override
    public void getBTC(){
        Selenide.sleep(3000);
        $(byText("PLAY WITHOUT CAPTCHA")).waitUntil(visible, 3000).scrollTo().click();
        Selenide.sleep(3000);
        $(By.id("free_play_form_button")).scrollTo().click();
        Selenide.sleep(10000);
        close();
    }
}
