package guitarheromusicconverter;

 public class Notes {
        
<<<<<<< HEAD
        public float midi_pitch, onset_time, duration, volume;
        
        public Notes(float midi_pitch, float onset_time, float duration, float volume) {
            
            this.midi_pitch = midi_pitch;
            this.onset_time = onset_time;
            this.duration = duration;
            this.volume = volume;
            
        }
        
        public String toString() {
            return "pitch=" + midi_pitch + ", onset_time=" + onset_time + ", duration=" + duration + ", volume=" + volume;   
        }
        
      
=======
    public float midi_pitch, onset_time, duration, volume;

    public Notes(float midi_pitch, float onset_time, float duration, float volume) {

        this.midi_pitch = midi_pitch;
        this.onset_time = onset_time;
        this.duration = duration;
        this.volume = volume;   
>>>>>>> b192f4d3d9a842ef83b2b99af0bbd46613bf3454
    }

    @Override
    public String toString() {

        return "pitch=" + midi_pitch + ",onset_time=" + onset_time + ",duration=" + duration + ",volume=" + volume;   
    } 
}
