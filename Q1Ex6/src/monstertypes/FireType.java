package monstertypes;

class FireType extends Monster {

    public static final MonsterType type = MonsterType.Fire;
    public static final TypeData.EffectivityRecord effectivities = TypeData.effectivityMap.get(
        FireType.type
    );
	public static final TypeData.StatModifierRecord modifiers = TypeData.statModifierMap.get(
		FireType.type
	);

    public FireType(String name, int maxHP, int baseStat) {
        // remove get(0) once a method is had to input arrays instead of just 1 type
        super(
            name,
            type.name(),
            effectivities.effectiveAgainst().get(0).name(),
            effectivities.ineffectiveAgainst().get(0).name(),
            maxHP,
            baseStat
        );
        // add attack modifiers

    }
}
