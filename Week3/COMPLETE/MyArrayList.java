package week3;

public class MyArrayList {
	
	private String[] array;
	private int size;
	private int stored;
	
	public MyArrayList()
	{
		this.array = new String[10];
		this.size = 10;
		this.stored = 0;
	}
	
	public void add(String string)
	{
		if(size == stored)
		{
			size += 10;
			String[] array1 = new String[size];
			for(int i = 0; i < (this.array).length; i++)
			{
				array1[i] = this.array[i];
			}
			this.array = array1;
			this.array[stored] = string;
			stored++;
			
		}
		else
		{
			this.array[stored] = string;
			stored++;
		}
	}
	public String getString(int i)
	{
		if (i < stored && i >= 0)
		{
			return this.array[i];
		}
		else 
		{
			System.out.println("Index out of bounds!");
			return null;
		}
	}
}