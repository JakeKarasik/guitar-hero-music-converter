package guitarheromusicconverter;

//import guitarheromusicconverter.FileDownload.Status;

public class KeyResult {
	
	public Status status;
	public KeyResult key_result;
    public String key;
    public int key_index;
    public float tuning_frequency;
    public Notes notes[];
    
    public KeyResult(Status status, KeyResult key_result) {
        
        this.status.code = status.code;    
        this.key_result = new KeyResult(key_result.key, key_result.key_index, key_result.tuning_frequency, key_result.notes);
    }	
    
    public KeyResult(String key, int key_index, float tuning_frequency, Notes notes[]) {
   
    	this.key = key;
        this.key_index = key_index;
        this.tuning_frequency = tuning_frequency;
        
        for (int i=0,len=notes.length;i<len;i++) {
            this.notes[i].midi_pitch = notes[i].midi_pitch; //where the note is on the track
            this.notes[i].onset_time = notes[i].onset_time; //what time the note starts
            this.notes[i].duration = notes[i].duration; //how long the note lasts
            this.notes[i].volume = notes[i].volume; //irrelevant info
        }
    }
    
}