package monstertypes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;  

final class TypeData {

    public record EffectivityRecord(
        List<MonsterType> effectiveAgainst,
        List<MonsterType> ineffectiveAgainst
    ) {}

    public static final Map<MonsterType, EffectivityRecord> effectivityMap = Map.ofEntries(
        entry(MonsterType.Fire, new EffectivityRecord(
            Arrays.asList(MonsterType.Grass),
            Arrays.asList(MonsterType.Water)
        )),
        entry(MonsterType.Water, new EffectivityRecord(
            Arrays.asList(MonsterType.Fire),
            Arrays.asList(MonsterType.Grass)
        )),
        entry(MonsterType.Grass, new EffectivityRecord(
            Arrays.asList(MonsterType.Water),
            Arrays.asList(MonsterType.Fire)
        ))
    );

    public record StatModifierRecord(
        double atkModifier,
        double defModifier
    ) {}

    public static final Map<MonsterType, StatModifierRecord> statModifierMap = Map.ofEntries(
        entry(MonsterType.Fire, new StatModifierRecord(1.3, 0.7)),
        entry(MonsterType.Water, new StatModifierRecord(0.7, 1.3)),
        entry(MonsterType.Grass, new StatModifierRecord(1.0, 1.0))
    );
}
