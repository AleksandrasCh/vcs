package lt.vcs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static lt.vcs.VcsUtils.*;
import lt.vcs.klases.Person;

/**
 *
 * @author aleksandras
 */

public class Main {

   
    public static void main(String[] args) throws ParseException {
        
        zmogus();
    }
    
    public static void zmogus() throws ParseException{
        
        String vardas = inputLine("Iveskite savo varda");
        String pavarde = inputLine("Iveskite savo pavarde");
        String asmensKodas = inputLine("Iveskite savo asmens koda");
        String gimimoData = inputLine("Iveskite savo gimimo data. Formatu \"yyyy-mm-dd\"");
        
        String ats = "";
        boolean baigti = false;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date data = dateFormat.parse(gimimoData);
        
        Person person = new Person(vardas, pavarde, asmensKodas, data);
        
        println("Sveiki!");
        
        do{
        ats = inputWord("Pasirinkite: |asmenine naudotojo informacija: \"info\"| |pinigu likutis: \"likutis\"| |zaisti sunu lenktynes: \"zaisti\"| |baigti darba: \"baigti\"|");
        switch (ats){
            case "info":
                println("Vardas: " + person.getName() + " Pavarde: " + person.getLastName() + " Asmens Kodas: " + person.getId() + " Gimimo data: " + dateFormat.format(person.getBirthDate()));
                break;
            case "likutis":
                println("Likutis = EUR " + person.getBalance());
                break;
            case "zaisti":
                int likutis = person.getBalance();
                likutis = zaidimas(likutis);
                person.setBalance(likutis);
                break;
            case "baigti":
                baigti = true;
                break;
            default:
            }
        }while(baigti == false);

    }   
    
    public static int zaidimas (int likutis){
        println("Jus prisijungete i zaidima \"Sunu Lenktynes\"");
        int suo = inputInt("Pasirinkite suni uz kuri statysite: \"1\", \"2\", \"3\"");
        int statymas = 0;
        
        do{
            statymas = inputInt("Iveskite suma, kuria statysite");
            if (statymas > likutis){
                println("Jusu saskaitoje nera tiek pinigu!");
            }   else{
                
            }
        }while(statymas > likutis);
        
        likutis -= statymas;
        
        int laimetojas = rand(1, 3);
        println("Laimejo suo # " + laimetojas);
        
        if(suo == laimetojas){
            println("Jus laimejote EUR " + statymas*3);
            likutis += statymas * 3;
        }   else {
            println("Deja, bet jusu pasirinktas suo pralaimejo :(");
        }
        
        return likutis;
    }
}
