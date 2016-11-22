package lt.vcs;

/**
 * Created by Cukrus on 2016.10.20.
 */
public class Player {
    private String name;
    private int cash = 250;

    private Hand hand = new Hand(GameUtils.rollHand());

    /** zaidejo konstruktorius
     * @param name zaidejo vardas
     */
    public Player(String name) {
        this.name = name;
    }

    public String getStats() {
        return name + "(cash: " + cash + ")";
    }

    public String getName() {
        return name;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }

    public Hand getHand() {
        return hand;
    }
}
