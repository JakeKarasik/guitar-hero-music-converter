package guitarheromusicconverter;

public class GuitarHeroMusicConverter {


	public static void main(String[] args) {
		String fileloc = "C:\\Users\\angelo\\Desktop\\shelter.mp3";
		Data data = new Data(); //
		String songID = data.uploadSong(fileloc);
		System.out.println("songID="+songID);

		if (songID != null) {
			Melody melody = data.downloadMelody(songID);
			Chord chord = data.downloadChords(songID);
			ChartAlgo algo = new ChartAlgo(melody,chord);
			SongData sd = new SongData();
			new Chart(algo, sd);
		} 
		/*
		Data data = new Data();
		String songID = data.uploadSong("C:\\Users\\angelo\\Desktop\\shelter.mp3");
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
		}*/ 
	}
}
