public class Main {
    static int ilosc_pacjentow=10;
    static int ilosc_lozek=6;
    static Szpital szpital;
    public Main(){
    }
    public static void main(String[] args) {
        szpital=new Szpital(ilosc_lozek, ilosc_pacjentow);
        for(int i=0;i<ilosc_pacjentow;i++) {
            new Pacjent(i, szpital).start();
        }
    }

}
