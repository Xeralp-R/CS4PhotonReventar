public class App {

    public static void main(String[] args) throws Exception {
		// Taken from the other class
        // generate songs
        var song1 = new Song(
            "All I Want for Christmas is You",
            "Mariah Carey",
            1994
        );

        var song2 = new Song("Christmas in Our Hearts", "Jose Mari Chan", 1990);

        // generate singers
        var singer1 = new Singer("Mark Xavier Tarcelo", song1);
		var singer2 = new Singer("Joshua Quentin Tarcelo", song2);
		
		// perform for audiences alone
        singer1.performForAudience(12);
		singer2.performForAudience(12);
		
		// perform for audiences together
		singer1.performForAudience(singer2, 24);
		
		// change fav song
        singer1.changeFavSong(song2);

        System.out.println(singer1.toString());
		System.out.println(singer2.toString());
    }
}
