package bao;

public class Square extends Shape implements IGetArea
{
	protected double side;
	public Square(double a) {
		side=a;
	}
	@Override
	public void getArea() {
		area=side*side;
	}
}
