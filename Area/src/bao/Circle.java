package bao;


public class Circle extends Shape implements IGetArea
{
	protected double radius;
	public Circle(double a) {
		radius=a;
	}
	@Override
	public  void getArea() {
		area=Math.PI*radius*radius;
	}
}
