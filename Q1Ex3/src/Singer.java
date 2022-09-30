public class Singer {
    String name;
    int noOfPerformances;
    double earnings;
    Song favoriteSong;

    public Singer (String name, Song favoriteSong) {
        this.name = name;
        this.noOfPerformances = 0;
        this.earnings = 0.0;
        this.favoriteSong = favoriteSong;
    }

    public void performForAudience(int audienceSize) {
        this.noOfPerformances += 1;
        this.earnings += audienceSize * 100.0;
    }

    public void changeFavSong(Song newFav) {
        this.favoriteSong = newFav;
    }

    @Override
    public final String toString() {
        return String.format(
            "Name: %s%nNumber of Performances: %d%nEarnings total: %.2f%nFavorite song: %s%n%n",
            this.name,
            this.noOfPerformances,
            this.earnings,
            this.favoriteSong.title
        );
    }
}
