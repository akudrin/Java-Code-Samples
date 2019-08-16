import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Collections1 {

    private List<String> sampleStrings =
            Arrays.asList("this", "is", "a", "list", "of", "strings");

    private List<Golfer> golfers = Arrays.asList(
            new Golfer("Jack", "Nicklaus", 68),
            new Golfer("Tiger", "Woods", 70),
            new Golfer("Tom", "Watson", 70),
            new Golfer("Ty", "Webb", 68),
            new Golfer("Bubba", "Watson", 70)
    );

    public static void main(String[] args) {
        new Collections1().sortByScoreThenLastThenFirst().stream().forEach(System.out::println);

    }

    public List<String> defaultSort() {
        Collections.sort(sampleStrings);
        return sampleStrings;
    }
    public List<String> defaultSortUsingStreams() {
        return sampleStrings.stream()
                .sorted()
                .collect(toList());
    }

    //Using a lambda for the Comparator to sort by length
    public List<String> lengthSortUsingSorted() {
        return sampleStrings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(toList());
    }

    //Using a Comparator using the comparingInt method
    public List<String> lengthSortUsingComparator() {
        return sampleStrings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(toList());
    }

    public List<Golfer> sortByScoreThenLastThenFirst() {
        return golfers.stream()
                .sorted(Comparator.comparingInt(Golfer::getScore)
                        .thenComparing(Golfer::getLast)
                        .thenComparing(Golfer::getFirst))
                .collect(toList());
    }


}

class Golfer {
private String first;
private String last;
private int score;

    @Override
    public String toString() {
        return "Golfer{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", score=" + score +
                '}';
    }

    public Golfer(String first, String last, int score) {
        this.first = first;
        this.last = last;
        this.score = score;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
