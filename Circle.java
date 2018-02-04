
public class Circle {
	/**Two double data fields named x and y that specify the center of the circle.  */
	private double x;
	private double y;
	private double radius;
	
	
	/**  Provide getters and setters.*/
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	/**A data field radius with getters and setters. */
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	/** A no-arg constructor that creates a default circle with (0, 0) for (x, y) and 1 for radius.*/
	
	
	public Circle() {
		this(0,0,1);	
	}
	
	/**A constructor that creates a circle with the specified x, y, and radius. */
	public Circle(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	
	/**A method getArea() that returns the area of the circle. */
	public double getArea() {
		return radius * radius * Math.PI;
	}
	
	/**A method getPerimeter() that returns the perimeter of the circle. */
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}
	
	/**A method contains(double x, double y) that returns true if the 
	   specified point (x, y) is inside this circle.  */
	public boolean contains(double px, double py) {
		return distance(this.x,this.y,px,py) < radius;
			
	}
	
	/** A method contains(Circle circle) that returns true if 
	   the specified circle is inside this circle. */
	public boolean contains(Circle circle) {
		return distanceCircle(this,circle) < radius;
	}
	
	/** A method overlaps(Circle circle) that returns true if 
	   the specified circle overlaps with this circle.*/
	public boolean overlaps(Circle circle) {
		
		return (this.radius+circle.radius) > distanceCircle(this,circle);
		

	}
	
	public double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
	}
	
	public double distanceCircle(Circle c1,Circle c2) {
		return distance(c1.getX(),c1.getY(),c2.getX(),c2.getY());	
	}
	
	public String toString(Circle c) {
	return "("+ c.getX()+","+c.getY()+")";
	}
}
