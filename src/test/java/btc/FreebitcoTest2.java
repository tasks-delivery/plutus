package btc;

import krans.freebitco.FreebitcoServiceImpl;
import org.testng.annotations.Test;

public class FreebitcoTest2 {

    private FreebitcoServiceImpl freebitcoService;

    @Test
    public void account2(){
        freebitcoService = new FreebitcoServiceImpl();
        freebitcoService.changeIp();
        freebitcoService.login("1HCStu8kdmFD8FifGgxwthP5L7J3zBMTfX", "W7cx5U5n6LQ1BlsE");
        freebitcoService.getBTC();
    }

}
