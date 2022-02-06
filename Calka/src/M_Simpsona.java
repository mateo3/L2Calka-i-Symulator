import java.util.Scanner;

import static java.lang.Math.*;

public class M_Simpsona extends Thread {
    double a;
    double b;
    int n;

    double temp=0;
    double x=0;
    double wynik;
    public M_Simpsona(double a, double b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
    }
    double funkcja(double x)
    {
        return x*x;
    }
    void licz(){
        double h=(b - a) / n;
        for (int i=1; i<n; i++) {
            x = a + i*h;
            temp += funkcja(x - h / 2);
            wynik += funkcja(x);
        }
        temp += funkcja(b - h / 2);
        wynik = (h/6) * (funkcja(a) + funkcja(b) + 2*wynik + 4*temp);
    }

    @Override
    public void run() {
        licz();
    }
}