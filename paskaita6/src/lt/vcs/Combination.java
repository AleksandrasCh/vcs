package lt.vcs;

/**
 * galimos kauliuku pokerio kombinacijos ir ju stiprumas, bei bonus laimejimai
 */
public enum Combination {
    /** nera kombinacijos (high number) [bonus - 0] */
    NONE(0, 0),

    /** pora - 2 vienodi (pair - 2 of a kind) [bonus - 0] */
    PAIR(1, 0),

    /** 2 poros (2 pairs) [bonus - 5] */
    PAIR2(2, 5),

    /** 3 vienodi (3 of a kind) [bonus - 10] */
    KIND3(3, 10),

    /** eile (straight) [bonus - 15] */
    STRAIGHT(4, 15),

    /** pilna troba - pora ir 3 vienodi (full house) [bonus - 20] */
    FULL_HOUSE(5, 20),

    /** 4 vienodi (4 of a kind) [bonus - 25] */
    KIND4(6, 25),

    /** 5 vienodi (5 of a kind) [bonus - 30] */
    KIND5(7, 30);

    private int strength;
    private int bonus;

    private Combination(int strength, int bonus) {
        this.strength = strength;
        this.bonus = bonus;
    }

    public int getStrength() {
        return strength;
    }

    public int getBonus() {
        return bonus;
    }

}
