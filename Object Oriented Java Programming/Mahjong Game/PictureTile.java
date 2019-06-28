import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class PictureTile extends Tile 
{
	private String name;
    private Image img;
    private ImageIcon image;
	
	public PictureTile(String name)
	{
		this.name = name;
		
		URL url = Tile.class.getResource("images/" + name + ".png");
		image = new ImageIcon(url);
		Image img = image.getImage();
		Image scaledimg = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		image = new ImageIcon(scaledimg);
	}
	
	public String toString()
	{
		return name;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	
		image.paintIcon(this, g, 15,5);
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Picture Tiles");

		frame.add(new Bamboo1Tile());

		frame.add(new FlowerTile("Chrysanthemum"));
		frame.add(new FlowerTile("Orchid"));
		frame.add(new FlowerTile("Plum"));
		frame.add(new FlowerTile("Bamboo"));

		frame.add(new SeasonTile("Spring"));
		frame.add(new SeasonTile("Summer"));
		frame.add(new SeasonTile("Fall"));
		frame.add(new SeasonTile("Winter"));

		frame.pack();
		frame.setVisible(true);
	}
}
