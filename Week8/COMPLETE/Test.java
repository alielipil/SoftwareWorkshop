package week8;

public class Test {
	
	public static void main(String[] args)
	{
		Easter easter = new Easter(2016);
		System.out.println(easter.getDay());
		System.out.println(easter.getMonth());
		System.out.println(easter.getYear());
		easter.setYear(2200);
		System.out.println(easter.getDay());
		System.out.println(easter.getMonth());
		System.out.println(easter.getYear());
	}

}
