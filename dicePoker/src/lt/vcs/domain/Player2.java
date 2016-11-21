package lt.vcs.domain;

/**
 *
 * @author aleksandras
 */
public class Player2 extends Player{
    
    private int cash = 250;
    
    public Player2 (String name){
        super(name);
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
    
}
