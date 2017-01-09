package guitarheromusicconverter;

public class FileDownload {
    public Status status;
    public MelodyResult melody_result;
    
    public FileDownload(Status status, MelodyResult melody_result) {
        this.status.code = status.code;    
        this.melody_result = new MelodyResult(melody_result.key, melody_result.key_index, melody_result.tuning_frequency, melody_result.notes);
    }
    
    public class Status {
        
        public int code;
        
        public Status(int code) {
            this.code = code;
        }
    }
    
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
}
