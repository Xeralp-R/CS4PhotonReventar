package monstertypes;

import javafx.util.Pair;  

private record EffectivityChart {
	
	static final var fire = new Pair<MonsterType[], MonsterType[]>({MonsterType.Grass}, {MonsterType.Water})
}