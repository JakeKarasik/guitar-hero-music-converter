package guitarheromusicconverter;

public class Chords {

	public int index;
	public float time;
	public String chord;

	public Chords(int index, float time, String chord){
		this.index = index;
		this.time = time;
		this.chord = chord;

	}

	public String toString(){
		return ("index="+index+", time="+time+", chord="+chord);
	}

}
