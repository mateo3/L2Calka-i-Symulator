import java.util.Random;


public class Pacjent extends Thread {
    static int ZDROWY=1;
    static int CHORY=2;
    static int NIEZBADANY=3;
    static int WYZDROWIALY=4;
    static int PRZYJETY=5;
    static int NIEPRZYJETY=6;
    static int SMIERC=7;
    int CZAS_ZYCIA;
    int numer;
    Szpital szpital;
    Random rand = new Random();;
    int stan_zdrowia;
    int stan_opieki;
    public Pacjent(int numer,  Szpital _szpital){
        this.numer=numer;
        stan_opieki = NIEZBADANY;
        CZAS_ZYCIA = (int)(Math.random() * 999 + 1);;
        stan_zdrowia = rand.nextInt(2)+1;
        szpital=_szpital;
    }

    public void run(){
        while(stan_zdrowia!=SMIERC && stan_zdrowia!=WYZDROWIALY){
            if(stan_opieki==NIEZBADANY){
                stan_opieki=szpital.przyjmijPacjenta();
            }
            if(stan_opieki == NIEPRZYJETY){
                if(stan_zdrowia!=ZDROWY){
                    CZAS_ZYCIA-=rand.nextInt(200);
                    System.out.println("Stan zdrowia pacjenta "+ numer +" pogorszyl sie.");
                    try{
                        Thread.currentThread().sleep(1000);//sleep for 1000 ms
                    }
                    catch(Exception ie){
                    }
                }
            }
            if(stan_opieki==PRZYJETY){
                try{
                    sleep(rand.nextInt(1000));
                }
                catch (Exception e){}
                if(stan_zdrowia==CHORY){
                    CZAS_ZYCIA-=rand.nextInt(50);
                    if(rand.nextInt(20) == 1){
                        stan_zdrowia=szpital.wyzdrowienie(numer);
                    }
                }
                if(stan_zdrowia==ZDROWY){
                    stan_zdrowia=szpital.wyzdrowienie(numer);
                }
            }
            if(CZAS_ZYCIA<1){
                stan_zdrowia=SMIERC;
                szpital.smierc(numer);
            }
        }
    }

}
