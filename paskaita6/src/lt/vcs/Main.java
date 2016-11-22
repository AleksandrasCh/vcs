package lt.vcs;

import static lt.vcs.VcsUtils.*;

/**
 *
 * @author Cukrus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        println("Kauliuku pokeris");
        String p1name = inputWord("Zaidejas 1, iveskite savo varda");
        String p2name = inputWord("Zaidejas 2, iveskite savo varda");
        
        Player p1 = new Player(p1name);
        Player p2 = new Player(p2name);
        boolean zaisti = true;

        while (zaisti) {
            Game newGame = new Game(p1, p2);
            newGame.start();
            String pasirinkimas = inputWord("Ar norite zaisti toliau? (y - taip; n - ne)");
            zaisti = "y".equalsIgnoreCase(pasirinkimas);
        }
        
    }
  
}
