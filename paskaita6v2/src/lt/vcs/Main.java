package lt.vcs;

import static lt.vcs.VcsUtils.*;

/**
 *
 * @author aleksandras
 */
public class Main {


    public static void main(String[] args) {
        
        int sk1 = kvadratu(inputInt("Iveskite skaiciu, kuri noresite pakelti kvadratu"));
        println("Skaiciaus kvadratas = " + sk1);
        int sk2 = inputInt("Iveskite pirma skaiciu, kuri noresite sudeti");
        int sk3 = inputInt("Iveskite antra skaiciu, kuri noresite sudeti");
        int suma = sudetis(sk2, sk3);
        println("Skaicu suma = " + suma);
        sk2 = inputInt("Iveskite pirma skaiciu, kuri noresite atimti");
        sk3 = inputInt("Iveskite antra skaiciu, kuri noresite atimti");
        int atimtis = atimtis(sk2, sk3);
        println("Skaicu atimtis = " + atimtis);
    }
    
    // kvadratu , sudeda skaicius, minusuoja du skaicius
    
    public static int kvadratu(int a){
        return a * a;
    }
    public static int sudetis (int a, int b){
        return a + b;
    }
    public static int atimtis (int a, int b){
        return a - b;
    }
}
