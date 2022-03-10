
public class Sd {
	
	private double sd;
	
	public double getSd() {
		return sd;
	}
	public void setSd(double sd) {
		this.sd = sd;
	}
}

class SdComp implements Runnable{
	
	private int[] array;
	private Sd sdValue;

	public SdComp(int [] array, Sd sdValue) {
		this.array = array;
		this.sdValue = sdValue;
	}
	public void run() {
		double average = 0;
		double stdDev = 0;
		for (int i = 0; i < array.length; i++) {
			average = array[i] + average;	
		}
		average = average/(double)array.length;
		for (int i = 0; i < array.length; i++) {
	            
			stdDev = stdDev + (array[i] - average)*(array[i] - average);
	            
	        }
		stdDev = stdDev/array.length;
		stdDev = Math.sqrt(stdDev);
		sdValue.setSd(stdDev);
	}
}