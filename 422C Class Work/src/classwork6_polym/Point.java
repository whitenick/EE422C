package classwork6_polym;

public class Point {
	int x;
	int y;
	public Point(){
		this(0,0);
	}
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Point o) {
		if(o == null) {return false;}
		return false;
	}
}


/*
 * Polymorphism: Ability for the same code to be used with different types of objects and behave different 
 * system.out.println can print any type of object 
 * 	each displays its own way on console 
 * A variable of type T can hold an object of any subclass of T
 * 		ex: Employee ed = new Lawyer();
 * 				object ed will behave as a Lawyer 
 * 
 * 
 * 
 * 
 */
