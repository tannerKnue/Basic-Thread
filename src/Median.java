
public class Median {
	
	private int median;
	
	public int getMedian() {
		return median;
	}
	public void setMedian(int median) {
		this.median = median;
	}
}

class MedianComp implements Runnable{
	
	private int[] array;
	private Median medianValue;

	public MedianComp(int [] array, Median medianValue) {
		this.array = array;
		this.medianValue = medianValue;
	}
	public void run() {
		int median = 0;
		int x = 0;
		int y = 0;
		Sort(array);
		if (array.length%2 == 1)
			median = array[((array.length)/2)-1];
		else {
			x = array[(array.length)/2];
			y = array[(array.length/2) -1]; 
			System.out.println(x);
			System.out.println(y);
			median = (x+y)/2;
		}
		medianValue.setMedian(median);
	}
	public int[] Sort(int [] array) {
		int minIndex;
		int tmp; 
		for (int i = 0; i < array.length -1; i++) { 
			minIndex = i;
			for(int j = i+1; j < array.length; j++) {
				if (array[j] < array[minIndex]) 
		            minIndex = j;
				if(minIndex != i) {
					tmp = array[i];
					array[i] = array[minIndex];
					array[minIndex] = tmp;
				}
			}
		
		}
		return array;
	}
}
