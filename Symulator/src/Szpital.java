public class Szpital {
    static int WYZDROWIALY=4;
    static int PRZYJETY=5;
    static int NIEPRZYJETY=6;
    int ilosc_lozek;
    int ilosc_zajetych_lozek;
    int ilosc_pacjentow;
    Szpital(int ilosc_lozek,int ilosc_pacjentow){
        this.ilosc_lozek=ilosc_lozek;
        this.ilosc_pacjentow=ilosc_pacjentow;
        this.ilosc_zajetych_lozek=0;
    }
    synchronized int wyzdrowienie(int numer){
        ilosc_zajetych_lozek--;
        ilosc_pacjentow--;
        System.out.println("Pacjent "+numer + " wyzdrowial.");
        return WYZDROWIALY;

    }
    synchronized int przyjmijPacjenta(){
        try{
            Thread.currentThread().sleep(1000);//sleep for 1000 ms
        }
        catch(Exception ie){
        }
        if(ilosc_zajetych_lozek<ilosc_lozek){
            ilosc_zajetych_lozek++;
            System.out.println("Przyjeto pacjenta, ilosc zajetych miejsc: " + ilosc_zajetych_lozek);
            return PRZYJETY;
        }
        else
        {
            System.out.println("Nie przyjęto pacjenta brak wolnych miejsc.");
            return NIEPRZYJETY;
        }

    }
    synchronized void smierc(int numer){
        ilosc_pacjentow--;
        System.out.println("Smierc pacjenta: " + numer);
    }

}