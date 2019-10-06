package bao;

public class Triangle extends Shape implements IGetArea
{
	protected double width;
	protected double height;
	public Triangle(double w,double h) {
		width=w;
		height=h;
	}
	@Override
	public void getArea() {
		area=0.5*width*height;
	}
}
