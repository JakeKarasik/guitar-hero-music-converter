package guitarheromusicconverter;

public class MelodyResult {
    
    public String key;
    public int key_index;
    public float tuning_frequency;
    public Notes notes[];
    
    public MelodyResult(String key, int key_index, float tuning_frequency, Notes notes[]) {
        this.key = key;
        this.key_index = key_index;
        this.tuning_frequency = tuning_frequency;
        
        for (int i=0,len=notes.length;i<len;i++) {
            this.notes[i].midi_pitch = notes[i].midi_pitch;
            this.notes[i].onset_time = notes[i].onset_time;
            this.notes[i].duration = notes[i].duration;
            this.notes[i].volume = notes[i].volume;
        }
    }
}