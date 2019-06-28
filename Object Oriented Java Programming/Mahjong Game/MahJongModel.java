
public class MahJongModel 
{
	public Tile t;
	private boolean isTile;
	private int zOrder;
	int x, y, z;
	
	public MahJongModel(Tile t, int x, int y, int z)
	{
		this.t= t;
		isTile = true;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public MahJongModel(boolean r)
	{
		isTile = r;
	}
	
	public Tile getTile()
	{
		return t;
	}
	
	public boolean isTile()
	{
		return isTile;
	}
	
	public void setZOrder(int x)
	{
		zOrder = x;
	}
	
	public int getZOrder()
	{
		return zOrder;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getZ()
	{
		return z;
	}
}
