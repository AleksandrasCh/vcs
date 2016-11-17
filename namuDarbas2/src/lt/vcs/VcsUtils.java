package lt.vcs;

import java.util.Scanner;

/**
 *
 * @author aleksandras
 */
public class VcsUtils {
    
    public static int inputInt(String text){
        return (Integer) input(1, text);
    }
    
    public static String inputWord (String text){
        return (String) input(2, text);
    }
    
    public static String inputLine (String text){
        return (String) input(3, text);
    }
    
    private static Object input(int choice, String text){
         println(text);
         Object result = null;
         if(choice == 1) {
             result = newScan().nextInt();
         } else if (choice  == 2) {
             result = newScan().next();
         } else if (choice  == 3){
             result = newScan().nextLine();
         }
        
         return result;  
    }
    
    public static Scanner newScan() {
        return new Scanner(System.in);
    }
   
    public static void println (String text){
        System.out.println(text);
    }
}
