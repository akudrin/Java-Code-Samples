import java.util.Comparator;

public class ArraysSorting1 {
    private static class Employee {
        public String name;
        public int employeeId;

        public Employee(String name, int employeeId) {
            this.name = name;
            this.employeeId = employeeId;
        }
    }

    public static void main(String[] args) {

        //Converting Arrays to Strings With Arrays.toString()
        //Sorting Arrays
        int[]   ints = new int[10];
        for(int i=0; i < ints.length; i++){
            ints[i] = 10 - i;
        }
        System.out.println(java.util.Arrays.toString(ints));
        java.util.Arrays.sort(ints);
        System.out.println(java.util.Arrays.toString(ints));

        //Sorting Arrays of Objects
        Employee[] employeeArray = new Employee[3];

        employeeArray[0] = new Employee("Xander", 1);
        employeeArray[1] = new Employee("John"  , 3);
        employeeArray[2] = new Employee("Anna"  , 2);

        java.util.Arrays.sort(employeeArray, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.name.compareTo(e2.name);
            }
        });

        for(int i=0; i < employeeArray.length; i++) {
            System.out.println(employeeArray[i].name);
        }

        java.util.Arrays.sort(employeeArray, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.employeeId - e2.employeeId;
            }
        });

        for(int i=0; i < employeeArray.length; i++) {
            System.out.println(employeeArray[i].name);
        }

        java.util.Arrays.sort(employeeArray, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                int nameDiff = e1.name.compareTo(e2.name);
                if(nameDiff != 0) { return nameDiff; }

                return e1.employeeId - e2.employeeId;
            }
        });

        for(int i=0; i < employeeArray.length; i++) {
            System.out.println(employeeArray[i].name);
        }

    }
}


