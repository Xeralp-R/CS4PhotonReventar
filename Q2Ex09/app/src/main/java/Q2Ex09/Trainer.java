package Q2Ex09;

import java.util.*;

public class Trainer {
	private String name;
    private Monster activeMonster;
    private ArrayList<Monster> team;

    public Trainer(String n){
        this.name = n;
        this.activeMonster = null;
        this.team = new ArrayList<>();
    }

    public Monster getActiveMonster(){
        return activeMonster;
    }
    public ArrayList<Monster> getTeam(){
        return team;
    }
    public String getName() {
        return this.name;
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
    public void sureCapture(Monster m) throws AlreadyCapturedException, FullTeamException {
        if (this.team.contains(m)) {
            throw new AlreadyCapturedException();
        }
        if (this.team.size() >= 6) {
            throw new FullTeamException();
        }

        team.add(m);
        System.out.printf("%s was successfully captured.%n", m.getName()); // added \n
    }
    public void release(Monster m) throws NotInTeamException {
        if (!this.team.contains(m)) {
            throw new NotInTeamException();
        }
        team.remove(m);
        System.out.printf("%s was released from the team.%n", m.getName()); // added \n
    }
}
