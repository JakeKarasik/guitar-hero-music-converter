package guitarheromusicconverter;

public class GuitarHeroMusicConverter {

    
    public static void main(String[] args) {
      
       Data data = new Data();
       String songID = data.uploadSong("howtosavealife.mp3");
       System.out.println("songID="+songID);
       
        if (songID != null) {
            Melody melody = data.downloadMelody(songID);
            for (int i=0,len=melody.result.notes.length;i<len;i++) {
            System.out.println(melody.result.notes[i]);
            }

            Chord chord = data.downloadChords(songID);
            System.out.println("songID="+songID);
            for (int i=0,len=chord.result.chords.length;i<len;i++) {
                System.out.println(chord.result.chords[i]);
            }
        } 
    }
}
