package guitarheromusicconverter;

import java.io.IOException;
import java.io.PrintWriter;

public class Chart {
        
    public String name, artist, music_stream, song_data = "", sync_track = "", events = "", hard = "", medium = "", easy = "";
    public int resolution, end_time;

    public Chart(String name, String artist, String music_stream, int resolution) {

        this.name = name; // name of song
        this.artist = artist; // artist of song
        this.resolution = resolution;
        this.music_stream = music_stream; //song file
        setSongData();
        setSyncTrack();
        setEvents();
        write();
    }
    
    public void setSongData(){
        
        this.song_data += "[Song]\n{\n";
        this.song_data += "\tName = \"" + this.name + "\"\n";
        this.song_data += "\tArtist = \"" + this.artist + "\"\n";
        this.song_data += "\tCharter = \"Jake K and Sam U\"\n";
        this.song_data += "\tOffset = 0\n";
        this.song_data += "\tResolution = " + this.resolution + "\n";
        this.song_data += "\tPlayer2 = bass\n";
        this.song_data += "\tDifficulty = 0\n";
        this.song_data += "\tPreviewStart = 0.00\n";
        this.song_data += "\tPreviewEnd = 0.00\n";
        this.song_data += "\tGenre = \"alternative\"\n";
        this.song_data += "\tMediaType = \"cd\"\n";
        this.song_data += "\tMusicStream = \"" + this.music_stream + "\"\n"; 
        this.song_data += "}";
    }


    public void setSyncTrack(){

        this.sync_track += "[SyncTrack]\n{\n}";
        
    }

    public void setEvents(){

        this.events += "[Events]\n{\n\t"+this.end_time+" = E \"end\"\n}";
        
    }

    public void setHard(){

    }
    
    public void write(){
        
        try {
            
            PrintWriter writer = new PrintWriter(this.name.replaceAll("\\s","").toLowerCase() + ".chart");

            writer.println(this.song_data);
            writer.println(this.sync_track);
            writer.println(this.events);
            
            writer.close();
        } catch (IOException e){
            
            System.err.println("Error: " + e.getMessage());
        }
    }
}