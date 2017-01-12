package guitarheromusicconverter;

public class GuitarHeroMusicConverter {

    
    public static void main(String[] args) {
      
       Data data = new Data();
       String songID = data.uploadSong("howtosavealife.mp3");
       System.out.println("songID="+songID);
       
        if (songID != null) {
            //Melody melody = data.downloadMelody(songID);
            //Chord chord = data.downloadChords(songID);
            Chart chart = new Chart("How To Save A Life", "The Fray", "howtosavealife.mp3", 480);
        } 
    }
}