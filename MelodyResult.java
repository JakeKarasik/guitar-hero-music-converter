package guitarheromusicconverter;

//import guitarheromusicconverter.FileDownload.Status;

public class MelodyResult {
	
	public Status status;
	public MelodyResult melody_result;
    public String key;
    public int key_index;
    public float tuning_frequency;
    public Notes notes[];
    
    public MelodyResult(Status status, MelodyResult melody_result) {
        
        this.status.code = status.code;    
        this.melody_result = new MelodyResult(melody_result.key, melody_result.key_index, melody_result.tuning_frequency, melody_result.notes);
    }	
    
    public MelodyResult(String key, int key_index, float tuning_frequency, Notes notes[]) {
   
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