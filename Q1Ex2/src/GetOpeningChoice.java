// gets the opening choice

public class GetOpeningChoice {

    public static OpeningChoice get_opening_choice() {
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
            String line = "";
            try {
                line = SingletonReader.get_instance().read_line();
            } catch (Exception e) {
                System.err.println("Absurd entry. Trying again...");
                continue;
            }
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
                    return OpeningChoice.fromInteger(i);
                }
            }

            // if it wasn't processed:
            System.out.println("Unclear input— please try again.\n");
            // loop back to the top.
        }
    }
}
