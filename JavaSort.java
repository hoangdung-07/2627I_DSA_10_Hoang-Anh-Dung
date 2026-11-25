package Week_4;

import java.io.*;
import java.util.*;
/* so sanh gpa, if gpa == -> so sanh ten, if ten == -> so sanh id  */
public class JavaSort {
    private int ID;
    private String Name;
    private double CGPA;

    public JavaSort(int ID, String Name, double CGPA){
        this.ID = ID;
        this.Name = Name;
        this.CGPA = CGPA;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return Name;
    }

    public double getCGPA(){
        return CGPA;
    }

    public String toString(){
        return Name;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<JavaSort> solutions = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int ID = sc.nextInt();
            String Name = sc.next();
            double CGPA = sc.nextDouble();
            solutions.add(new JavaSort(ID, Name, CGPA));
        }
        solutions.sort(Comparator.comparing(JavaSort :: getCGPA, Comparator.reverseOrder())
                .thenComparing(JavaSort :: getName)
                .thenComparing(JavaSort :: getID));
        for(JavaSort s : solutions){
            System.out.println(s);
        }
    }
}

