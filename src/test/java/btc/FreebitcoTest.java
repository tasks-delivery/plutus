package btc;



import krans.freebitco.FreebitcoService;
import krans.freebitco.FreebitcoServiceImpl;
import org.testng.annotations.Test;



public class FreebitcoTest  {

    public void changeIp(){
        try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(), "UTF-8").useDelimiter("\\A")) {
            System.out.println("My current IP address is " + s.next());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void account1(){
        changeIp();
        FreebitcoServiceImpl freebitcoService;
        freebitcoService = new FreebitcoServiceImpl();
        freebitcoService.login("1FvPJV1C7KsqYVYytxGPbSvrDdkXtaRpyW", "W7cx5U5n6LQ1BlsE");
        freebitcoService.getBTC();
    }

    @Test
    public void account2(){
        changeIp();
        FreebitcoServiceImpl freebitcoService;
        freebitcoService = new FreebitcoServiceImpl();
        freebitcoService.login("1HCStu8kdmFD8FifGgxwthP5L7J3zBMTfX", "W7cx5U5n6LQ1BlsE");
        freebitcoService.getBTC();
    }



}
