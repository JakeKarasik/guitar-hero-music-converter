package guitarheromusicconverter;

//import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class ChartWrite {
	
	
	
	public void writeChart(String name){
		try{
			PrintWriter writer = new PrintWriter(name + ".chart");
			
			writer.close();
		} catch (IOException e){
			System.err.println("Could not create file.");
		}
	}
}
