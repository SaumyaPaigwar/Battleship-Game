import java.util.concurrent.ThreadLocalRandom;

enum Direction { HORIZONTAL, VERTICAL };

class Point 
{
    	public int x_coord;
    	public int y_coord;

// default const.

   	public Point() //Initialize (x,y) for Point object
    	   {
		this.x_coord = 0;
		this.y_coord = 0;
    	   }

// parameterized const.    

    	public Point(int x_coord, int y_coord)
   	 {
		this.x_coord = x_coord;
		this.y_coord = y_coord;
   	  }

// getter methods

    	public int getcordX()
	{
	   return this.x_coord;
	}	
	
    	public int getcordY()
	{
	   return this.y_coord;
	}

// method to check tht givn point is valid on the board or not 

     	boolean isValidPoint()
	  {
	if((this.x_coord >= 0 && this.x_coord <= 9 ) && (this.y_coord >= 0 && this.y_coord <= 9)) return true;
	else return false;
	  }
	
	
// create a Point object and call below method to generate a random pointer

	public Point GenerateRandomPoint()
	{
	  int randomNum,randomNum2;

	  randomNum = ThreadLocalRandom.current().nextInt(0, 9 + 1);
		//System.out.println(randomNum);

	  randomNum2 = ThreadLocalRandom.current().nextInt(0, 9 + 1);  
  		//System.out.println(randomNum2);

	  this.x_coord = randomNum;
	  this.y_coord = randomNum2;
	
	  return this;	
	}

}