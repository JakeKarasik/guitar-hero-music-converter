package guitarheromusicconverter;

public class GuitarHeroMusicConverter {

    
    public static void main(String[] args) {
      
<<<<<<< HEAD
       Data data = new Data();
       String songID = data.uploadSong("https://www.jakekarasik.com/The%20Fray%20-%20How%20to%20Save%20a%20Life.mp3");

       Melody melody = data.downloadMelody(songID);
       System.out.println("songID="+songID);
       //System.out.println(melody);
       for (int i=0,len=melody.result.notes.length;i<len;i++) {
           System.out.println(melody.result.notes[i]);
       }
       
       Chord chord = data.downloadChords(songID);
       System.out.println("songID="+songID);
       for (int i=0,len=chord.result.chords.length;i<len;i++) {
           System.out.println(chord.result.chords[i]);
       }
    }
    
    
     
=======
        Data data = new Data();
        String songID = data.uploadSong("https://jakekarasik.com/Idols.ogg");
        MelodyResult mr = data.downloadSongMelody(songID);
        System.out.println("songID="+songID);
        for (int i=0,len=mr.notes.length;i<len;i++) {
            System.out.println(mr.notes[i]);
        }
    }    
>>>>>>> b192f4d3d9a842ef83b2b99af0bbd46613bf3454
}
