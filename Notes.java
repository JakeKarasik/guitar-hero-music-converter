package guitarheromusicconverter;

 public class Notes {
        
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
        
      
    }
