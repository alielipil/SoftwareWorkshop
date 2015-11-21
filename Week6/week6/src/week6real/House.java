package week6real;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class House extends JComponent{

	private int xCoord;
	private int yCoord;
	private int houseSize;
	private Line2D.Double roofLeft;
	private Line2D.Double roofRight;
	private Ellipse2D.Double doorKnob;

	/**
	 * Create roof lines left and right and doorKnob of the house. 
	 * Constructs a component with specified coordinates for house location
	 * @param xCoord the x coordinate of the top left corner for the main body of the house
	 * @param yCoord the y coordinate of the top left corner for the main body of the house
	 * @param houseSize the width and height of the main body of the house (everything scaled from this)
	*/
	public House(int xCoord, int yCoord, int houseSize)
	{		
		super();
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.houseSize = houseSize;
		roofLeft = new Line2D.Double(xCoord, yCoord, xCoord + (houseSize/2), yCoord - (houseSize/3));
		roofRight = new Line2D.Double(xCoord + (houseSize/2), yCoord -(houseSize/3), xCoord + houseSize, yCoord);
		doorKnob = new Ellipse2D.Double(xCoord + ((houseSize/2) + (houseSize/12)),  yCoord + ((houseSize/2) + (houseSize/4)), houseSize/40 ,houseSize/40 );
	}
	
	/**
	 * Draw the house on a graphics object
	 * @param g the graphics object
	*/
	public void draw(Graphics2D g)
	{
        Graphics2D g2 = (Graphics2D)g;
		
		Rectangle house = new Rectangle(xCoord, yCoord, houseSize, houseSize);
		Rectangle door = new Rectangle(xCoord + ((houseSize/2) + (houseSize/18)), yCoord+ (houseSize/2), houseSize/4, houseSize/2);
		Rectangle window1 = new Rectangle(xCoord+ (houseSize/10), yCoord+ ((houseSize/2) + (houseSize/15)), houseSize/3, houseSize/4);
		Rectangle window2 = new Rectangle(xCoord+ (houseSize/10), yCoord+ (houseSize/10), houseSize/5, houseSize/4);
		Rectangle window3 = new Rectangle(xCoord+ ((houseSize/2) - (houseSize/10)), yCoord+ (houseSize/10), houseSize/2, houseSize/4);
		//g.setColor(Color.BLACK);
		g2.draw(door);
		g2.draw(house);
		g2.draw(roofLeft);
		g2.draw(roofRight);
		g2.draw(window1);
		g2.draw(window2);
		g2.draw(window3);
		g2.draw(doorKnob);
	}
	/**
	 * x coord of house
	 * @return x coordinate of main house body
	 */
	public int getHouseX()
	{
		return xCoord;
	}
	/**
	 * y coord of house
	 * @return y coordinate of main house body
	 */
	public int getHouseY()
	{
		return yCoord;
	}
	/**
	 * scale of house
	 * @return the width of main house body
	 */
	public int getHouseSize()
	{
		return houseSize;
	}
}
	
	
