public class App {

    public static void main(String[] args) throws Exception {
        // Part 1
        var req1 = new Requirement(1, Requirement.Subject.Math, "Q1", true);
        var req2 = new Requirement(
            2,
            Requirement.Subject.Physics,
            "LT1",
            false
        );
        var req3 = new Requirement(
            3,
            Requirement.Subject.CS,
            "Exercise 03",
            false
        );

        System.out.println(req1.toString());
        System.out.println(req2.toString());
        System.out.println(req3.toString());

        // Part 2
        var song1 = new Song(
            "All I Want for Christmas is You",
            "Mariah Carey",
            1994
        );

        var song2 = new Song("Christmas in Our Hearts", "Jose Mari Chan", 1990);

        System.out.println(song1.toString());
        System.out.println(song2.toString());

        // Part 3
        var singer1 = new Singer("Mark Xavier Tarcelo", song1);
        singer1.performForAudience(12);
        singer1.changeFavSong(song2);

        System.out.println(singer1.toString());
    }
}
