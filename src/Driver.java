public class Driver {
	public static void main(String[] args) {
		int [] x = new int [args.length];
		if (args.length > 0) {
			if (Integer.parseInt(args[0]) < 0){
				System.err.println(args[0] + "Must be greater than 0.");
			}
			else {
				Avg avgObject = new Avg();
				Min minObject = new Min();
				Max maxObject = new Max();
				Median medianObject = new Median();
				Sd sdObject = new Sd();
				
				for (int i = 0; i < args.length; i++) {
					x[i] = Integer.parseInt(args[i]);
					//System.out.println(x[i]);
				}
				
				Thread avgThread = new Thread(new AverageComp(x,avgObject));
				Thread minThread = new Thread(new MinComp(x,minObject));
				Thread maxThread = new Thread(new MaxComp(x,maxObject));
				Thread medianThread = new Thread(new MedianComp(x,medianObject));
				Thread sdThread = new Thread(new SdComp(x,sdObject));
				
				avgThread.start();
				minThread.start();
				maxThread.start();
				medianThread.start();
				sdThread.start();
				
				try {
					avgThread.join();
					maxThread.join();
					minThread.join();
					medianThread.join();
					sdThread.join();
					
					System.out.println("The average value is "+ avgObject.getAvg());
					System.out.println("The minimum value is "+ minObject.getMin());
					System.out.println("The maximum value is "+ maxObject.getMax());
					System.out.println("The median value is "+ medianObject.getMedian());
					System.out.println("The Standard Deviation value is "+ sdObject.getSd());
				} catch (InterruptedException ie) {}
			}
		}
		else 
			System.err.println("No arguments.");
	}
}
