import java.awt.*;
import java.util.HashMap;

import javax.swing.*;

public class CharacterTile extends Tile 
{
	protected char symbol;
	private static HashMap<Character, Character> map;
	private static Font big, small;
	private static Color green;
	static {
		green = Color.decode("#2c6b37");
		
		map = new HashMap<Character, Character>(){{
		put('1', '\u4E00');
		put('2', '\u4E8C');
		put('3', '\u4E09');
		put('4', '\u56DB');
		put('5', '\u4E94');
		put('6', '\u516D');
		put('7', '\u4E03');
		put('8', '\u516B');
		put('9', '\u4E5D');
		put('N', '\u5317');
		put('E', '\u6771');
		put('W', '\u897F');
		put('S', '\u5357');
		put('C', '\u4E2D');
		put('F', '\u767C');
		}};
		
		big = new Font("KaiTi", Font.PLAIN, 40);
		small = new Font("KaiTi", Font.PLAIN, 21);
	}
	
	public CharacterTile(char symbol)
	{
		this.symbol = symbol;
		setToolTipText(toString());
	}
	
	public boolean matches(Tile other)
	{
		if(super.matches(other))
		{
			CharacterTile tile = (CharacterTile) other;
			if(this.symbol == tile.symbol)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public String toChinese() 
	{
		String chinese = Character.toString(map.get(symbol));
		
		return chinese;
	}
	
	public String toString()
	{
		if(symbol == 'N')
		{
			return "North Wind";
		}
		else if(symbol == 'E')
		{
			return "East Wind";
		}
		else if(symbol == 'W')
		{
			return "West Wind";
		}
		else if(symbol == 'S')
		{
			return "South Wind";
		}
		else if(symbol == 'C')
		{
			return "Red Dragon";
		}
		else if(symbol == 'F')
		{
			return "Green Dragon";
		}
		else
		{
			return "Character " + symbol;
		}
	}
	
	@Override public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		//FontMetrics metrics = g.getFontMetrics();
		//int width = metrics.stringWidth(Character.toString(map.get(symbol)));
		
		
		g2.setColor(Color.red);
		g2.drawString(Character.toString(symbol), 52, 15);
		if(symbol == 'N' || symbol == 'W' || symbol == 'E' || symbol == 'S' || symbol == 'C' || symbol == 'F')
		{
			g2.setFont(big);
			FontMetrics metricsB = g.getFontMetrics();
			int bwidth = metricsB.stringWidth(Character.toString(map.get(symbol)));

			if(symbol == 'C')
			{
				g2.drawString(Character.toString(map.get(symbol)), 40 - (bwidth / 2), 50);
			}
			else if(symbol == 'F')
			{
				g2.setColor(green);
				g2.drawString(Character.toString(map.get(symbol)), 40 - (bwidth / 2), 50);
			}
			else
			{
				g2.setColor(Color.black);
				g2.drawString(Character.toString(map.get(symbol)), 40 - (bwidth / 2), 50);
			}
		}
		else
		{
			g2.setColor(Color.black);
			g2.setFont(small);
			FontMetrics metricsS = g.getFontMetrics();
			int swidth = metricsS.stringWidth(Character.toString(map.get(symbol)));
			g2.drawString(Character.toString(map.get(symbol)), 40 - (swidth / 2), 30);
			g2.setColor(Color.red);
			g2.drawString(Character.toString('\u842c'), 40 - (swidth / 2), 52);
		}

	}
	
	public static void main(String[] args)
	{
		JFrame		frame = new JFrame();
		JPanel		tiles = new JPanel();
		JScrollPane	scroller = new JScrollPane(tiles);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Tiles");
		frame.add(scroller);

		// Try something like this if your tiles don't fit on the screen.
		// Replace "tile width" and "tile height" with your values.
		//scroller.setPreferredSize(new Dimension(8 * tile width, 40 + tile height));

		tiles.add(new CharacterTile('1'));
		tiles.add(new CharacterTile('2'));
		tiles.add(new CharacterTile('3'));
		tiles.add(new CharacterTile('4'));
		tiles.add(new CharacterTile('5'));
		tiles.add(new CharacterTile('6'));
		tiles.add(new CharacterTile('7'));
		tiles.add(new CharacterTile('8'));
		tiles.add(new CharacterTile('9'));
		tiles.add(new CharacterTile('N'));
		tiles.add(new CharacterTile('E'));
		tiles.add(new CharacterTile('W'));
		tiles.add(new CharacterTile('S'));
		tiles.add(new CharacterTile('C'));
		tiles.add(new CharacterTile('F'));

		frame.pack();
		frame.setVisible(true);
	}
}
