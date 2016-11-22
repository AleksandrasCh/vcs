package lt.vcs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Cukrus on 2016.10.21.
 */
public class Hand{

    private final int[] handArray;
    private Combination combination;
    private int highestComboNumber; //daufault for int is 0
    private int secondHighestComboNumber; //daufault for int is 0
    private Map<Integer, Integer> handMap;
    private int diceSum; //daufault for int is 0

    public Hand(int[] handArray) {
        this.handArray = handArray;
        this.handMap = constructHandMap(handArray);
        this.combination = HandUtils.findCombination(handMap);
        determinHighNumbersAndSum(handMap, combination);
    }

    /**
     * perridena norimus kauliukus ir perskaiciuoja kombinacija ir kitus skaicius
     * @param dices kauliuku skaiciai, atskirti kableliu, kuriuos norim perridenti
     */
    public void reRollDice(String dices) {
        dices = dices.replaceAll(" ", "");
        for (String dice : dices.split(",")) {
            Integer nr = new Integer(dice);
            reRoll1Dice(nr);
        }
        this.handMap = constructHandMap(handArray);
        this.combination = HandUtils.findCombination(handMap);
        determinHighNumbersAndSum(handMap, combination);
    }

    private void reRoll1Dice(int dicePos) {
        handArray[dicePos-1] = GameUtils.rollDice();
    }

    private Map<Integer, Integer> constructHandMap(int[] arr) {
        Map<Integer, Integer> result = new HashMap<>();
        result.put(1, 0); result.put(2, 0); result.put(3, 0);
        result.put(4, 0); result.put(5, 0); result.put(6, 0);
        for (int i : arr) {
            result.put(i, result.get(i) + 1);
        }
        return result;
    }

    private void determinHighNumbersAndSum(Map<Integer, Integer> handMap, Combination combination) {
        diceSum = 0; highestComboNumber = 0; secondHighestComboNumber = 0;
        for (int val : handMap.values()) {
            diceSum += val;
        }
        switch (combination) {
            case KIND5:
            case KIND4:
            case KIND3:
            case FULL_HOUSE:
                for (int i = 6; i > 0; i--) {
                    if (handMap.get(i) > 2) {
                        highestComboNumber = i;
                    } else if (handMap.get(i) == 2) {
                        secondHighestComboNumber = i;
                    }
                }
                break;
            case STRAIGHT:
                if (handMap.get(6) != 0) {
                    highestComboNumber = 6;
                } else {
                    highestComboNumber = 5;
                }
                break;
            case PAIR2:
                for (int i = 6; i > 0; i--) {
                    if (handMap.get(i) == 2) {
                        if (highestComboNumber == 0) {
                            highestComboNumber = i;
                        } else {
                            secondHighestComboNumber = i;
                            break;
                        }
                    }
                }
                break;
            case PAIR:
                for (int i = 6; i > 0; i--) {
                    if (handMap.get(i) == 2) {
                        highestComboNumber = i;
                        break;
                    }
                }
                break;
        }
    }

    public int[] getHandArray() {
        return handArray;
    }

    public Combination getCombination() {
        return combination;
    }

    public int getHighestComboNumber() {
        return highestComboNumber;
    }

    public int getSecondHighestComboNumber() {
        return secondHighestComboNumber;
    }

    public Map<Integer, Integer> getHandMap() {
        return handMap;
    }

    public int getDiceSum() {
        return diceSum;
    }

}
