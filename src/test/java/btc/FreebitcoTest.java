package btc;

import krans.freebitco.FreebitcoServiceImpl;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FreebitcoTest  {

    private FreebitcoServiceImpl freebitcoService;

    @Test
    public void account1(){
        freebitcoService = new FreebitcoServiceImpl();
        freebitcoService.changeIp();
        freebitcoService.login("1FvPJV1C7KsqYVYytxGPbSvrDdkXtaRpyW", "W7cx5U5n6LQ1BlsE");
        $(byText("REQUIREMENTS TO UNLOCK BONUSES")).shouldBe(visible);
        freebitcoService.getBTC();
    }

}
