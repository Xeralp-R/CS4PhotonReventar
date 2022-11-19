package battle;

import monstertypes.*;

public class ShowBattle {

    private TypedMonster monster1;
    private TypedMonster monster2;

    public ShowBattle(TypedMonster monster1, TypedMonster monster2) {
        this.monster1 = monster1;
        this.monster2 = monster2;

        System.out.println("—————————————————————————————————");

        System.out.printf(
            "Fighting now: %s and %s!%n%n",
            monster1.getName(),
            monster2.getName()
        );
    }

    public void commence() {
        // loop for easy breaking
        outer:while (true) {
            System.out.println("Turn 1!");
            monster1.guard();
            if (!stillAlive()) break;
            monster2.attack(monster1);
            if (!stillAlive()) break;
            System.out.println();

            System.out.println("Turn 2!");
            monster1.attack(monster2);
            if (!stillAlive()) break;
            monster2.charge();
            if (!stillAlive()) break;
            System.out.println();

            System.out.println("Turn 3!");
            monster1.special();
            if (!stillAlive()) break;
            monster2.attack(monster1);
            if (!stillAlive()) break;
            System.out.println();

            System.out.println("Turn 4!");
            monster1.charge();
            if (!stillAlive()) break;
            monster2.guard();
            if (!stillAlive()) break;
            System.out.println();

            System.out.println("Turn 5!");
            monster1.attack(monster2);
            if (!stillAlive()) break;
            monster2.special();
            if (!stillAlive()) break;
            System.out.println();

            int n = 6;
            while (true) {
                System.out.printf("Turn %d!%n", n);
                monster1.attack(monster2);
                if (!stillAlive()) break outer;
                monster2.attack(monster1);
                if (!stillAlive()) break outer;
                System.out.println();

                n += 1;
            }
        }

        System.out.println("\nAnd the winner is...");
        if (monster1.getHP() > 0) {
            System.out.println(monster1.getName() + "!");
        } else {
            System.out.println(monster2.getName() + "!");
        }

        System.out.println();
        System.out.println("—————————————————————————————————");
    }

    private boolean stillAlive() {
        if (monster1.getHP() <= 0 || monster2.getHP() <= 0) {
            return false;
        }
        return true;
    }
}
