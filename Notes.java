package guitarheromusicconverter;

import java.text.DecimalFormat;
import java.text.NumberFormat;

 public class Notes {
        
        public double midi_pitch, onset_time, duration, volume;
        
        public Notes(double midi_pitch, double onset_time, double duration, double volume) {
            
        	NumberFormat formatter = new DecimalFormat("#0.00");
        	
            this.midi_pitch = Double.parseDouble(formatter.format(midi_pitch));
            this.onset_time = Double.parseDouble(formatter.format(onset_time));
            this.duration = Math.round(duration*100)/100;
            this.volume = Math.round(volume*100)/100;
            
        }
        
        public String toString() {
            return "pitch=" + midi_pitch + ", onset_time=" + onset_time + ", duration=" + duration + ", volume=" + volume;   
        }
}
