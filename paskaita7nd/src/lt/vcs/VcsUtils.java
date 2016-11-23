package lt.vcs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Cukrus
 */
public class VcsUtils {
    
    public static int inputInt(String text) {
        return (Integer) input(1, text);
    }
    
    public static String inputWord(String text) {
        return (String) input(2, text);
    }
    
    public static String inputLine(String text) {
        return (String) input(3, text);
    }
    
    private static Object input(int choice, String text) {
        println(text);
        Object result = null;
        switch (choice) {
            case 1:
                result = inInt();
                break;
            case 2:
                result = newScan().next();
                break;
            case 3:
                result = newScan().nextLine();
                break;
            default:
                println("Klaida! neteisingas atvejis");
        }
        return result;
    }
    
    public static int inInt() {
        return newScan().nextInt();
    }
    
    public static Scanner newScan() {
        return new Scanner(System.in);
    }
    
    public static void println(String txt) {
        System.out.println(now() + txt);
    }
    
    public static String now() {
        return newDateFormat("[HH:mm:ss:SSS] ").format(new Date());
    }
    
    public static SimpleDateFormat newDateFormat(String format) {
        return new SimpleDateFormat(format);
    }
    
    public static int rand(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    
    public static BufferedWriter newWriter(File file) throws IOException{
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
    }
    
    public static BufferedReader newReader(File file) throws IOException{
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
    }
}
