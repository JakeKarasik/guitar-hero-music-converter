package guitarheromusicconverter;

public class SongContent {

	Object[] content;
	String name, artist, charter, player2, genre, mediaType, musicStream;
	double offset, previewStart, previewEnd;
	int resolution, difficulty;
	
	public Object[] song(){
		content = new Object[12];
		content[0] = name = "";
		content[1] = artist = "";
		content[2] = charter = "";
		content[3] = offset = 0.0;
		content[4] = resolution = 0;
		content[5] = player2 = "";
		content[6] = difficulty = 0;
		content[7] = previewStart = 0.0;
		content[8] = previewEnd = 0.0;
		content[9] = genre = "";
		content[10] = mediaType = "";
		content[11] = musicStream = "";
		return content;
	}
	
	public void setName(String s){
		this.content[0] = s;
	}
	public void setArtist(String s){
		this.content[1] = s;
	}
	public void setCharter(String s){
		this.content[2] = s;
	}
	public void setOffset(double d){
		this.content[3] = d;
	}
	public void setResolution(int i){
		this.content[4] = i;
	}
	public void setPlayer2(String s){
		this.content[5] = s;
	}
	public void setDifficulty(int i){
		this.content[6] = i;
	}
	public void setPreviewStart(double d){
		this.content[7] = d;
	}
	public void setPreviewEnd(double d){
		this.content[8] = d;
	}
	public void setGenre(String s){
		this.content[9] = s;
	}
	public void setMediaType(String s){
		this.content[10] = s;
	}
	public void setMusicStream(String s){
		this.content[11] = s;
	}
}
