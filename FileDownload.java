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
}
