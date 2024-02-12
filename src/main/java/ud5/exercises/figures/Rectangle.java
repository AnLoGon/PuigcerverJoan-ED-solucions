package ud5.exercises.figures;

public class Rectangle {
    private double x;
    private double y;
    private double height;
    private double width;
    public Rectangle(double x, double y, double height, double width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public Rectangle(double height, double width){
        this(0, 0, height, width);
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getHeight(){
        return this.height;
    }

    public double getWidth(){
        return width;
    }

    public double area(){
        return width * height;
    }

    public void move(double x, double y){
        this.x += x;
        this.y += y;
    }
}
