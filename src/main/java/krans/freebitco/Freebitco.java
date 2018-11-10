package krans.freebitco;

import com.codeborne.selenide.Selenide;

import java.io.IOException;

public class Freebitco {

    private FreebitcoServiceImpl freebitcoService;

    public void getIP(){
        try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(), "UTF-8").useDelimiter("\\A")) {
            System.out.println("My current IP address is " + s.next());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }

    public void runner(){
      //  while (true){
           account1();
          // try {
          //     Thread.sleep(300000);
          // } catch (InterruptedException e) {
          //     e.printStackTrace();
          // }
            account2();
         //  try {
         //      Thread.sleep(3600000);
         //  } catch (InterruptedException e) {
         //      e.printStackTrace();
         //  }
      //  }
    }

    public void account1(){
        freebitcoService = new FreebitcoServiceImpl();
        freebitcoService.login("1FvPJV1C7KsqYVYytxGPbSvrDdkXtaRpyW", "W7cx5U5n6LQ1BlsE");
        freebitcoService.getBTC();
    }

    public void account2(){
        freebitcoService = new FreebitcoServiceImpl();
        freebitcoService.login("1HCStu8kdmFD8FifGgxwthP5L7J3zBMTfX", "W7cx5U5n6LQ1BlsE");
        freebitcoService.getBTC();
    }

}
