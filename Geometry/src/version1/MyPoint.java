package version1;

import java.util.Scanner;

public class MyPoint {
    private double x;
    private double y;

    // Constructors
    public MyPoint() {
        this(0, 0);
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters and Setters
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

    // Calculate distance between two points
    public double getDistance(double x, double y) {
        double dx = this.x - x;
        double dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double getDistance(MyPoint anotherPoint) {
        return getDistance(anotherPoint.x, anotherPoint.y);
    }

    public double getDistanceToOrigin() {
        return getDistance(0, 0);
    }

    // Display point
    public void displayPoint() {
        System.out.println("(" + x + "," + y + ")");
    }

    // Override toString method
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    // Get quadrant or axis
    public int getQuotient() {
        if (x == 0 && y == 0) {
            return 0; // Origin
        } else if (x == 0) {
            return 6; // Y-axis
        } else if (y == 0) {
            return 5; // X-axis
        } else if (x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else {
            return 4;
        }
    }

    // Get angle from positive x-axis
    public double getAngle() {
        if (x == 0 && y == 0) {
            return 0; // Undefined for the origin
        } else if (x == 0) {
            if (y > 0) {
                return 90.0; // 90 degrees for positive y-axis
            } else {
                return 270.0; // 270 degrees for negative y-axis
            }
        } else if (y == 0) {
            if (x > 0) {
                return 0.0; // 0 degrees for positive x-axis
            } else {
                return 180.0; // 180 degrees for negative x-axis
            }
        } else {
            double radians = Math.atan2(y, x);
            return Math.toDegrees(radians);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the x-coordinate: ");
        double x = scanner.nextDouble();

        System.out.print("Enter the y-coordinate: ");
        double y = scanner.nextDouble();

        MyPoint point = new MyPoint(x, y);

        point.displayPoint();
        System.out.println("Distance to origin: " + point.getDistanceToOrigin());
        System.out.println("Quadrant: " + point.getQuotient());
        System.out.println("Angle: " + point.getAngle());
        System.out.println("String representation: " + point.toString());

        scanner.close();
    }
}
