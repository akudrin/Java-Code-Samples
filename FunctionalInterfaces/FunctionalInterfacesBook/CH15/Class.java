import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class Class {
    String subject;
    Collection<Student> students;
    public Class(String su, Student... st)
    {
        subject = su;
        students = Arrays.asList(st);
    }
    Collection<Student> getStudents() { return students; }

    public static void main(String[] args) {
        Stream.of(
                new Class("Biology",
                        new Student("Joe" ,1001,3.81),
                        new Student("Mary",1002,3.91)),
                new Class("Physics",
                        new Student("Kalpana",1003,3.61),
                        new Student("Javier" ,1004,3.71))) // Stream<Class>
                .map(Class::getStudents) // Stream<List<Student>>
                .forEach(x -> System.out.println(x));
    }
}

class Student
{
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
}