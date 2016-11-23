package lt.vcs;

import static lt.vcs.VcsUtils.*;
import static lt.vcs.Hand.*;
import static lt.vcs.GameUtils.*;
import static lt.vcs.Combination.*;

/**
 * Zaidimo klase, reprezentuojanti viena zaidimo partija
 */
public class Game {

    /** pirmas zaidejas */
    private final Player p1;
    /** antras zaidejas */
    private final Player p2;

    private Player activePlayer;

    /**
     * zaidimo konstruktorius
     * @param p1 pirmas zaidejas
     * @param p2 antras zaidejas
     */
    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        activePlayer = p1;
    }

    /**
     * startuoja zaidima/partija
     */
    public void start() {
        
            int p1bet = inputInt(p1.getName() + " iveskite statoma suma");
            int p2bet = inputInt(p2.getName() + " statoma suma yra " + p1bet + ". Iveskite statoma suma. " + p1bet + " arba daugiau, jeigu norite kelti");
            
            int p1choice = 0;
            int p2choice = 0;
            int raise = 0;
            
            if(p1bet < p2bet){
                p1choice = inputInt(p2.getName() + " pakele statyma iki " + p2bet + ". Ar norite islyginti? (1 = taip; 2 = ne)");
                
            }
            if (p1choice == 1){
                p1bet = p2bet;
            }
            if (p1choice == 2){
                //baigsim zaidima
            }
            
            p1.setCash(p1.getCash() - p1bet);
            p2.setCash(p2.getCash() - p2bet);
            int bankas = p1bet + p2bet;
            int p1bonus = 0;
            int p2bonus = 0;
            
            Hand p1hand = p1.getHand();
            Hand p2hand = p2.getHand();
            
            p1bonus = p1hand.getCombination().getBonus();
            p2bonus = p2hand.getCombination().getBonus();

            println("p1hand: " + intArrayToString(p1hand.getHandArray()));
            println("p1combination: " + p1hand.getCombination());
            if(p1bonus > 0){
                println(p1.getName() + " gavo bonusa: " + p1bonus);
                p1.setCash(p1.getCash() + p1bonus);
            }
            println("p2hand: " + intArrayToString(p2hand.getHandArray()));
            println("p2combination: " + p2hand.getCombination());
            if(p2bonus > 0){
                println(p2.getName() + " gavo bonusa: " + p2bonus);
                p2.setCash(p2.getCash() + p2bonus);
            }
            
            
            p1choice = inputInt(p1.getName() + " , ar kelsite statyma? (1 = taip; 2 = ne)");
            
            if(p1choice == 1){
                
                raise = inputInt("Iveskite suma, kuria kelsite");
                bankas += raise;
                p1.setCash(p1.getCash() - raise);
                
                p2choice = inputInt(p1.getName() + " pakele statyma +" + raise + ". Ar zaisite toliau? (1 = taip; 2 = ne) || Banke dabar yra: " + bankas);
                
                    if(p2choice == 1){
                        bankas += raise;
                        reRoll();
                        p2.setCash(p2.getCash() - raise);
                    } else if (p2choice == 2){
                        //baigti zaidima
                    }
            }   else if (p1choice == 2){
                
            p2choice = inputInt(p2.getName() + " , ar kelsite statyma? (1 = taip; 2 = ne)");
            
            if(p2choice == 1){
                
                raise = inputInt("Iveskite suma, kuria kelsite");
                bankas += raise;
                p2.setCash(p2.getCash() - raise);
                
                p1choice = inputInt(p2.getName() + " pakele statyma +" + raise + ". Ar zaisite toliau? (1 = taip; 2 = ne) || Banke dabar yra: " + bankas);
                
                    if(p1choice == 1){
                        bankas += raise;
                        reRoll();       //reroll po pakelimo
                        p1.setCash(p1.getCash() - raise);
                    } else if (p1choice == 2){
                        //baigti zaidima
                    }
            }   else if (p2choice == 2){
                reRoll();   // reroll be kelimo
            }
            
            }
            
            

            Player winner = kasLaimejo(p1, p2);
            winner.setCash(winner.getCash() + bankas);
            println("Laimejo zaidejas: " + winner.getName());
            println("----------------");
            println("Zaidejo " + p1.getName() + " balansas = " + p1.getCash());
            println("Zaidejo " + p2.getName() + " balansas = " + p2.getCash());
            println("----------------");
            


    }
    
    private void reRoll(){
        
            Hand p1hand = p1.getHand();
            Hand p2hand = p2.getHand();
        
        int p1choice = inputInt("Zaidejas1, ar nori perrident kauliuku? (1 = taip; 2 = ne)");
            
            if(p1choice == 1){
                String p1reroll = inputLine("Per kableli ivesk kauliuku numerius, kuriuos noresi perrident");
                p1hand.reRollDice(p1reroll);
                println("p1hand: " + intArrayToString(p1hand.getHandArray()));
                println("p1combination: " + p1hand.getCombination());
                
            int p1bonus = p1hand.getCombination().getBonus();

            if(p1bonus > 0){
                println(p1.getName() + " gavo bonusa: " + p1bonus);
                p1.setCash(p1.getCash() + p1bonus);
            }
            }
            
           int p2choice = inputInt("Zaidejas2, ar nori perrident kauliuku? (1 = taip; 2 = ne)");
            
            if(p2choice == 1){

                String p1reroll = inputLine("Per kableli ivesk kauliuku numerius, kuriuos noresi perrident");
                p2hand.reRollDice(p1reroll);
                println("p2hand: " + intArrayToString(p2hand.getHandArray()));
                println("p2combination: " + p2hand.getCombination());
                int p2bonus = p2hand.getCombination().getBonus();
                
                if(p2bonus > 0){
                println(p2.getName() + " gavo bonusa: " + p2bonus);
                p2.setCash(p2.getCash() + p2bonus);
            }
            }
    }

}
