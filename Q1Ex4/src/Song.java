public class Song {

    private String title;
    private String composer;
    private int year_of_creation; // TODO: change to date format

    public Song(String title, String composer, int year_of_creation) {
        this.title = title;
        this.composer = composer;
        this.year_of_creation = year_of_creation;
    }

    public final String get_composer() {
        return this.composer;
    }

    public final String get_title() {
        return this.title;
    }

    public final int get_year_of_creation() {
        return this.year_of_creation;
    }

    @Override
    public final String toString() {
        return String.format(
            "Title: %s%nComposer: %s%nYear of Creation: %s%n%n",
            title,
            composer,
            Integer.toString(year_of_creation)
        );
    }
}
