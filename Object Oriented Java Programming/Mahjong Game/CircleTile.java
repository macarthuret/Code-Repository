import java.awt.*;
import java.util.*;

import javax.swing.JFrame;

public class CircleTile extends RankTile 
{
	protected int centerX = 40;
	protected int centerY = 30;
	public static int rectSize;
	private int radius;
	private int numOfDots;
	public static Color green, blue, red;
	
	static
	{
		rectSize = 30;
		blue = Color.decode("#0f1e8c");
		green = Color.decode("#2c6b37");
		red = Color.decode("#ba1212");
	}

	private ArrayList<Circle> circles = new ArrayList<>();
	
	public CircleTile(int rank)
	{
		super(rank);
		radius = getDiameter();
		setToolTipText(toString());
	}
	
	public String toString()
	{
		return "Circle " + rank;
	}
	
	public int getDiameter()
	{
		int rSize = rectSize;
		numOfDots = rank;
		if(numOfDots % 2 == 0 && numOfDots % 3 != 0)
		{
			//Line
			if(numOfDots % 8 == 0)
			{
				rSize %= 8;
				return rSize + 1;
			}
			else
			{
				numOfDots /=  2;
				rSize /= 2;
				return rSize - 1;
			}
			
		}
		else if(numOfDots % 3 == 0 || numOfDots % 5 == 0)
		{
			//Diagonal
			rSize /= 3;
			return rSize - 1;
		}
		else
		{
			rSize  %= 8;
			return rSize + 1;
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
	        switch(rank)
	        {
	            case 1: circles=Tile1(); break;
	            case 2: circles=Tile2(); break;
	            case 3: circles=Tile3(); break;
	            case 4: circles=Tile4(); break;
	            case 5: circles=Tile5(); break;
	            case 6: circles=Tile6(); break;
	            case 7: circles=Tile7(); break;
	            case 8: circles=Tile8(); break;
	            case 9: circles=Tile9(); break;
	        }

		for (Circle c : circles)
		{
			if (c != null)
				c.draw(g);
		}
	}
	
	public ArrayList<Circle> Tile1()
	{
        int r = 27;
        int r2 = 10;
        
        circles.add(new Circle(centerX,centerY,r, green));
        circles.add(new Circle(centerX,centerY,11,Color.white));
        circles.add(new Circle(centerX,centerY,r2,red));

        int n = 10;
        int r3 = 3;
        for (int i = 0; i < n; i++) 
        {
            double t = 2 * Math.PI * i / n;
            int x = (int) Math.round(centerX + (r-8) * Math.cos(t));
            int y = (int) Math.round(centerY + (r-8) * Math.sin(t));
            circles.add(new Circle(x, y,r3, Color.white));
        }
        return circles;
	}
	
	public ArrayList<Circle> Tile2()
	{	
        int r = radius;
        
        circles.add(new Circle(centerX,centerY + r,r, red));
        circles.add(new Circle(centerX,centerY - r,r,green));

        return circles;
    }
	
	public ArrayList<Circle> Tile3()
	{	
        int r = radius;
        int m = 20;
        
        circles.add(new Circle(centerX - m,centerY - m,r, blue));
        circles.add(new Circle(centerX,centerY,r,red));
        circles.add(new Circle(centerX + m,centerY + m,r,green));

        return circles;
    }
	
	public ArrayList<Circle> Tile4()
	{	
        int r = radius;
        
        circles.add(new Circle(centerX - r,centerY + r,r, green));
        circles.add(new Circle(centerX + r,centerY + r,r,blue));
        circles.add(new Circle(centerX - r,centerY - r,r,blue));
        circles.add(new Circle(centerX + r,centerY - r,r,green));
        

        return circles;
    }
	
	public ArrayList<Circle> Tile5()
	{
        int r = radius;
        int m = 20;
        
        circles.add(new Circle(centerX - m,centerY + m,r, green));
        circles.add(new Circle(centerX + m,centerY + m,r,blue));
        circles.add(new Circle(centerX, centerY, r, red));
        circles.add(new Circle(centerX - m,centerY - m,r,blue));
        circles.add(new Circle(centerX + m,centerY - m,r,green));

        return circles;
	}
	
	public ArrayList<Circle> Tile6()
	{
        int r = radius;
        
        circles.add(new Circle(centerX - 15,centerY + 19,r, red));
        circles.add(new Circle(centerX + 15,centerY + 19,r,red));
        circles.add(new Circle(centerX - 15, centerY, r, red));
        circles.add(new Circle(centerX + 15, centerY, r, red));
        circles.add(new Circle(centerX - 15,centerY - 19,r,green));
        circles.add(new Circle(centerX + 15,centerY - 19,r,green));

        return circles;
	}
	
	public ArrayList<Circle> Tile7()
	{
        int r = radius;
        
        circles.add(new Circle(centerX - 20,centerY - 21,r, green));
        circles.add(new Circle(centerX,centerY - 15,r,green));
        circles.add(new Circle(centerX + 20, centerY - 9, r, green));
        circles.add(new Circle(centerX + 14, centerY + 7, r, red));
        circles.add(new Circle(centerX - 14,centerY + 7,r,red));
        circles.add(new Circle(centerX + 14,centerY + 21,r,red));
        circles.add(new Circle(centerX - 14,centerY + 21,r,red));

        return circles;
	}
	
	public ArrayList<Circle> Tile8()
	{
        int r = radius;
        
        circles.add(new Circle(centerX - 14,centerY + 21,r, blue));
        circles.add(new Circle(centerX + 14,centerY + 21,r,blue));
        circles.add(new Circle(centerX - 14, centerY + 7, r, blue));
        circles.add(new Circle(centerX + 14, centerY + 7, r, blue));
        circles.add(new Circle(centerX - 14,centerY - 7,r,blue));
        circles.add(new Circle(centerX + 14,centerY - 7,r,blue));
        circles.add(new Circle(centerX - 14,centerY - 21,r,blue));
        circles.add(new Circle(centerX + 14,centerY - 21,r,blue));

        return circles;
	}
	
	public ArrayList<Circle> Tile9()
	{
        int r = radius;
        int m = 20;
        
        circles.add(new Circle(centerX - m,centerY + m,r, blue));
        circles.add(new Circle(centerX, centerY + m, r, blue));
        circles.add(new Circle(centerX + m,centerY + m,r,blue));
        circles.add(new Circle(centerX - m, centerY, r, red));
        circles.add(new Circle(centerX + m, centerY, r, red));
        circles.add(new Circle(centerX, centerY, r, red));
        circles.add(new Circle(centerX - m,centerY - m,r,green));
        circles.add(new Circle(centerX + m,centerY - m,r,green));
        circles.add(new Circle(centerX, centerY - m, r, green));

        return circles;
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Circle Tiles");
		
		frame.add(new CircleTile(1));
		frame.add(new CircleTile(2));
		frame.add(new CircleTile(3));
		frame.add(new CircleTile(4));
		frame.add(new CircleTile(5));
		frame.add(new CircleTile(6));
		frame.add(new CircleTile(7));
		frame.add(new CircleTile(8));
		frame.add(new CircleTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}
