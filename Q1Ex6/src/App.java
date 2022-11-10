import monstertypes.Monster;

public class App {

    public static void main(String[] args) throws Exception {
		var mon = new Monster("nomina", "type", "strongagainst", "weakagainst", 10, 10);
		mon.guard();
    }
}
