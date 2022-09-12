import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Ex2PhotonReventar {

    private static enum OpeningChoice {
        start_game,
        change_settings,
        end_application;

        public static OpeningChoice fromInteger(int x) {
            switch (x) {
                case 0:
                    return start_game;
                case 1:
                    return change_settings;
                case 2:
                    return end_application;
            }
            return null;
        }
    }

    private static final List<String> OpeningChoiceStrings = Arrays.asList(
        "Start Game!",
        "Change Settings.",
        "End Application."
    );

    private OpeningChoice show_open() {
        // print
        System.out.println(String.join(
            "\n",
            "Welcome to Higher or Lower!",
            "  What do you want to do? ",
            String.join("\n", OpeningChoiceStrings)
        ));

        System.out.print("\n> ");
        Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();
        reader.close();
        line = line.toLowerCase();

        // loop over all the choices
        for (int i = 0; i < OpeningChoiceStrings.size(); ++i) {
            if (
                line.contains(
                    OpeningChoiceStrings
                        .get(i) // get the pertinent sting in the array
                        .toLowerCase() // lowercase it
                        .replaceAll("\\s.*", "") // remove after the space
                ) ||
                line.contains(Integer.toString(i)) // or has the same number
            ) {
                return OpeningChoice.fromInteger(i);
            }
        }

        return null;
    }

    private Map<String, String> settings = Map.ofEntries(
        Entry("guesses", "3")
    );

    private Map<String, String> change_settings () {
        
    }

    private boolean play_game () {
        return false;
    };

    public void start() {
        boolean repeat = true;
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
            }
        } while (repeat);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}