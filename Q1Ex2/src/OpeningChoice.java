// the opening choice enum.

public enum OpeningChoice {
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

    public static final String[] string_equivalents = {
        "Start Game!",
        "Change Settings.",
        "End Application.",
    };
}
