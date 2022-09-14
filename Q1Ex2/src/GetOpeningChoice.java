// gets the opening choice

import java.util.Scanner;

public class GetOpeningChoice {

    public static OpeningChoice get_opening_choice() {
        Scanner reader = new Scanner(System.in);

        while (true) {
            // print out choices
            System.out.println(
                String.join(
                    "\n",
                    "Welcome to Higher or Lower!",
                    "What do you want to do?",
                    String.join("\n", OpeningChoice.string_equivalents)
                )
            );
            System.out.print("> ");

            // get input
            String line = reader.nextLine();
            line = line.toLowerCase();

            // process input
            // how? loops over all the choices
            for (int i = 0; i < OpeningChoice.string_equivalents.length; ++i) {
                if (
                    line.contains(
                        OpeningChoice
                            .string_equivalents[i].toLowerCase() // get the pertinent sting in the array // lowercase it
                            .replaceAll("\\s.*", "") // remove after the space
                    )
                ) {
                    reader.close();
                    return OpeningChoice.fromInteger(i);
                }
            }

            // if it wasn't processed:
            System.out.println("Unclear input— please try again.\n");
            // loop back to the top.
        }
    }
}
