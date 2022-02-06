import java.util.Scanner;

import static java.lang.Math.*;


public class M_trapezow extends Thread{
    double wynik;
    double a;
    double b;
    int n;
    public M_trapezow(double a, double b, int n) {
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
        for (double i=1; i<n; i++) {
            wynik += funkcja(a + (i/n) * (b-a));
        }
        wynik += funkcja(a)/2 + funkcja(b) / 2;
        wynik *= h;
    }

    @Override
    public void run() {
        licz();
    }
}

