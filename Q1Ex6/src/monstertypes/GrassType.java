package monstertypes;

public class GrassType extends TypedMonster {

    public static final MonsterType type = MonsterType.Grass;

    public GrassType(String name, int maxHP, int baseStat) {
        super(name, type, maxHP, baseStat);
    }

    @Override
    public void special() {
        super.hp =
            (int) ((double) (super.hp) + ((double) (super.maxHP) * 0.20));
        System.out.printf("%s did a special move!%n", super.name);
        System.out.printf(
            "%s increased its HP to %d!%n",
            super.name, super.hp
        );
    }
}
