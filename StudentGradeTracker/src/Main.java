import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int mark;

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }
}

class GradeTracker {
    private ArrayList<Student> list = new ArrayList<>();

    public void add(String name, int mark) {
        list.add(new Student(name, mark));
    }

    public double avg() {
        int sum = 0;
        for (Student s : list) {
            sum += s.getMark();
        }
        return (double) sum / list.size();
    }

    public Student max() {
        Student top = list.get(0);
        for (Student s : list) {
            if (s.getMark() > top.getMark()) {
                top = s;
            }
        }
        return top;
    }

    public Student min() {
        Student low = list.get(0);
        for (Student s : list) {
            if (s.getMark() < low.getMark()) {
                low = s;
            }
        }
        return low;
    }

    public void show() {
        System.out.println("\n--- Student Report ---");
        for (Student s : list) {
            System.out.println("Name: " + s.getName() + " | Marks: " + s.getMark());
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeTracker gt = new GradeTracker();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks: ");
            int mark = sc.nextInt();
            sc.nextLine();

            gt.add(name, mark);
        }

        gt.show();

        System.out.println("\nAverage Marks: " + gt.avg());
        System.out.println("Highest Scorer: " + gt.max().getName()
                + " (" + gt.max().getMark() + ")");
        System.out.println("Lowest Scorer: " + gt.min().getName()
                + " (" + gt.min().getMark() + ")");

        sc.close();
    }
}
