import java.util.*;

public class Trainer extends Character {
    private Monster activeMonster;
    private ArrayList<Monster> team;

    public Trainer(String n){
        super(n);
        this.activeMonster = null;
        this.team = new ArrayList<>();
    }
    public Trainer(String n, Location l){
        super(n, l);
        this.activeMonster = null;
        this.team = new ArrayList<>();
    }

    public Monster getActiveMonster(){
        return activeMonster;
    }
    public ArrayList<Monster> getTeam(){
        return team;
    }

    public void capture(Monster m){
        if(m.getHP() < m.getMaxHP()*0.2){
            team.add(m);
            System.out.println(this.getName() + " caught " + m.getName() + ".");
        }
        else{
            System.out.println(this.getName() + " failed to catch " + m.getName() + ".");
        }
    }
    public void battle(Monster m){
        activeMonster.attack(m);
    }
    public void battle(Trainer t){
        activeMonster.attack(t.getActiveMonster());
    }
}
