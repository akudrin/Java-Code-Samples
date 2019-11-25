import java.util.Comparator;

public class Student {

    String name;
    Integer id;
    Double gpa;
    public Student(String n, int i, double g)
    {
        name = n;
        id = i;
        gpa = g;
    }
    @Override
    public String toString() { return name + " " + id + " " + gpa; }
    public String getName() { return name; }
    public Integer getId() { return id; }
    public Double getGpa() { return gpa; }

    public static void main(String[] args) {
        Comparator<Student> byName = Comparator.comparing(Student::getName);
        Comparator<Student> byId = Comparator.comparing(Student::getId);
        Comparator<Student> byGpa = Comparator.comparing(Student::getGpa);

        Student s1 = new Student("Larry", 1000, 3.82);
        Student s2 = new Student("Libby", 1001, 3.76);
        System.out.println(byName.compare(s1,s2));
        System.out.println(byId.compare(s1,s2));
        System.out.println(byGpa.compare(s1,s2));
    }
}
