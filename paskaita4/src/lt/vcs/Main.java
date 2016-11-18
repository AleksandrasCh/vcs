package lt.vcs;

import java.text.SimpleDateFormat;
import java.util.Date;
import static lt.vcs.VcsUtils.*;
import lt.vcs.klases.Enumas;
import lt.vcs.klases.Person;

/**
 *
 * @author aleksandras
 */
public class Main {


    public static void main(String[] args) {
       
        for (int i = 0; i < 5; i++){
            if (i == 2){
                continue;
            }
            if(i == 4){
                break;
            }
            println(""+ i);
            
        }
        println("--------------");
        int [] mass = {1,2,3}; // foreach ciklas
        for (int i : mass){
            println(""+ i);
        }
        println("--------------");
        int whileKint = 0;
        while (whileKint < 3){
              println(""+ whileKint);
              whileKint++;
        }
        println("--------------");
        int doKint = 0;
        
        do {                            // veikia bent viena karta
              println(String.format("kas %d sdfg %s", doKint, "kazkas"));
              doKint++;
        } while(false);
        println("--------------");
        
        println( (new Date()).toString() );
        
        SimpleDateFormat sdf = new SimpleDateFormat("'laikas 'HH:mm:ss");
        String data = sdf.format(new Date());
        println(data);
        println("--------------");
        
        println("" + System.currentTimeMillis());
        println("" + new Date (System.currentTimeMillis()));
        println("--------------");
        
        int sk = 0;
        while (sk < 5){
        println("metam kauliuka, ir rezultatas - " + rand(1, 6));
        sk++;
        }
        println("--------------");
        
        SuKonstruktorium obj = new SuKonstruktorium ("vardenis");
        println(obj.getVardas());
        obj.setVardas("pavardenis");
        println(obj.getVardas());
        println("--------------");
        
        Person person = new Person("vardenis", "pavardenis", "abc123", new Date());
        
        //Enumas.REIKSME1;
        
        
    }
    
}
