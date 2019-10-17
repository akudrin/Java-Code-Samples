import java.util.Iterator;
import java.util.function.Consumer;

class Payroll {
    public static void main(String[] args)
    {
        Consumer<Employee> applyProfit = x ->
                x.bonus += MomAndPop.profit * x.multiplier;
        MomAndPop company = new MomAndPop();
        System.out.println(">>>>>>>>>>>>>>>");
        Iterator<Employee> it = company.iterator();
        while (it.hasNext())
            System.out.println(it.next());
        System.out.println(">>>>>>>>>>>>>>>");
        MomAndPop.profit = 120000.0; // 40% PRG 30%MGR 15% VP 15% CEO
        company.forEach(applyProfit
                .andThen(x -> System.out.println(x)));


    }
}