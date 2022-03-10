
public class Min {
	
	private int min;
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
}

class MinComp implements Runnable{
	
	private int[] array;
	private Min minValue;

	public MinComp(int [] array, Min minValue) {
		this.array = array;
		this.minValue = minValue;
	}
	public void run() {
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min)
				min = array[i];
		}
		minValue.setMin(min);
		//System.out.println(min);
	}
}