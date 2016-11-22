package lt.vcs;



/**
 * Created by Cukrus on 2016.10.20.
 */
public class GameUtils {

    /**
     * isvercia masyvo reiksmes i suprantama formata
     *
     * @param arr masyvas, kuri versim
     * @return suprantama masyvo tekstine reprezentacija
     */
    public static String intArrayToString(int[] arr) {
        String result = "";
        for (int val : arr) {
            result += "[" + val + "] ";
        }
        return result.trim();
    }

    public static int[] rollHand() {
        int[] result = new int[5];
        for (int i = 0; i < 5; i++) {
            result[i] = rollDice();
        }
        return result;
    }

    /**
     * Isridena viena kauliuka
     * @return iskritusi kauliu skaiciu
     */
    public static int rollDice() {
        return VcsUtils.rand(1, 6);
    }

    /**
     * Nustato kuris is zaideju laimejo
     * @param p1
     * @param p2
     * @return zaideja kurisl iamejo, jei lygiosios grazina null
     */
    public static Player kasLaimejo(Player p1, Player p2) {
        Player winner = null;
        Hand p1h = p1.getHand();
        Hand p2h = p2.getHand();
        if (p1h.getCombination().getStrength() > p2h.getCombination().getStrength()) {
            winner = p1;
        } else if (p1h.getCombination().getStrength() < p2h.getCombination().getStrength()) {
            winner = p2;
        } else {
            switch (p1h.getCombination()) {
                case KIND5:
                case KIND4:
                case KIND3:
                case PAIR:
                    if (p1h.getHighestComboNumber() != p2h.getHighestComboNumber()) {
                        if (p1h.getHighestComboNumber() > p2h.getHighestComboNumber()) {
                            winner = p1;
                        } else {
                            winner = p2;
                        }
                    } else if (p1h.getDiceSum() != p2h.getDiceSum()) {
                        if (p1h.getDiceSum() > p2h.getDiceSum()) {
                            winner = p1;
                        } else {
                            winner = p2;
                        }
                    }
                    break;
                case FULL_HOUSE:
                case PAIR2:
                    if (p1h.getHighestComboNumber() != p2h.getHighestComboNumber()) {
                        if (p1h.getHighestComboNumber() > p2h.getHighestComboNumber()) {
                            winner = p1;
                        } else {
                            winner = p2;
                        }
                    } else if (p1h.getSecondHighestComboNumber() != p2h.getSecondHighestComboNumber()) {
                        if (p1h.getSecondHighestComboNumber() > p2h.getSecondHighestComboNumber()) {
                            winner = p1;
                        } else {
                            winner = p2;
                        }
                    } else if (p1h.getDiceSum() != p2h.getDiceSum()) {
                        if (p1h.getDiceSum() > p2h.getDiceSum()) {
                            winner = p1;
                        } else {
                            winner = p2;
                        }
                    }
                    break;
                case STRAIGHT:
                case NONE:
                    if (p1h.getDiceSum() != p2h.getDiceSum()) {
                        if (p1h.getDiceSum() > p2h.getDiceSum()) {
                            winner = p1;
                        } else {
                            winner = p2;
                        }
                    }
                    break;
            }
        }
        return winner;
    }
}
