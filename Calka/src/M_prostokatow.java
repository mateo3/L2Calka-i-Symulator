import java.util.Scanner;

import static java.lang.Math.*;


public class M_prostokatow extends Thread{
    double wynik;
    double a;
    double b;
    int n;
    public M_prostokatow( double a, double b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
    }
    double funkcja(double x)
    {
        return x*x;
    }
    void licz(){
        double delta, suma = 0;
        delta = (b - a) / n;
        for (int i = 0; i < n; i++)	{
            suma += delta * funkcja(a + delta*(i + 0.5));
        }
        wynik = suma;
    }

    @Override
    public void run() {
        licz();
    }
}

