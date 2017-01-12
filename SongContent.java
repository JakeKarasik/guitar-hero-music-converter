package guitarheromusicconverter;

public class SongContent {

    public String name, artist, charter, player2, genre, media_type, music_stream;
    public double offset, preview_start, preview_end;
    public int resolution, difficulty;

    public SongContent(String name, String artist, String music_stream, int resolution){

        this.name = name; // name of song
        this.artist = artist; // artist of song
        this.charter = "Jake K and Sam U";
        this.offset = 0.0;
        this.resolution = resolution;
        this.player2 = "";
        this.difficulty = 0;
        this.preview_start = 0.0;
        this.preview_end = 0.0;
        this.genre = "rock";
        this.media_type = "cd";
        this.music_stream = music_stream; //song file
    }
}
