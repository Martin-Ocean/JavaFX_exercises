/*
* Author: Ming Gong
* Date: Nov 8th, 2017
* Name: BubbleSort
* Description: Use comparable and comparator to sort
* */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GenericBubbleSort {

    ArrayList<Student> list = new ArrayList<>();

    void populateArray() {
        for (int i = 0; i < 100; i++) {
            list.add(new Student(i+1, makeName()));
        }
    }

    //make ordered ids and random names from 24 alphabet
    String makeName() {
        String name = "";
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < (int)(Math.random() * 7 + 3); i++) {
            name += alphabet[(int)(Math.random() * 25)];
        }
        return name;
    }

    public static void main(String[] args) {
        GenericBubbleSort comparator = new GenericBubbleSort();
        GenericBubbleSort comparable = new GenericBubbleSort();
        boolean needNextPass = true;

        // populate array
        comparator.populateArray();
        System.out.println("\n\n=======================Before Sort=======================");
        for (Student student: comparator.list) {
            System.out.print(student.toString());
        }

        System.out.println("\n\n========================After Sort=======================");
        //sort
        for (int i = 1; i <comparator.list.size() && needNextPass ; i++) {
            needNextPass = false;
            for (int j = 0; j < comparator.list.size()-i; j++) {
                if ((new sortComparator()).compare(comparator.list.get(j), comparator.list.get(j+1)) > 0) {
                    Student temp = comparator.list.get(j);
                    comparator.list.remove(j);
                    comparator.list.add(j+1, temp);

                    needNextPass = true;
                }
            }
        }

        //print
        for (Student student: comparator.list) {
            System.out.print(student.toString());
        }

        //populate array
        System.out.println("\n\n=======================Before Sort=======================");
        comparable.populateArray();
        for (Student student: comparable.list) {
            System.out.print(student.toString());
        }
        System.out.println("\n\n========================After Sort=======================");
        // sort
        needNextPass = true;
        for (int i = 1; i <comparable.list.size() && needNextPass ; i++) {
            needNextPass = false;
            for (int j = 0; j < comparable.list.size()-i; j++) {
                if ((comparable.list.get(j).compareTo(comparable.list.get(j+1))) > 0) {
                    Student temp = comparable.list.get(j);
                    comparable.list.remove(j);
                    comparable.list.add(j+1, temp);

                    needNextPass = true;
                }
            }
        }        //print
        for (Student student: comparable.list) {
            System.out.print(student.toString());
        }
    }
}


class Student implements Comparable<Student> {
    String name;
    int id;


    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return String.format("Student ID: %d Student Name: %s%n",this.id,this.name);
    }

    @Override
    public int compareTo(Student o) {
        return o.id - this.id;
    }
}


class sortComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

