import java.awt.*;
import javax.swing.*;

public class WhiteDragonTile extends Tile
{
	public static Color blue;
	
	static
	{
		blue = Color.decode("#0f1e8c");
	}
	
	public WhiteDragonTile()
	{
		setToolTipText(toString());
	}
	
	public String toString()
	{
		return "White Dragon";
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
	       Graphics2D g2 = (Graphics2D) g;

	        Stroke dash = new BasicStroke(5.0f,              
	                           BasicStroke.CAP_BUTT,    
	                           BasicStroke.JOIN_MITER,    
	                           10.0f,                     
	                           new float[] {4.0f, 0f, 4.0f},
	                           0.0f);         
	        
	        Stroke solid = new BasicStroke(5.0f);  

	        g2.setStroke(solid);
	        g2.setColor(Color.white);
	        Rectangle r = new Rectangle(17,7,45,45);
	        g2.draw(r);
	        
	        g2.setStroke(dash);
	        g2.setPaint(blue);
	        g2.draw(r);
	        

	        g2.setStroke(new BasicStroke());
	        g2.setColor(Color.black);
	        Rectangle r2 = new Rectangle(14,4,50,50);
	        Rectangle r3 = new Rectangle(20,9,39,40);
	        g2.draw(r2);
	        g2.draw(r3);
	}
}