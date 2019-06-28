import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard extends JPanel
{
	private final int X_AXIS = 15, Y_AXIS = 8, Z_AXIS = 5;
	private Dimension SIZE = new Dimension(1120,720);
	private int rand = (int) System.currentTimeMillis() % 100000;
	private int[][][] boardArea =  { { {0,1,1,1,1,1,1,1,1,1,1,1,1,0,0}, //Bottom Level [1][x][y]
									   {0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},
									   {0,0,1,1,1,1,1,1,1,1,1,1,0,0,0},
									   {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
									   {1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
									   {0,0,1,1,1,1,1,1,1,1,1,1,0,0,0},
									   {0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},
	                                   {0,1,1,1,1,1,1,1,1,1,1,1,1,0,0}},
			
	                               {   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                                   {0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},
	                                   {0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},
	                                   {0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},
	                                   {0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},
	                                   {0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},
	                                   {0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},
	                                   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}},
	                               
	                               {   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},	// 2nd Level [2][x][y]
	                                   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                                   {0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
	                                   {0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
	                                   {0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
	                                   {0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
	                                   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                                   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}},
	                               
	                               {   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, // 3rd Level [3][x][y]
	                                   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                                   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                                   {0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
	                                   {0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
	                                   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                                   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                                   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}},
	                               
	                               {   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, // 4th Level [4][x][y]
	                                   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                                   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                                   {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
	                                   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                                   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                                   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                                   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}},
	                                };
	
	private MahJongModel[][][] board = new MahJongModel[Z_AXIS][Y_AXIS][X_AXIS];
	private ArrayList<MahJongModel> removedTiles = new ArrayList<MahJongModel>();
	private TileDeck tileDeck;
	private MahJongModel tileHolder;
	Tile t;
	
    public GameBoard()
    {
        setSize(SIZE);
        setLayout(null);
        buildDeck();
        fillGameBoard();
        drawTiles();
        setVisible(true);
    }
	
	private void buildDeck()
	{
		tileDeck = new TileDeck();
	}
	
	private void fillGameBoard()
	{
		tileDeck.shuffle();
		for(int z = 0; z < Z_AXIS; z++)
		{
			for(int y = 0; y < Y_AXIS; y++)
	        {
				for(int x = 0; x < X_AXIS; x++)
	            {
					if(boardArea[z][y][x] == 1)
	                {
						board[z][y][x] = new MahJongModel(
		                    tileDeck.deck.remove((tileDeck.deck.size() - 1)), x, y, z);
	                }
					else
					{
						board[z][y][x] = new MahJongModel(false);
					}
	            }
	        }
	    }
	}
	
	public void paintComponent(Graphics g)
	{
		URL url;
		Image img;
		ImageIcon image;
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		url = Tile.class.getResource("images/dragon_bg.png");
		image = new ImageIcon(url);
		img = image.getImage();
		Image scaledimg = img.getScaledInstance(750, 500, Image.SCALE_DEFAULT);
		image = new ImageIcon(scaledimg);

	    g2.setBackground(Color.decode("#FFD700"));
	    Rectangle2D bg = new Rectangle2D.Double(0, 0, 1050, 640);
	    g2.fill(bg);
		image.paintIcon(this, g,150,70);
	}
	
	public void drawTiles()
	{
		int zOrder = 0;
		for(int z = Z_AXIS - 1; z >= 0; z--)
		{
			for(int y = Y_AXIS - 1; y >= 0; y--)
			{
				for(int x = 0; x <= X_AXIS - 1; x++)
				{
					if(board[z][y][x].isTile())
					{
						final Tile t = board[z][y][x].getTile();
						if(z == 0 && y ==4 && x == 0)
						{
							t.setLocation(50, 50 + (y * (t.getHeight() - 20)) - (t.getHeight()/2));
						}
						else if(z == 0 && y == 3 && (x == 14 || x == 13))
						{
							t.setLocation(50 + (x * (t.getWidth()-10)), 50 + (y * (t.getHeight() - 20)) - (z * 20) + (t.getHeight()/2));
						}
						else if(z == 4 && y == 3 && x == 6)
						{
							t.setLocation(50 + (z * 10) + (x * (t.getWidth()-10)) + (t.getWidth()/2), 50 + (y * (t.getHeight() - 20)) - (z * 20) + (t.getHeight()/2));
						}
						else if(y == 0)
						{
							t.setLocation(50 + (z * 10) + (x * (t.getWidth()-10)), 50);
						}
						else
						{
							t.setLocation(50 + (z * 10) + (x * (t.getWidth()-10)), 50 + (y * (t.getHeight() - 20)) - (z * 20));
						}
						setComponentZOrder(t, zOrder);
						board[z][y][x].setZOrder(zOrder);
						zOrder++;
						final int[] pos = {z,y,x};
						t.setCoords(pos);
						
						t.addMouseListener(new MouseAdapter() {
							public void mousePressed(MouseEvent e)
							{
								if(isClickable(pos[0], pos[1], pos[2]))
								{
									removedTiles.add(board[pos[0]][pos[1]][pos[2]]);									
									board[pos[0]][pos[1]][pos[2]] = new MahJongModel(false);
									t.setVisible(false);
									repaint();
								}

							}
						});
						add(t);
					}
				}
			}
		}
	}
	
	public void shadows()
	{
		
	}
	
	private boolean isClickable(int z, int y, int x)
	{
		return ((x_left(x,y,z) || x_right(x,y,z)) && z_up(x,y,z));	
	}
	
	//simplifier methods for isClickable
    private int x_left(int x)
    { 
    	return (x == 0) ? x : x - 1;
    }
    
    private int x_right(int x)
    { 
    	return (x == X_AXIS - 1) ? x : x + 1;
    }
    
    private int z_up(int z)
    { 
    	return (z == Z_AXIS-1) ? z : z + 1; 
    }
    
    //Checks if there is a tile next to it.
    private boolean x_left(int x, int y, int z)
    {
    	if(x == 0)
    	{
    		return true;
    	}
    	else if(x == 1 && y == 3)
    	{
    		if(board[0][4][0].isTile())
    		{
    			return false;
    		}
    		return true;
    	}
    	else if(board[z][y][x_left(x)].isTile())
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
    
    private boolean x_right(int x, int y, int z)
    {
    	if(x == X_AXIS - 1)
    	{
    		return true;
    	}
    	else if(x == 12 && y == 4)
    	{
    		if(board[0][3][13].isTile())
    		{
    			return false;
    		}
    		return true;
    	}
    	else if(board[z][y][x_right(x)].isTile())
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
    
    private boolean z_up(int x, int y, int z)
    {
    	if(z == Z_AXIS - 1)
    	{
    		return true;
    	}
    	else if(z == Z_AXIS - 2)
    	{
    		if(board[4][3][6].isTile())
    		{
    			return false;
    		}
    		return true;
    	}
    	else if(board[z_up(z)][y][x].isTile())
	    {
	    	return false;
	    }
    	else
    	{
    		return true;
    	}
    }
    
    
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new GameBoard());
	}
}
