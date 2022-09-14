import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ex2PhotonReventar {

    private Settings settings = new Settings(3, false);

    private boolean play_game () {
        return false;
    };

    public void start() {
        boolean repeat_all = true;
        do {
            OpeningChoice choice = this.show_open();

            if (choice == null) {
                System.out.println("Invalid input- please try again.");
                continue;
            }
            
            switch (choice) {
                case start_game:
                boolean repeat_game = true;
                do {
                    repeat_game = this.play_game();
                } while (repeat_game);
                break;

                case change_settings:
                this.settings = change_settings();
                break;

                case end_application:
                repeat_all = false;
                break;
            }
        } while (repeat_all);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}