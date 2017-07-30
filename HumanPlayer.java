import java.util.Scanner;

class HumanPlayer extends Player {
	Game game;
	Point p;
	//Board b;
	//String Player_name;

	Scanner sc = new Scanner(System.in);
	
	public HumanPlayer(Board b, String name)
	{
		super();
		super.b=b;
		super.name=name;
	}

	@Override
	public void recordAttackResult(Board b, Point p) {
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
	public boolean placeShips(Board b) {
		int shipId, row, col;
		char ch;
		Direction dir;
		boolean shipPlacing;
		for (int i = 0; i < 5; i++) {
			do {
				System.out.println("Enter initial coordinates for placing ship " + (i + 1));
				row = sc.nextInt();
				col = sc.nextInt();
				System.out.println("Enter H for horizontal or V for vertical for placement of ship " + (i + 1));
				ch = sc.next().charAt(0);
				if (ch == 'h' || ch == 'H') {
					dir = Direction.HORIZONTAL;
				} else {
					dir = Direction.VERTICAL;
				}
				shipId = i ;
				shipPlacing = b.placeShip(new Point(row, col), shipId, dir);
				if (shipPlacing == false) {
					System.out.println("Invalid position. Enter again");
				} else {
					System.out.println("Ship " + (i + 1) + " has been placed");
				}
			} while (shipPlacing == false);
		}
		//sc.close();
		return true;
	}

	@Override
	public Point recommendAttack(){
		// TODO Auto-generated method stub

		System.out.println("enter the points you want to attack to : ");		

		int x= sc.nextInt();
		int y= sc.nextInt();
		p=new Point(x,y);
		return p;
	}

	@Override
	public void recordAttackByOpponent(Point p) {
		// TODO Auto-generated method stub
		
	}
}