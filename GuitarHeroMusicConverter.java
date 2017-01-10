package guitarheromusicconverter;

public class GuitarHeroMusicConverter {

    
    public static void main(String[] args) {
      
       Data data = new Data();
       String songID = data.uploadSong("https://jakekarasik.com/Idols.ogg");
       MelodyResult mr = data.downloadSongMelody(songID);
       System.out.println("response="+songID);
       for (int i=0,len=mr.notes.length;i<len;i++) {
           System.out.println(mr.notes[i]);
       }
       
       
    }
    
    
     
}
