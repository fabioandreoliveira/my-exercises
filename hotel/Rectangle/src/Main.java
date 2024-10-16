import io.codeforall.bootcamp.Rectangle;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5);

        rectangle.setHeight(5.00);
        rectangle.setWidth(6.00);

        System.out.println("Área: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
    }
}
