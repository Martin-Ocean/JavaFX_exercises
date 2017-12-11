package Exercise_13_6;

import java.util.Scanner;

public class Exercise_13_6_Test {
    public static void main(String[] args) {
        double radius1, radius2;

        Scanner in = new Scanner(System.in);
        // prompt for two circle radius
        System.out.println("Please enter two radius: ");

        radius1 = in.nextDouble();
        radius2 = in.nextDouble();
        // Create two instances of ComparableCircle objects
        ComparableCircle circle1 = new ComparableCircle(radius1);
        ComparableCircle circle2 = new ComparableCircle(radius2);


        // Find and display the larger of the two ComparableCircle objects
        System.out.println((circle1.compareTo(circle2) == 1
                ? "\nCircle1 has "+ circle1.getArea() : "\nCircle2 has \n\t" + circle2.getArea()) +
                "\nis the larger one");
    }

    public abstract static class GeometricObject {
        private String color = "while";
        private boolean filled;
        private java.util.Date dateCreated;

        /** Construct a default geometric object */
        protected GeometricObject() {
            dateCreated = new java.util.Date();
        }

        /** Construct a geometric object with color and filled value */
        protected GeometricObject(String color, boolean filled) {
            dateCreated = new java.util.Date();
            this.color = color;
            this.filled = filled;
        }

        /** Return color */
        public String getColor() {
            return color;
        }

        /** Set a new color */
        public void setColor(String color) {
            this.color = color;
        }

        /** Return filled. Since filled is boolean,
         *  the get method is named isFilled */
        public boolean isFilled() {
            return filled;
        }

        /** Set a new filled */
        public void setFilled(boolean filled) {
            this.filled = filled;
        }

        /** Get dateCreated */
        public java.util.Date getDateCreated() {
            return dateCreated;
        }

        @Override
        public String toString() {
            return "created on " + dateCreated + "\ncolor: " + color +
                    " and filled: " + filled;
        }

        /** Abstract method getArea */
        public abstract double getArea();

        /** Abstract method getPerimeter */
        public abstract double getPerimeter();

        public void print() {
        }
    }

    public static class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
        public ComparableCircle(double radius) {
            super(radius);
        }
        public ComparableCircle(double radius, String color, boolean filled) {
            super(radius, color, filled);
        }

        @Override
        public int compareTo(ComparableCircle o) {
            if (getRadius() > o.getRadius()) return 1;
            if (getRadius() < o.getRadius()) return -1;
            return 0;
        }
    }

    public static class Circle
            extends GeometricObject {
        private double radius;

        public Circle() {
        }

        public Circle(double radius) {
            this.radius = radius;
        }

        public Circle(double radius,
                      String color, boolean filled) {
            this.radius = radius;
            setColor(color);
            setFilled(filled);
        }

        /** Return radius */
        public double getRadius() {
            return radius;
        }

        /** Set a new radius */
        public void setRadius(double radius) {
            this.radius = radius;
        }

        @Override /** Return area */
        public double getArea() {
            return radius * radius * Math.PI;
        }

        /** Return diameter */
        public double getDiameter() {
            return 2 * radius;
        }

        @Override /** Return perimeter */
        public double getPerimeter() {
            return 2 * radius * Math.PI;
        }

        @Override /** Implement the toString method in GeometricObject */
        public String toString() {
            return super.toString() + "\nDate created: " + getDateCreated() +
                    "\nRadius: " + radius;
        }
    }
}
