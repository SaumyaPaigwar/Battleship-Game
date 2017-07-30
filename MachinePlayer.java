import java.util.Random;

public class MachinePlayer extends Player{

	//String Player_name;
	Game game;
	Point p;
	Random rm=new Random();
	//Board b;
	
	
	public MachinePlayer(Board b, String name)
	{
		super.b=b;
		super.name=name;
	}

	
	public String get_player_name()
	{
		return this.name;
	}
	
	public Game get_game()
	{
		return this.game;
	}
	
	public boolean isHuman()
	{
		return false;
	}
	
	@Override
	public boolean placeShips(Board b)
	{
		//for placing vessels
		Direction dir;
		for(int i=0;i<5;i++)
		{
		
		int n=rm.nextInt(2);
		if(n==0)
			dir=Direction.VERTICAL;
		else
			dir=Direction.HORIZONTAL;

		int size=b.size_ship[i];
		boolean check=false;
		int x=-1,y=-1;
		if(dir==Direction.VERTICAL)
		{
			
			
			while(check==false) //till vessel get placed
			{
			 x= rm.nextInt(10);
			 y=rm.nextInt(size);
			//System.out.println(i+ " at vertical "+x+" "+y);
			p=new Point(x,y);
			check=b.placeShip(p, i, dir);
			}
			System.out.println("Cpu Placed : Ship " + (i + 1) + " has been placed at "+ x+ " "+y+ " vertically");
			
			
		}
		else
		{
			while(check==false) //till vessel get placed
			{
			 x= rm.nextInt(size);
			 y=rm.nextInt(10);
			//System.out.println(i+" at horizontal "+x+" "+y);
			p=new Point(x,y);
			check=b.placeShip(p, i, dir);
	
			}
			System.out.println("Cpu Placed : Ship " + (i + 1) + " has been placed at "+ x+ " "+y+ " horizontally");
			
		}
			
		}		
		return true;
		
	}
	
	@Override
	public Point recommendAttack()
	{
                
		int row = rm.nextInt(10);
		int col = rm.nextInt(10);
		p = new Point(row,col);		
		return p;
	}

	@Override
	public void recordAttackResult(Board b, Point p) 
	{
		char boardPositionAttacked = b.board_array[p.getcordX()][p.getcordY()];
		if (p.isValidPoint()) {
			// invalid attack if already attacked the same position
			if (boardPositionAttacked == 'X' || boardPositionAttacked == 'o') {
				// X - attacked and hit shot, o - attacked but missed shot
				validShot = false;
				return;
			}
			validShot = true;
			if (boardPositionAttacked == '.') {
				// . - unattacked position
				shotHit = false;
				return;
			}
			// if it is ship segment
			shotHit = true;
			
			//to identify which ship was damaged
			if (boardPositionAttacked == 'A') {
				damagedShipId = 1;
			} else if (boardPositionAttacked == 'B') {
				damagedShipId = 2;
			} else if (boardPositionAttacked == 'C') {
				damagedShipId = 3;
			} else if (boardPositionAttacked == 'D') {
				damagedShipId = 4;
			} else {
				damagedShipId = 5;
			}
		}
	
	}

	@Override
	public void recordAttackByOpponent(Point p)
	{
		//no need
	}

}