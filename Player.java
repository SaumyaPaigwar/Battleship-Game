
public abstract class Player {

	public String name;
	protected boolean validShot =false;
	protected boolean shotHit =false;
	protected int damagedShipId =-1;
	public Board b;
	
   public abstract boolean placeShips(Board b);
  
   public abstract void recordAttackResult(Board b, Point p);
   
   public abstract Point recommendAttack();

   public abstract void recordAttackByOpponent(Point p);	


	// getters
	public boolean isShotHit() {
		return shotHit;
	}

	public boolean isShotValid() {
		return validShot;
	}

	public int getDamagedShipId() {
		return damagedShipId;
	}

	public String getName() {
		return this.name;
	}
	
    public void attack(Player himself,Player opp)
    {
        int row = -1;
        int col = -1;
        
        String oldRow;
        int oldCol;
        
        Point p=himself.recommendAttack();
        row=p.getcordX();
       	col=p.getcordY();

       if (!(p.isValidPoint())){
            System.out.println("Invalid location!");}
        
        
        if (opp.b.hasShip(row, col))
        {
            
            opp.b.markHit(row, col);
            System.out.println(himself.getName() + " " + "**USER HIT AT " + row +" "+ col+" **");
        }
        else
        {
            
            opp.b.markMiss(row, col);
            System.out.println(himself.getName() + " " + "** USER MISS AT " + row +" " +col + " **");
        }
    }
  
}