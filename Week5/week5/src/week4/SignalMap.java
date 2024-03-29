package week4;

public class SignalMap {

	private boolean[][] map;
	private int size;
	private double threshold;
	private Network network;
	
	/** Create SignalMap
	@param size the x y size of the array
	@param network the network used
	@param threshold the value defined as 'good' signal
	*/
	
	public SignalMap(int size, Network network, double threshold)
	{
		this.map = new boolean[size][size];
		this.network = network;
		this.size = size;
		this.threshold = threshold;
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j<size; j++)
			{
				if (network.getSignal(i,j) < threshold)
					map[i][j]= true;
				else
					map[i][j] = false;
					
			}
		}
	}
	/**
	 * displays a map of the areas of good and bad signal
	 */
	
	public void display()
	{
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j<size; j++)
			{
				if (this.map[i][j] == true)
					System.out.print("X\t");
				else
					System.out.print(" \t");
					
			}
			System.out.println("");
		}
	}
	/**
	 * percentage area with poor signal
	 * @return double value representing percentage of area with poor signal
	 */
	
	public double poorSignal()
	{
		double count = 0;
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j<size; j++)
			{
				if (this.map[i][j] == true)
					count++;			
			}
		}
		return (count/(Math.pow((double)this.size, 2))) * 100;
	}
	/**
	 * shows the transmitter giving the lowest percentage of poor signal when in its own network
	 * @return the transmitter providing the most signal
	 */
	public Transmitter important()
	{
		Network start = new Network();
		start.add(this.network.getTransmitter(0));
		double x =(new SignalMap(this.size, start, this.threshold)).poorSignal();
		int y = 0;
		for (int i = 0; i < this.network.size(); i++)
		{
			
			Network net = new Network();
			net.add(this.network.getTransmitter(i));
			//System.out.println((new SignalMap(this.size, net, this.threshold)).poorSignal());
			if (x > (new SignalMap(this.size, net, this.threshold)).poorSignal())
			{
				x =(new SignalMap(this.size, net, this.threshold)).poorSignal();
				y= i;
			}
		}
		
		return this.network.getTransmitter(y);
	}
	/**
	 * compares two networks and prints a map of where the the signal of the network given is higher.
	 * 'X' indicates that the signal of the network given as a param is higher in this position
	 *  than the network the method is called on
	 * @param network the network to compare to 
	 */
	public void compare(Network network)
	{
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j<size; j++)
			{
				if (this.network.getSignal(i, j) < network.getSignal(i, j))
					System.out.print("X\t");
				else
					System.out.print(" \t");
			}
			System.out.println("");
		}
	}
}
