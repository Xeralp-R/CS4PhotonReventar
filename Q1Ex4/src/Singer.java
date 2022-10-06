public class Singer {
    private String name;
    private int noOfPerformances;
    private double earnings;
    private Song favoriteSong;
	
	static protected int totalPerformances = 0;

    public Singer (String name, Song favoriteSong) {
        this.name = name;
        this.noOfPerformances = 0;
        this.earnings = 0.0;
        this.favoriteSong = favoriteSong;
    }
	
	protected void giveMoney (double money) {
		this.earnings += money;
	}
	
	protected void havePerformance() {
		this.noOfPerformances += 1;
	}

    public void performForAudience(int audienceSize) {
        this.noOfPerformances += 1;
		Singer.totalPerformances += 1;
		
        this.earnings += audienceSize * 100.0;
    }
	
	public void performForAudience(Singer costar, int audienceSize) {
		this.noOfPerformances += 1;
		costar.havePerformance();
		Singer.totalPerformances += 2;
		
		this.earnings += audienceSize * 50.0;
		costar.giveMoney(audienceSize * 50.0);
		
		// TODO: Make amenable to having mo0re than 1 costar
	}

    public void changeFavSong(Song newFav) {
        this.favoriteSong = newFav;
    }

    @Override
    public final String toString() {
        return String.format(
            "Name: %s%nNumber of Performances: %d%nEarnings total: %.2f%nFavorite song: %s%n%nPerformances by all singers: %s%n%n",
            this.name,
            this.noOfPerformances,
            this.earnings,
            this.favoriteSong.get_title(),
			this.totalPerformances
        );
    }
}
