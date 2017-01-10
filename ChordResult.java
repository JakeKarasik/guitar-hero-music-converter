package guitarheromusicconverter;

//import guitarheromusicconverter.MelodyResult.Status;

public class ChordResult {
    
	public Status status;
	public ChordResult chord_result;
    public String key;
    public int key_index;
    public float tuning_frequency;
    public Notes notes[];
   
    public ChordResult(Status status, ChordResult chord_result) {
        
        this.status.code = status.code;    
        this.chord_result = new ChordResult(chord_result.key, chord_result.key_index, chord_result.tuning_frequency, chord_result.notes);
    }	
        
    public ChordResult(String key, int key_index, float tuning_frequency, Notes notes[]) {
  
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