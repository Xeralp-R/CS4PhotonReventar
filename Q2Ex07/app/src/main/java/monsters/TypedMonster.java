package monsters;

abstract public class TypedMonster extends Monster {

    public final MonsterType type;
    public final TypeData.EffectivityRecord effectivities;
    public final TypeData.StatModifierRecord modifiers;

    public TypedMonster(
        String name,
        MonsterType type,
        int maxHP,
        int baseStat
    ) {
        // remove get(0) once a method is had to input arrays instead of just 1 type
        super(
            name,
            type.name(),
            TypeData.effectivityMap.get(type).effectiveAgainst().get(0).name(),
            TypeData.effectivityMap
                .get(type)
                .ineffectiveAgainst()
                .get(0)
                .name(),
            maxHP,
            baseStat
        );

        // add modifier effects
        super.atk =
            (int) (
                (double) (super.atk) *
                TypeData.statModifierMap.get(type).atkModifier()
            );
        super.def =
            (int) (
                (double) (super.def) *
                TypeData.statModifierMap.get(type).defModifier()
            );

        // set
        // for some terrible reason, this has to go after super()?
        // so it may as well be last.
        this.type = type;
        this.effectivities = TypeData.effectivityMap.get(type);
        this.modifiers = TypeData.statModifierMap.get(type);
    }
}
