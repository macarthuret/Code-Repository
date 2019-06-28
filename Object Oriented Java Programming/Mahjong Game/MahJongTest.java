import java.awt.*;
import javax.swing.*;

//Manifest file is what class you want to run off the bat.

//jar cvmf manifest.txt DieDemo.jar *.class images
//need to be in the bin directory

//This will execute the program
//java -jar DieDemo.jar
//Double clicking should also work

//Run the jar file from the Desktop to make sure its reading the images from the jar file instead
//of the file system.

public class MahJongTest extends JFrame
{
	public MahJongTest()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//add(new TestPanel());
		add(new GameBoard());
		
		setSize(1050,640);
		setVisible(true);
	}
	
	public class TestPanel extends JPanel
	{
		public TestPanel()
		{
			setLayout(null);	//This operation requires a constructor in Tile.java that calls setSize();
			Tile t;
			
			t = new SeasonTile("Spring");
			t.setLocation(200,100);
			add(t);
			System.out.print(getComponentZOrder(t));
			
			t = new SeasonTile("Summer");
			t.setLocation(190, 120);
			add(t);
			System.out.print(getComponentZOrder(t));
			
			t = new SeasonTile("Fall");
			t.setLocation(180, 140);
			add(t);
			System.out.print(getComponentZOrder(t));
			
			t = new SeasonTile("Winter");
			t.setLocation(170, 160);
			add(t);
			System.out.print(getComponentZOrder(t));
		}
	}
	
	public static void main(String[] args)
	{
		new MahJongTest();
	}
}
