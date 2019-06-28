import java.awt.*;

public class Bamboo
{
	private int x, y;
	private Color c;
	
	public Bamboo(int centerX, int centerY, Color c)
	{
		this.x = centerX;
		this.y = centerY;
		this.c = c;
	}
	
	public void draw(Graphics g)
	{
		 int[] xl = {x-4,x-5,x-5,x-3,x-3,x-4,x-5,x-5,x-3,x-3,x-4,x-5,x-5,
				 x+5,x+5,x+4,x+3,x+3,x+5,x+5,x+4,x+3,x+3,x+5,x+5,x+4
		 };
		 
		 int[] yl = {y-9,y-8,y-5,y-5,y-2,y-2,y-1,y+2,y+2,y+6,y+6,y+7,y+10,
				 y+10,y+7,y+6,y+6,y+2,y+2,y-1,y-2,y-2,y-5,y-5,y-8,y-9
		 };
		
		 Polygon stick = new Polygon(xl, yl, 26);
		 
		 g.setColor(c);
		 g.fillPolygon(stick);
		 g.setColor(Color.white);
		 g.drawLine(x, y-8, x, y-2);
		 g.drawLine(x, y+2, x, y+8);
	}
}
