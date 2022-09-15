// the get settings quasi-function object.

import java.util.Arrays;

public class GetSettings {

    public static Settings get_settings(final Settings current_settings) {
        var temporary_settings = current_settings;

        exterior:while (true) {
            // print preliminary output
            System.out.println("Current settings:");
            System.out.println(temporary_settings.settings_string());
            System.out.println(
                "What would you like to change? (type \"exit\" to exit)"
            );
            System.out.print("> ");

            // get input
            String[] allowable_inputs = {
                "guesses",
                "allow over limit",
                "exit",
            };
            String final_input = null;
            while (true) {
                String input = "";
                try {
                    input = SingletonReader.get_instance().read_line();
                } catch (Exception e) {
                    System.err.println("Absurd entry. Trying again...");
                    continue exterior;
                }
                input = input.toLowerCase();

                if (!Arrays.asList(allowable_inputs).contains(input)) {
                    System.out.println(
                        "Your input was invalid— please try again."
                    );
                    System.out.print("> ");
                    continue;
                }

                final_input = input;
                break;
            }

            // act on that input
            // note: it would be more elegant to change it to an enum.
            // not right now, though, as it's not super necessary.
            // the only evidence is the leftover "default" case.
            switch (final_input) {
                case "guesses":
                    temporary_settings.guesses = change_guesses();
                    break;
                case "allow over limit":
                    System.out.println(
                        temporary_settings.allow_over_limit
                            ? "Switch to not allowing over the limit? (y for yes, anything else for no)"
                            : "Switch to allowing over the limit? (y for yes, anything else for no)"
                    );
                    System.out.print("> ");

                    var line = SingletonReader.get_instance().read_line_quietly();
                    if (line == "y") {
                        temporary_settings.allow_over_limit =
                            !temporary_settings.allow_over_limit;
                        System.out.println("Settings were changed.");
                    } else {
                        System.out.println("Nothing was changed.");
                    }
                    break;
                case "exit":
                    break exterior;
                default:
                // impossible
            }
        }

        return temporary_settings;
    }

    private static int change_guesses() {
        int returner = -1;

        while (true) {
            System.out.println(
                "How many guesses do you want to take? (1 to 5 only)"
            );
            System.out.print("> ");

            var input = SingletonReader.get_instance().read_line();
            try {
                // if it can parse the int right, return
                returner = Integer.parseInt(input);
                System.out.println("Settings were changed.");
                break;
            } catch (Exception e) {
                // if it can't, go back to the top
                System.out.println("Invalid input— please try again.");
                continue;
            }
        }

        return returner;
    }
}
