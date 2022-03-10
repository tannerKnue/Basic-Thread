
public class Max {
	
	private int max;
	
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
}

class MaxComp implements Runnable{
	
	private int[] array;
	private Max maxValue;

	public MaxComp(int [] array, Max maxValue) {
		this.array = array;
		this.maxValue = maxValue;
	}
	public void run() {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max)
				max = array[i];
		}
		maxValue.setMax(max);
		//System.out.println(max);
	}
}