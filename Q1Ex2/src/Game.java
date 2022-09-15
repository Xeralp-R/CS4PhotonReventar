// the game proper

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

    public boolean play() {
        // generate the number and prepare other vars
        int true_num = (int) Math.floor(
            Math.random() * (settings.upper_limit - settings.lower_limit)
        ) +
        settings.lower_limit;
        int guesses_left = settings.guesses;
        boolean overdrive = false;

        // begin printing
        System.out.printf(
            "Guess the number! It's between %d and %d.%n",
            settings.lower_limit,
            settings.upper_limit
        );

        interior:while (true) {
            // take in input
            System.out.print("> ");
            var line = SingletonReader.get_instance().read_line_quietly();
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

                    var input = SingletonReader.get_instance().read_line_quietly();
                    switch (input.toLowerCase()) {
                        case "y":
                        case "yes":
                            return true;
                        default:
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
                    var input = SingletonReader.get_instance().read_line_quietly();
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
