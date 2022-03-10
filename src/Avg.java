
public class Avg {
	
	private int avg;
	
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
}

class AverageComp implements Runnable{
	
	private int[] array;
	private Avg avgValue;

	public AverageComp(int [] array, Avg avgValue) {
		this.array = array;
		this.avgValue = avgValue;
	}
	public void run() {
		int average = 0;
		for (int i = 0; i < array.length; i++) {
			average = array[i] + average;	
		}
		average = average/array.length;
		avgValue.setAvg(average);
		//System.out.println(average);
	}
}
