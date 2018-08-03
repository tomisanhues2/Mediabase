package resources;

public class IDManager {

    private static int totalMovieID = 0;

    public IDManager() {
        totalMovieID++;
        if (totalMovieID == 41) {
            totalMovieID = 1;
        }
    }

    public static int getTotalMovieID() {
        return totalMovieID;
    }
}
