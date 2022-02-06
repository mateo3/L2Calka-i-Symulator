import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int n=5;
        M_prostokatow prostokatow = new M_prostokatow(-3, -2, n);
        M_trapezow trapezow = new M_trapezow(-2, 2, n);
        M_Simpsona simpsona = new M_Simpsona(2, 3, n);
        prostokatow.start();
        trapezow.start();
        simpsona.start();
        try {
            prostokatow.join();
            trapezow.join();
            simpsona.join();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        double wynik= prostokatow.wynik + trapezow.wynik + simpsona.wynik;
        System.out.println("Wynik całki: " + wynik);
    }
}
