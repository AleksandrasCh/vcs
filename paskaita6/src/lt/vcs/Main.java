package lt.vcs;

import java.sql.SQLException;
import static lt.vcs.VcsUtils.*;

/**
 *
 * @author Cukrus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static boolean zaisti = false;
    
    public static void main(String[] args) throws SQLException{
        

        println("Kauliuku pokeris");
        String p1name = inputWord("Zaidejas 1, iveskite savo varda");
        
        Login newLogin = new Login (p1name);
        boolean login = newLogin.checkUser();
        
        if (login == false){
            int ats = inputInt("Naudotojo vardas " + p1name + " nerastas. Ar noresite uzsiregistruoti? (1 = taip; 2 = ne)");
                if(ats == 1){
                    Registration newReg = new Registration (p1name);
                    newReg.newUser();
                } else {
                    zaisti = false;
                }
        } else {
            zaisti = true;
        }
        
        String p2name = inputWord("Zaidejas 2, iveskite savo varda");
        
        Login newLogin2 = new Login (p2name);
        login = newLogin2.checkUser();
        
        if (login == false){
            int ats = inputInt("Naudotojo vardas " + p2name + " nerastas. Ar noresite uzsiregistruoti? (1 = taip; 2 = ne)");
                if(ats == 1){
                    Registration newReg = new Registration (p2name);
                    newReg.newUser();
                } else {
                    zaisti = false;
                }
        } else {
            zaisti = true;
        }
        
        Player p1 = new Player(p1name);
        Player p2 = new Player(p2name);
        
        if (zaisti == false){
            println("Zaidimas negalimas, nes nera prisijunge 2 zaidejai");
        }
        
        while (zaisti == true) {
            Game newGame = new Game(p1, p2);
            newGame.start();
            String pasirinkimas = inputWord("Ar norite zaisti toliau? (y - taip; n - ne)");
            zaisti = "y".equalsIgnoreCase(pasirinkimas);
        }
        
    }
  
}
