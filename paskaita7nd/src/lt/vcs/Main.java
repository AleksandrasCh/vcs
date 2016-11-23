package lt.vcs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static lt.vcs.VcsUtils.*;

/**
 *
 * @author aleksandras
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static boolean testi = true;
    
    public static void main(String[] args) throws Exception{
        
        //pirma();
        antra();
    }
    
    public static void antra() throws Exception{
        
        do {
        int choice = inputInt("Pasirinkite dominancia tema: || 1 = nuskaityti faila || 2 = irasyti norima teksta i faila || 3 = baigti darba");
        
        if(choice == 1){
            readFile();
        }   else if (choice == 2){
            writeFile();
        }   else if (choice  == 3){
            testi = false;
        }
        } while (testi);
        
    }
    
    private static void readFile () throws IOException {
        
        try{
        
        String kelias = inputLine("Iveskite pilna kelia iki failo, kuri noresite nuskaityti");
        File tekstas = new File(kelias);
        BufferedReader br = newReader(tekstas);
        String line = null;
        while ((line = br.readLine()) != null ) {  
        println(line);
        }
        br.close();
        } catch (IOException ex){
            println("Failas, ivestu keliu neegzistuoja");
        }
    }
    
    private static void writeFile() throws Exception {
        
        String kelias = inputLine("Iveskite pilna kelia iki failo, kuri noresite irasyti");

        Path pathToFile = Paths.get(kelias);
        Files.createDirectories(pathToFile.getParent());
        Files.createFile(pathToFile);
        
        File tekstas = new File(kelias);
        BufferedWriter bw = newWriter(tekstas);
        
        println("Failas buvo sukurtas. Pradekite rasyti teksta. Jeigu norite baigti irasyma, iveskite \"exit\"");
        String ats = "";
        boolean quit = false;
        while(quit == false){
            ats = inputLine("");
            quit = ats.equalsIgnoreCase("exit");
            if (ats.equalsIgnoreCase("exit")){
                
            }   else {
            bw.write(ats + "\r");
            }
        }
        bw.flush();
        bw.close();
        
    }
    
    public static void pirma()throws Exception{
        
        File tekstinis = new File("/Users/aleksandras/Documents/Vilnius Coding/JAVA/testas.txt");
        
        BufferedReader br = newReader(tekstinis);
        
        String line = null;
        while ((line = br.readLine()) != null ) {  
        println(line);
        }
        
    }
}
