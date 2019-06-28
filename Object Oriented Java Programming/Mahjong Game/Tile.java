import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Tile extends JPanel
{
	private static Dimension SIZE;
	private static Polygon left, bottom, bl, m;
	private static Color c1, c2, b1, b2;
	private static Rectangle2D top;
	private static GradientPaint gp1, gp2;
	private int x,y,z;
	
	static {
		SIZE = new Dimension(70, 80);
		
        c1 = Color.decode("#4e6ea3");
        b1 = Color.decode("#FDF5E6");
        c2 = Color.decode("#0a295b");
        b2 = Color.decode("#ddcab1");
		
		int[] xl = {10, 5, 5, 10};
		int[] yl = {0, 10, 70, 60};
		left = new Polygon(xl, yl, 4);

        //Bottom
        int[] xb = {0, 5, 65, 60};
        int[] yb = {80, 70, 70, 80};
        bottom = new Polygon(xb, yb, 4);

        //Bottom-Left
        int[] xbl = {0, 5, 5, 0};
        int[] ybl = {20, 10, 70, 80};
        bl = new Polygon(xbl, ybl, 4);
        
        //Middle
        int[] xm = {5, 10, 70, 65};
        int[] ym = {70, 60, 60, 70};
        m = new Polygon(xm, ym, 4);
        
        //g.drawRect(10, 0, 60, 60);
        top = new Rectangle2D.Double(10, 0, 60, 60);
        
        gp1 = new GradientPaint(0,0,c1,70,0,c2,true);
        gp2 = new GradientPaint(5,70,b1,70,0,b2,true);
	}
	
	public Tile() {
		setPreferredSize(SIZE);
		setSize(SIZE);
		setOpaque(true);
	}
	
	public boolean matches(Tile other)
	{
		if(getClass() == other.getClass())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
        
        //Left
        g2.setPaint(gp2);
        g2.fillPolygon(left);
        
        //Bottom
        g2.setPaint(gp1);
        g2.fillPolygon(bottom);
        
        //Bottom Left
        g2.setPaint(Color.decode("#4e6ea3"));
        g2.fillPolygon(bl);
        
        //Middle & Top
        g2.setPaint(gp2);
        g2.fillPolygon(m);
        g2.fill(top);
        
		//Draw
        g2.setPaint(Color.black);
		g2.draw(left);
		g2.draw(bottom);
        g2.draw(bl);
        g2.draw(m);
        g.drawRect(10,0,59,60);
	}
	
	public void setCoords(int[] c)
	{
		this.z = c[0];
		this.x = c[1];
		this.y = c[2];
	}
	
	public int[] getCoords()
	{
		int[] c = {z,y,x};
		return c;
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tile");

		frame.add(new Tile());
		frame.add(new Tile());
		frame.add(new Tile());

		frame.pack();
		frame.setVisible(true);
	}
}
