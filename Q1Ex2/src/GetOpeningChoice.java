// gets the opening choice

import java.util.Scanner;

public class GetOpeningChoice {

    public static OpeningChoice get_opening_choice() {
        while (true) {
            // print out choices
            System.out.println(
                String.join(
                    "\n",
                    "Welcome to Higher or Lower!",
                    " What do you want to do?",
                    String.join("\n", OpeningChoice.string_equivalents)
                )
            );
            System.out.print("> ");

            // get input
            Scanner reader = new Scanner(System.in);
            String line = reader.nextLine();
            if (
                // is not a string within the string equivalents
                !OpeningChoice.string_equivalents
                    .toString()
                    .toLowerCase()
                    .contains(line.toLowerCase()) &&
                // is a number greater than the number of string equivalents
                !(
                    Integer.parseInt(line) <= OpeningChoice.string_equivalents.length &&
                    Integer.parseInt(line) > 0
                )
            ) {
                System.out.println("Unclear input— please try again.");
                reader.close();
                continue; // the outermost loop: go back around from the top
            }
            reader.close();
            line = line.toLowerCase();

            // process input
            // how? loops over all the choices
            for (int i = 0; i < OpeningChoice.string_equivalents.length; ++i) {
                if (
                    line.contains(
                        OpeningChoice.string_equivalents
                            [i] // get the pertinent sting in the array
                            .toLowerCase() // lowercase it
                            .replaceAll("\\s.*", "") // remove after the space
                    ) ||
                    line.contains(Integer.toString(i+1)) // or has the same number;
                    // i+1 as they'll input 1-3, not 0-2
                ) {
                    return OpeningChoice.fromInteger(i);
                }
            }

            // unreachable error
            return null;
        }
    }
}
