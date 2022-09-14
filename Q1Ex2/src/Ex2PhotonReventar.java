// the main class

public class Ex2PhotonReventar {

    private Settings settings = new Settings(3, false, 1, 10);

    public void start() {
        while(true) {
            OpeningChoice choice = GetOpeningChoice.get_opening_choice();

            switch (choice) {
                case start_game:
                    Game game = new Game(this.settings);
                    while (true) {
                        boolean play_again = game.play();
                        if (!play_again) break;
                    }
                    break;

                case change_settings:
                    this.settings = GetSettings.get_settings(this.settings);
                    break;

                case end_application:
                    System.out.println("OK! Goodbye!");
                    return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        var main_class = new Ex2PhotonReventar();
        main_class.start();
    }
}
