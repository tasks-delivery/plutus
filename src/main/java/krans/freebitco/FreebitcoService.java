package krans.freebitco;

public interface FreebitcoService {
    void changeIp();

    void login(String wallet, String password);

    void getBTC();
}
