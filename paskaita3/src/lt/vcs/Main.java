package lt.vcs;

import java.util.Scanner;

/**
 *
 * @author aleksandras
 */
public class Main {

    public static void main(String[] args) {
        
//        int skaicius = 7;
//        int antras = 1;
//        
//        System.out.println(antras);
//        antras = antras + skaicius;
//        System.out.println(antras);
//        
//        int trecias = antras % 2;
//        System.out.println(trecias);
        
        //siaip("kdsjfksdjksdjf"); // uztenka vieno stringo nusiusti i siaip metoda
        
       
       String skaicius = Pirmas(5);
        
    
        System.out.println("Skaicius tekste " + skaicius);
        
        String masyvas = "masyvas";
        char [] mass = masyvas.toCharArray();
        
        Scanner scan = new Scanner(System.in);
//        System.out.println("Iveskite skaiciu");
//        int sk1 = scan.nextInt();
//        System.out.println("Skaicius " + sk1);
        
       String tekstas = "Iveskite skaiciu";
       int sk4 = trecias(tekstas);
       System.out.println("Ivestas skaicius " + sk4);
           
    }
    
    
    public static void siaip(String param1, String... param2){ // i parametra su "..." nebutina siusti info
            
    }
    
    public static String Pirmas (int skaicius2){
        
        int skaicius = 5;
        Antras(skaicius);
        
        String tekstas = Integer.toString(skaicius2);       // Galima tiesiog apsirasyti kaip String str = "" + skaicius2
       
        
        return tekstas;
    }
    
    public static int Antras(int skaicius){
        
        return skaicius;
    }
    
    
}
