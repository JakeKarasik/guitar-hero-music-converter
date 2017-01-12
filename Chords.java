package guitarheromusicconverter;

public class Chords {

	public int index;
	public double time;
	public String chord;

	public Chords(int index, double time, String chord){
		
    	
        this.time = (double) Math.round(time * 100) / 100;;
		this.index = index;
		this.chord = chord;

	}

	public String toString(){
		return ("index="+index+", time="+time+", chord="+chord);
	}

}
