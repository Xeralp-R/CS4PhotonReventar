import monstertypes.*;
import battle.*;

public class App {

    public static void main(String[] args) throws Exception {
        FireType flareon = new FireType("Flareon", 200, 100);
        WaterType vaporeon = new WaterType("Vaporeon", 200, 100);
        GrassType leafeon = new GrassType("Leafeon", 200, 100);

        var showBattle1 = new ShowBattle(flareon, vaporeon);
        showBattle1.commence();

        flareon.resetHealth();
        vaporeon.resetHealth();
        leafeon.resetHealth();

        var showBattle2 = new ShowBattle(vaporeon, leafeon);
        showBattle2.commence();

        flareon.resetHealth();
        vaporeon.resetHealth();
        leafeon.resetHealth();

        var showBattle3 = new ShowBattle(leafeon, flareon);
        showBattle3.commence();
    }
}
