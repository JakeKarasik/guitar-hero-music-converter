package guitarheromusicconverter;

import com.google.gson.annotations.SerializedName;

public class Melody {
	public Status status;
	@SerializedName("melody_result") 
	Result result;
	
	public Melody(Status status, Result r) {
		this.status.code = status.code;    
		this.result = new Result(r.key, r.key_index, r.tuning_frequency,r.notes);
	}	

	public class Result{

		public String key;
		public int key_index;
		public float tuning_frequency;
		public Notes notes[];
		
		public Result(String key, int key_index, float tuning_frequency, Notes notes[]) {

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
}