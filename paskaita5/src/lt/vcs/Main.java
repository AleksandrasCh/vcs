package lt.vcs;

/**
 *
 * @author aleksandras
 */
import static lt.vcs.VcsUtils.*;
import lt.vcs.domain.Person;
import lt.vcs.domain.PetHatingPerson;
import lt.vcs.domain.PetLovingPerson;

public class Main {


    public static void main(String[] args) {
     Person antanas = new PetLovingPerson("antanas", "antanauskas", "12345"); // leistu deklaruoti ir Person antanas nes pagal hierarchija PetLovingPerson yra ir Person
     println(antanas.toString());                                                     // taciau nepaimtu taisykliu, kurios buvo priskirtos prie petlovingperson
     Person petras = new PetHatingPerson("antanas", "antanauskas", "6789");
     println(petras.toString());
     nothing(antanas);
     nothing(petras);
     Person[] mass = {antanas, petras};       // taip galima grupuoti klases pasinaudojant hierarchija
     PetLovingPerson tikrasisAntanas = (PetLovingPerson) antanas;
     tikrasisAntanas.getPet();              // Casting budu priejom prie apribotos informacijos
     
    }
    
    private static void nothing(Person person){                         // kartais naudinga pasiimti aukstesni hierarchijoj objekta
                                                                        // <<<<<<<<<<   pavyzdys
        println(person.getId());
        if(person instanceof PetLovingPerson){          // << tikrinamas instance, ar kazkoks person yra klases PetLovingPerson atstovas
        PetLovingPerson tikrasisAntanas = (PetLovingPerson) person;
                                                        // instanceof tikrina ar dabartinis objektas priklauso kazkam zemiau hierarchijoje
        }
        
    }
    
}
