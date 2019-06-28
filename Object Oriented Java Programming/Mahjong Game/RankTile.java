
public class RankTile extends Tile 
{
	protected int rank;
	
	public RankTile(int rank)
	{
		this.rank = rank;
	}
	
	public boolean matches(Tile other)
	{
		if(super.matches(other))
		{
			RankTile tile = (RankTile) other;
			if(this.rank == tile.rank)
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
}
