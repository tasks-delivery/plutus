package btc;

import krans.freebitco.FreebitcoServiceImpl;
import org.testng.annotations.Test;

public class FreebitcoTest  {

    private FreebitcoServiceImpl freebitcoService;

    @Test
    public void account1(){
        freebitcoService = new FreebitcoServiceImpl();
        freebitcoService.changeIp();
        freebitcoService.login("1FvPJV1C7KsqYVYytxGPbSvrDdkXtaRpyW", "W7cx5U5n6LQ1BlsE");
        freebitcoService.getBTC();
    }

}
