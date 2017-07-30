public class battleship_main{
	static Game g;
	static Board humanBoard;
	static Board cpuBoard;
	static Player cpuPlayer;
	static Player humanPlayer;

	public static void main(String[] args)
		{

		g = new Game();
		humanBoard = new Board();
		cpuBoard = new Board();
		cpuPlayer  = new MachinePlayer(cpuBoard,"Machine Player");
		humanPlayer = new HumanPlayer(humanBoard, "Human Player");
		
		cpuPlayer.placeShips(cpuBoard);
		humanPlayer.placeShips(humanBoard);
		
		System.out.println(" Human Player Board :");
		humanBoard.display(false);
		System.out.println("\n Machine Player Board: ");
		cpuBoard.display(true);
				
		while(!(cpuBoard.allShipsDestroyed()) && !(humanBoard.allShipsDestroyed())){
		Play();
		}

		if(humanBoard.allShipsDestroyed()) { System.out.println("You have won the match :) ! congrats !");}
		else System.out.println("cpu has won the match :<");

		}
	
	public static void Play()
	{
		humanPlayer.attack(humanPlayer,cpuPlayer);
		cpuBoard.display(true);//attack on cpu board

		System.out.println("human player attack done");
		
		cpuPlayer.attack(cpuPlayer,humanPlayer);
		humanBoard.display(false);//attack on human board

		System.out.println("cpy player has attacked succesfully");
		
	}

}