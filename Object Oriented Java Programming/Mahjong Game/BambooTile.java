import javax.swing.JFrame;
import java.awt.*;
import java.util.ArrayList;

public class BambooTile extends RankTile 
{
	protected int centerX = 40;
	protected int centerY = 30;
	public static Color blue, green, red;
	static
	{
		blue = Color.decode("#0f1e8c");
		green = Color.decode("#2c6b37");
		red = Color.decode("#ba1212");
	}
	
	private ArrayList<Bamboo> sticks = new ArrayList<>();
	
	public BambooTile(int rank)
	{
		super(rank);
		setToolTipText(toString());
	}
	
	public String toString()
	{
		return "Bamboo " + rank;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	     switch(rank)
	     {
	        case 2: sticks=Tile2(); break;
	        case 3: sticks=Tile3(); break;
	        case 4: sticks=Tile4(); break;
	        case 5: sticks=Tile5(); break;
	        case 6: sticks=Tile6(); break;
	        case 7: sticks=Tile7(); break;
	        case 8: sticks=Tile8(); break;
	        case 9: sticks=Tile9(); break;
	    }

		for (Bamboo b : sticks)
		{
			if (b != null)
				b.draw(g);
		}
	}

	public ArrayList<Bamboo> Tile2()
	{
		sticks.add(new Bamboo(centerX, centerY - 11, blue));
		sticks.add(new Bamboo(centerX, centerY + 10, green));	
		return sticks;
	}
	
	public ArrayList<Bamboo> Tile3()
	{
		sticks.add(new Bamboo(centerX, centerY - 11, blue));
		sticks.add(new Bamboo(centerX-12, centerY + 10, green));
		sticks.add(new Bamboo(centerX+12, centerY + 10, green));
		return sticks;
	}
	
	public ArrayList<Bamboo> Tile4()
	{
		sticks.add(new Bamboo(centerX-12, centerY - 11, blue));
		sticks.add(new Bamboo(centerX+12, centerY - 11, green));
		sticks.add(new Bamboo(centerX-12, centerY + 10, green));
		sticks.add(new Bamboo(centerX+12, centerY + 10, blue));
		return sticks;
	}
	
	public ArrayList<Bamboo> Tile5()
	{
		sticks.add(new Bamboo(centerX, centerY, red));
		sticks.add(new Bamboo(centerX-16, centerY - 11, green));
		sticks.add(new Bamboo(centerX+16, centerY - 11, blue));
		sticks.add(new Bamboo(centerX-16, centerY + 10, blue));
		sticks.add(new Bamboo(centerX+16, centerY + 10, green));
		return sticks;
	}
	
	public ArrayList<Bamboo> Tile6()
	{
		sticks.add(new Bamboo(centerX, centerY - 11, green));
		sticks.add(new Bamboo(centerX, centerY + 10, blue));
		sticks.add(new Bamboo(centerX-16, centerY - 11, green));
		sticks.add(new Bamboo(centerX+16, centerY - 11, green));
		sticks.add(new Bamboo(centerX-16, centerY + 10, blue));
		sticks.add(new Bamboo(centerX+16, centerY + 10, blue));
		return sticks;
	}
	
	public ArrayList<Bamboo> Tile7()
	{
		sticks.add(new Bamboo(centerX, centerY - 20, red));
		sticks.add(new Bamboo(centerX, centerY, blue));
		sticks.add(new Bamboo(centerX, centerY + 20, blue));
		sticks.add(new Bamboo(centerX-16, centerY, green));
		sticks.add(new Bamboo(centerX+16, centerY, green));
		sticks.add(new Bamboo(centerX-16, centerY + 20, green));
		sticks.add(new Bamboo(centerX+16, centerY + 20, green));
		return sticks;
	}
	
	public ArrayList<Bamboo> Tile8()
	{
		sticks.add(new Bamboo(centerX-16, centerY - 20, green));
		sticks.add(new Bamboo(centerX, centerY - 20, green));
		sticks.add(new Bamboo(centerX+16, centerY - 20, green));
		sticks.add(new Bamboo(centerX-12, centerY, red));
		sticks.add(new Bamboo(centerX+12, centerY, red));
		sticks.add(new Bamboo(centerX-16, centerY + 20, blue));
		sticks.add(new Bamboo(centerX, centerY + 20, blue));
		sticks.add(new Bamboo(centerX+16, centerY + 20, blue));
		return sticks;
	}
	
	public ArrayList<Bamboo> Tile9()
	{
		sticks.add(new Bamboo(centerX-16, centerY - 20, red));
		sticks.add(new Bamboo(centerX, centerY - 20, blue));
		sticks.add(new Bamboo(centerX+16, centerY - 20, green));
		sticks.add(new Bamboo(centerX-16, centerY, red));
		sticks.add(new Bamboo(centerX, centerY, blue));
		sticks.add(new Bamboo(centerX+16, centerY, green));
		sticks.add(new Bamboo(centerX-16, centerY + 20, red));
		sticks.add(new Bamboo(centerX, centerY + 20, blue));
		sticks.add(new Bamboo(centerX+16, centerY + 20, green));
		return sticks;
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo Tiles");

		frame.add(new BambooTile(2));
		frame.add(new BambooTile(3));
		frame.add(new BambooTile(4));
		frame.add(new BambooTile(5));
		frame.add(new BambooTile(6));
		frame.add(new BambooTile(7));
		frame.add(new BambooTile(8));
		frame.add(new BambooTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}
