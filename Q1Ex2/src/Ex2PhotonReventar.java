import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map.entry;  
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

        for (int i = 0; i < OpeningChoiceStrings.size(); ++i) {
            if (
                line.contains(
                    OpeningChoiceStrings
                        .get(i)
                        .toLowerCase()
                        .replaceAll("\\s.*", "")
                ) ||
                line.contains(Integer.toString(i))
            ) {
                return OpeningChoice.fromInteger(i);
            }
        }

        return null;
    }

    private Map<String, String> settings = Map.ofEntries(
        
    );

    private void change_settings () {

    }

    private boolean play_game () {
        return false;
    };

    public void start() {
        boolean repeat = true;
        do {
            OpeningChoice choice = show_open();

            switch (choice) {
                case null:
                System.out.println("Entry not valid. Please try again.");
                break;

                case start_game:
                boolean repeat_game = true;
                do {
                    repeat_game = play_game();
                } while (repeat_game);
                break;

                case change_settings:

            }
        } while (repeat);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
