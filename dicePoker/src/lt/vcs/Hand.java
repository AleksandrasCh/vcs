package lt.vcs;

import static lt.vcs.VcsUtils.println;

/**
 *
 * @author aleksandras
 */
public class Hand {
    
    
    
  private static int[] getCounts(int[] dice) {
        int[] counts = new int[6];
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 1) {
                counts[0]++;
            } else if (dice[i] == 2) {
                counts[1]++;
            } else if (dice[i] == 3) {
                counts[2]++;
            } else if (dice[i] == 4) {
                counts[3]++;
            } else if (dice[i] == 5) {
                counts[4]++;
            } else if (dice[i] == 6) {
                counts[5]++;
            }
        }
        return counts;
    }

    public static String getResult(int[] dice) {
        int[] counts = getCounts(dice);
        String resValue = " ";

        for (int i = 0; i < counts.length; i++) {

            if (counts[i] == 5) {
                resValue = "Five of a kind ";
                break;
            } else if (counts[i] == 4) {
                resValue = "Four of a kind "; break;
            } else if (counts[i] == 3) {
                resValue = "Three of a Kind ";
                for (int j = 0; j < counts.length; j++) {
                    if (counts[j] == 2) {
                        resValue = "Full House "; break;
                    }
                }
                break;
            } else if (counts[i] == 2) {
                 resValue = "One Pair ";
                for (int j = 0; j < counts.length; j++) {
                    if (counts[j] == 2 && counts[i] == 2) {
                        resValue = "Two Pairs "; break;
                    }
                }
               break;
            } else {
                resValue = "Nothing ";
            }
        }
        return resValue;
    }
    
}
