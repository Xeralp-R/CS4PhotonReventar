import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Game {

    private Settings settings;

    private enum Status {
        higher,
        lower,
        correct,
    }

    public Game(Settings settings) {
        this.settings = settings;
    }

    private void close_reader(BufferedReader reader) {
        try {
            this.close_reader(reader);
        } catch (Exception e) {
            System.err.printf(
                "Reader could not be closed: see %s%n",
                e.toString()
            );
        }
    }

    private String read_line_safely(BufferedReader reader) {
        try {
            return reader.readLine();
        } catch (Exception e) {
            System.err.printf("Could not read from input: see %s%n", e.toString());
            return "";
        }
    }

    public boolean play() {
        // generate the number and prepare other vars
        int true_num = (int) Math.floor(
            Math.random() * (settings.upper_limit - settings.lower_limit)
        ) +
        settings.lower_limit;
        int guesses_left = settings.guesses;
        boolean overdrive = false;
        var reader = new BufferedReader(new InputStreamReader(System.in));

        // begin printing
        System.out.printf(
            "Guess the number! It's between %d and %d.%n",
            settings.lower_limit,
            settings.upper_limit
        );

        interior:while (true) {
            // take in input
            System.out.print("> ");
            var line = this.read_line_safely(reader);
            int guessed_num = -1;
            try {
                guessed_num = Integer.parseInt(line);
            } catch (Exception e) {
                System.out.println(
                    "You probably didn't enter an integer. Try again!"
                );
                continue;
            }

            // check if it's higher or lower
            // extracted out so that, if the processing gets more complex in
            // the future, for some reason, it can be easily changed
            Status current_status;
            if (guessed_num > true_num) {
                current_status = Status.higher;
            } else if (guessed_num < true_num) {
                current_status = Status.lower;
            } else {
                current_status = Status.correct;
            }

            // print out result
            switch (current_status) {
                case higher:
                    System.out.println("Whoops, your answer is too high!");
                    break;
                case lower:
                    System.out.println("Whoops, your answer is too low!");
                    break;
                case correct:
                    System.out.println("Exactly right!");
                    System.out.print(
                        "Would you like to play again? (y/anything else) "
                    );

                    var input = this.read_line_safely(reader);
                    switch (input.toLowerCase()) {
                        case "y":
                        case "yes":
                            this.close_reader(reader);
                            return true;
                        default:
                            this.close_reader(reader);
                            return false;
                    }
            }

            if (guesses_left > 1 && !overdrive) {
                guesses_left -= 1;

                if (guesses_left == 1) {
                    System.out.println(
                        "You still have 1 guess left. Try again!"
                    );
                } else {
                    System.out.printf(
                        "You still have %d guesses left. Try again!",
                        guesses_left
                    );
                }

                continue interior;
            } else if (guesses_left - 1 == 0) {
                System.out.println("Ah, you're out of guesses.");

                if (!settings.allow_over_limit) {
                    System.out.print(
                        "That's it! Play again? (y/anything else) "
                    );

                    // copied over from a previous thingy
                    var input = this.read_line_safely(reader);
                    switch (input.toLowerCase()) {
                        case "y":
                        case "yes":
                            this.close_reader(reader);
                            return true;
                        default:
                            this.close_reader(reader);
                            return false;
                    }
                }

                System.out.println(
                    "Well, that never stopped anybody— continue guessing!"
                );
                continue interior;
            }
        }
    }
}
