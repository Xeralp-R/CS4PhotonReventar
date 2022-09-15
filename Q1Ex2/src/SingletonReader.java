import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

// apparently, you need this to read properly

public class SingletonReader {
    // singleton part
    private static final SingletonReader instance = new SingletonReader();

    private SingletonReader() {}
    public static SingletonReader get_instance() {
        return instance;
    }

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public Optional<String> read_line_quietly () {
        try {
            return Optional.of(reader.readLine());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
    public String read_line() throws IOException {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw e;
        }
    }
}
