package monstertypes;

public class WaterType extends TypedMonster {

    public static final MonsterType type = MonsterType.Water;

    public WaterType(String name, int maxHP, int baseStat) {
        super(name, type, maxHP, baseStat);
    }

    @Override
    public void special() {
        super.def += 2;
        super.hp = (int) ((double) (super.hp) - (double) (super.hp) * 0.10);
        System.out.printf("%s did a special move!%n", super.name);
        System.out.printf(
            "%s hardened its defenses at the cost of some of its HP!%n",
            super.name
        );
        System.out.printf("Its HP is now %d.%n", super.hp);
    }
}
