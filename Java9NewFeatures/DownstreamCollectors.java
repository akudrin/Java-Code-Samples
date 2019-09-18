import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class DownstreamCollectors {
    private static long THRESHOLD = 50;

    public static void main(String[] args) {

        Developer venkat = new Developer("Venkat");
        Developer daniel = new Developer("Daniel");
        Developer brian = new Developer("Brian");
        Developer matt = new Developer("Matt");
        Developer nate = new Developer("Nate");
        Developer craig = new Developer("Craig");
        Developer ken = new Developer("Ken");
        Task java = new Task("Java stuff", 100);
        Task altJvm = new Task("Groovy/Kotlin/Scala/Clojure", 50);
        Task javaScript = new Task("JavaScript (sorry)", 100);
        Task spring = new Task("Spring", 50);
        Task jpa = new Task("JPA/Hibernate", 20);

        java.addDevelopers(venkat, daniel, brian, ken);
        javaScript.addDevelopers(venkat, nate);
        spring.addDevelopers(craig, matt, nate, ken);
        altJvm.addDevelopers(venkat, daniel, ken);
        List<Task> tasks = Arrays.asList(java, altJvm, javaScript, spring, jpa);
        Map<Long, List<Task>> taskMap = tasks.stream()
                .collect(groupingBy(Task::getBudget));

        taskMap.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

        taskMap = tasks.stream()
                .filter(task -> task.getBudget() >= THRESHOLD)
                .collect(groupingBy(Task::getBudget));

        taskMap.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

        Map<String, List<Task>> tasksByName = tasks.stream()
                .collect(groupingBy(Task::getName));

        //Lists of developers for each task
        Map<String, Set<List<Developer>>> map = tasks.stream()
                .collect(groupingBy(Task::getName,
                        Collectors.mapping(Task::getDevelopers, toSet())));

        //Using flatMapping to get just a set of developers
        Map<String, Set<Developer>> task2setdevs = tasks.stream()
                .collect(groupingBy(Task::getName,
                        Collectors.flatMapping(task -> task.getDevelopers().stream(),
                                toSet())));


    }
}


class Task {
    private String name;
    private long budget;
    private List<Developer> developers = new ArrayList<>();

    public void addDevelopers(Developer... arg){
        developers.addAll(Arrays.asList(arg));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public Task(String name, long budget, List<Developer> developers) {
        this.name = name;
        this.budget = budget;
        this.developers = developers;
    }

    public Task(String name, long budget) {
        this.name = name;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", budget=" + budget +
                ", developers=" + developers +
                '}';
    }
}

class Developer {
    private String name;

    public Developer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                '}';
    }
}