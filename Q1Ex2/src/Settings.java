// the settings class.
// Should be a mutable record, but apparently, there are none.

import java.util.Objects;

public class Settings {

    public int guesses;
    public boolean allow_over_limit;

    public Settings(final int guesses, final boolean allow_over_limit) {
        this.guesses = Objects.requireNonNull(guesses);
        this.allow_over_limit = Objects.requireNonNull(allow_over_limit);
    }

    public final String settings_string() {
        return String.join(
            "\n",
            "Guesses: " + String.valueOf(guesses),
            "Allow over limit? " + String.valueOf(allow_over_limit)
        );
    }
}
