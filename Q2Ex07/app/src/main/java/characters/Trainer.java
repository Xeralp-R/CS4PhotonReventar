package characters;

import java.util.ArrayList;
import locations.Location;
import monsters.TypedMonster;

public class Trainer extends Character {

  private TypedMonster activeMonster;
  private ArrayList<TypedMonster> team;

  public Trainer(String n) {
    super(n);
    this.activeMonster = null;
    this.team = new ArrayList<>();
  }

  public Trainer(String n, Location l) {
    super(n, l);
    this.activeMonster = null;
    this.team = new ArrayList<>();
  }

  public TypedMonster getActiveMonster() {
    return activeMonster;
  }

  public ArrayList<TypedMonster> getTeam() {
    return team;
  }

  public void capture(TypedMonster m) {
    if (m.getHP() < m.getMaxHP() * 0.2) {
      team.add(m);
      System.out.println(this.getName() + " caught " + m.getName() + ".");
    } else {
      System.out.println(
        this.getName() + " failed to catch " + m.getName() + "."
      );
    }
  }

  public void battle(TypedMonster m) {
    activeMonster.attack(m);
  }

  public void battle(Trainer t) {
    activeMonster.attack(t.getActiveMonster());
  }
}
