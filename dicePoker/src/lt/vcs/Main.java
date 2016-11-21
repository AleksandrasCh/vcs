package lt.vcs;

import java.util.Scanner;
import static lt.vcs.Hand.getResult;
import static lt.vcs.VcsUtils.*;
import lt.vcs.domain.Player1;
import lt.vcs.domain.Player2;

/**
 *
 * @author aleksandras
 */
public class Main {

    public static int statymas1 = 0;
    public static int statymas2 = 0;
    public static String choice = "";
    public static int [] arr = new int [5];
    public static int [] arr2 = new int [5];
    
    public static void main(String[] args) {
        valdymas();
    }
 
    public static void valdymas(){
        println("Sveiki prisijunge i zaidima Dice Poker");
        Player1 player1 = new Player1(inputWord("Iveskite pirmojo zaidejo varda"));
        Player2 player2 = new Player2(inputWord("Iveskite antrojo zaidejo varda"));

        while(true){
           statymas1 = inputInt("Zaidejas " + player1.getName() + " atlikite statyma. || Jusu pinigai: " + player1.getCash() + " || Banke: " + (statymas1 + statymas2));
           choice = inputWord("Zaidejas " + player2.getName() + " jusu pasirinkimas. \"call\" ar \"raise\"? || Jusu pinigai: " + player2.getCash() + " || Banke: " + (statymas1 + statymas2));
            if (choice.equals("call")){
                statymas2 = statymas1;
            }   else if (choice.equals("raise")){
                    String ats = inputWord("Zaidejas " + player2.getName() + " kiek kartu kelsite statyma? \"x2\" ar  \"x3\" ? || Jusu pinigai: " + player2.getCash() + " || Banke: " + (statymas1 + statymas2));
                        if(ats.equals("x2")){
                            statymas2 = statymas1 * 2;
                            println("");
                        }   else if (ats.equals("x3")){
                            statymas2 = statymas1 * 3;
                        }   else {
                            println("Neteisinga ivestis!");
                        }
                    ats = inputWord("Zaidejas " + player1.getName() + " pasirinkite \"call\" arba \"fold\" || Jusu pinigai: " + player2.getCash() + " || Banke: " + (statymas1 + statymas2));
                        if(ats.equals("call")){
                            
                        }   else if (ats.equals("fold")){
                            
                        }
            }
            player1.setCash(player1.getCash() - statymas1);
            player2.setCash(player2.getCash() - statymas2);
            for (int i = 0; i < arr.length; i++){
                arr[i] = rand(1,6);
                arr2[i] = rand(1,6);
            }
            for (int i = 0; i < arr.length; i++){
                
                System.out.print(arr[i] + " ");
            }
            println(getResult(arr));
            
            for (int i = 0; i < arr2.length; i++){
                
                System.out.print(arr2[i] + " ");
            }
            println(getResult(arr2));
            
            String pasirinkimas = inputWord("Zaidejas " + player1.getName() + " ar noresite dar karta mesti kauliukus? \"taip\", \"ne\"");
            if(pasirinkimas.equals("taip")){
                Scanner scan = new Scanner(System.in);
                System.out.println("Surasykite kauliukus, kuriuos noresite mesti dar karta. Pvz: 1 4 5");
                String kauliukai = scan.nextLine() + " ";
                String [] skaiciai;
                skaiciai = kauliukai.split(" ");
                int[] intArr = new int[skaiciai.length];
                
                for(int i = 0; i < skaiciai.length; i++) {
                intArr[i] = Integer.parseInt(skaiciai[i]);
                }
                
                for(int i = 0; i < arr.length; i++){   
                    
                    for(int j = 0; j < intArr.length; j++){
                        
                        if(i == intArr[j]){
                            arr[i-1] = rand(1,6);
                        }
                    } 
                }
                
                for (int i = 0; i < arr.length; i++){
                 System.out.print(arr[i] + " ");
                 }
                println(getResult(arr));
            }   else if (pasirinkimas.equals("ne")){
                
            }
            
             pasirinkimas = inputWord("Zaidejas " + player2.getName() + " ar noresite dar karta mesti kauliukus? \"taip\", \"ne\"");
             
            if(pasirinkimas.equals("taip")){
                Scanner scan = new Scanner(System.in);
                System.out.println("Surasykite kauliukus, kuriuos noresite mesti dar karta. Pvz: 1 4 5");
                String kauliukai = scan.nextLine() + " ";
                String [] skaiciai;
                skaiciai = kauliukai.split(" ");
                int[] intArr = new int[skaiciai.length];
                
                for(int i = 0; i < skaiciai.length; i++) {
                intArr[i] = Integer.parseInt(skaiciai[i]);
                }
                
                for(int i = 0; i < arr2.length; i++){   
                    
                    for(int j = 0; j < intArr.length; j++){
                        
                        if(i == intArr[j]){
                            arr2[i-1] = rand(1,6);
                        }
                    } 
                }
                
                for (int i = 0; i < arr2.length; i++){
                 System.out.print(arr2[i] + " ");
                 }
                println(getResult(arr2));
            }   else if (pasirinkimas.equals("ne")){
                
            }

        }
    }
}
