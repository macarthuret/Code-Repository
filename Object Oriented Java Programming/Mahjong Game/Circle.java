import java.awt.*;
import java.util.*;

public class Circle 
{
	private int x, y, r;
	private Color c;
	
	public Circle(int centerX, int centerY, int radius, Color c)
	{
        this.r = radius;
        this.x = centerX;
        this.y = centerY;
        this.c = c;
	}
	
	public void draw(Graphics g)
	{
		int d = 2 * r;
		if(r > 25)
		{
			g.setColor(c);
			g.fillOval(x - r, y - r, d, d);
		}
		else
		{
			g.setColor(c);
			g.fillOval(x - r, y - r, d, d);
			g.setColor(Color.white);
			g.drawLine(x + (r/2), y + (r/2), x - (r/2), y - (r/2));
			g.drawLine(x - (r/2), y + (r/2), x + (r/2), y - (r/2));
		}
	}
}
