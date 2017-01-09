package guitarheromusicconverter;

public class GuitarHeroMusicConverter {

    
    public static void main(String[] args) {
        
       Data data = new Data();
       String response = data.uploadSong("https://jakekarasik.com/Idols.ogg");
       Notes[] notes = data.downloadSongData(response);
       System.out.println("response="+response);
       for (int i=0,len=notes.length;i<len;i++) {
           System.out.println(notes[i]);
       }
       
       
    }
    
    
     
}
