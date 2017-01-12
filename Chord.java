package guitarheromusicconverter;

import com.google.gson.annotations.SerializedName;

public class Chord {
	public Status status;
	@SerializedName("chords_result") 
	Result result;
	
	public Chord(Status status, Result r) {

		this.status.code = status.code;    
		this.result = new Result(r.num_chords, r.chords);
	}	

	public class Result{

		public int num_chords;
		public Chords chords[];
		
		public Result(int num_chords, Chords chords[]) {
			
			for (int i=0,len=chords.length;i<len;i++) {
				this.chords[i].index = chords[i].index;
				this.chords[i].time = chords[i].time;
				this.chords[i].chord = chords[i].chord;
			}
		}
	}
}