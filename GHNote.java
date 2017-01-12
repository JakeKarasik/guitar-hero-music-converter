package guitarheromusicconverter;

public class GHNote {

	public double time; //when it starts
	public double duration; //how long its held
	public int track; //which track it appears on left to right
	public String chord; //additional notes if applicable
	
	public GHNote(double time, double duration, int track, String chord){
		this.time = time;
		this.duration = duration;
		this.track = track;
		this.chord = chord;
	}
}
