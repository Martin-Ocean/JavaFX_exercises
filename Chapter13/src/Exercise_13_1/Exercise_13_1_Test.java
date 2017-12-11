package Exercise_13_1;

import java.util.Scanner;

public class Exercise_13_1_Test {
    public static void main(String[] args) {
        System.out.println("Please enter three sides: ");
        Scanner in = new Scanner(System.in);
        String color;
        boolean filled = false;
        double a,b,c;
        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();
        System.out.println("Enter a color: ");
        color = in.next();

        System.out.println("Is it filled? \n1 True\n2 False");
        if (in.nextInt() == 1) filled = true;

        GeometricObject triangle = new Triangle(a,b,c,color,filled);

        triangle.print();
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

    public static class Triangle extends GeometricObject {
        private String color;
        private boolean filled;
        private double A, B, C;
        public Triangle() {
        }

        public Triangle(double A, double B, double C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }

        public Triangle(double A, double B, double C, String color, boolean filled) {
            this.A = A;
            this.B = B;
            this.C = C;
            this.color = color;
            this.filled = filled;
        }
        @Override
        public double getArea() {
            double p = getPerimeter()/2.0;
            return Math.pow( (p*(p-A)*(p-B)*(p-C)), .5);
        }

        @Override
        public double getPerimeter() {
            return A+B+C;
        }

        @Override
        public void print() {
            System.out.println("Triangle area is: " + getArea() +"\nPerimeter is : "+getPerimeter()+"\ncolor: " + color + "\t filled: "+ filled);
        }
    }
}
