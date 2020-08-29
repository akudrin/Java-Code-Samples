import java.util.DoubleSummaryStatistics;

public class SummaryStatsStreams {
    public static void main(String[] args) {
        DoubleSummaryStatistics incomeStats = Person.persons().stream().map(Person::getIncome).collect(
                DoubleSummaryStatistics::new, DoubleSummaryStatistics::accept, DoubleSummaryStatistics::combine);
        System.out.println(incomeStats);

        DoubleSummaryStatistics incomeStatsNew = Person.persons().stream()
                .collect(Collectors.summarizingDouble(Person::getIncome));
    }
}