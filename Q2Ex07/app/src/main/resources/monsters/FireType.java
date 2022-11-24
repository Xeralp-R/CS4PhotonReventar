package monstertypes;

public class FireType extends TypedMonster {

    public static final MonsterType type = MonsterType.Fire;

    public FireType(String name, int maxHP, int baseStat) {
        super(name, type, maxHP, baseStat);
    }

    @Override
    public void special() {
        super.atk += 2;
        super.hp = (int) ((double) (super.hp) - (double) (super.hp) * 0.10);
        System.out.printf("%s did a special move!%n", super.name);
        System.out.printf(
            "%s sharpened its attack at the cost of some of its HP!",
            super.name
        );
		System.out.printf("Its HP is now %d.%n", super.hp);
    }
}
