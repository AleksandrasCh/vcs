package lt.vcs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static lt.vcs.VcsUtils.*;

/**
 *
 * @author aleksandras
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{ // throws Exception { ismeta exceptiona kode, kad ivyko kazkas negerai, leidzia veikti progrmai del butent exceptiono
     
        // person klase, pasirasyt su name kintamuoju (privaciu), konstruktorius su vienu paramentru
        // getter setter metodai
        // susikurti metoda, kuris nieko negrazina public start (), kuris nepriims jokiu param, isves teksta i lauka, kad esam start metode
        
        println("Programa pasileido, esam main metode");
        Person person = new Person("Petras");
        println("Grizome i main metoda");
        println("" + person.getName());
        
        File tekstinis = new File("/Users/aleksandras/Documents/Vilnius Coding/JAVA/testas.txt");
        
        BufferedWriter bw = null;              //pavyzdys kaip veikia exceptionu gaudymas
        try{
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tekstinis), "utf-8"));
       
            
            bw.write("write metodas raso i faila \r"); // galima rasyti teksta pvz "kazkas" + nl + "dar teksto", butu irgi nukelta i nauja eilute
            bw.append("pakeitem failo turini IDE ir saugojam txt faile");
            bw.newLine();
            bw.append("dar viena eilute");
            bw.flush();
                                  

        } catch(IOException ex){
            println("Nepavyko sukurti isvedimo srauto");
            throw new RuntimeException(ex);           // RuntimeException nebutina sugauti, cia yra tik pavyzdys, kad nereiktu metode mesti exceptiono
        }   finally {
            try {
            bw.close();         // uzdaro visus srautus, kad nenaudotu daug resursu
            } catch (IOException ex) {
                throw new RuntimeException(ex); 
            }
        }
        
        InputStream in;
        OutputStream out;
        
        // Metodas apacioje perraso visa failo turini
        
       
        
       
//        bw.flush(); - save
//        bw.write(’’raso I faila’’);
//        bw.newline(); //nauja eilute
//        bw.append(’’prijungia prie galo’’);

        // Metodas apacioje nuskaito tekstinio failo kiekviena eilute
        
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tekstinis), "utf-8"));
        
        String line = null;
        while ((line = br.readLine()) != null ) {  
        println(line);
        //(br.readLine() == null – end of file)
        br.close();
        
    }
    }
    
}
