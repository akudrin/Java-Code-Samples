import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListWrapper {
    List<Integer> list;
    public ListWrapper(Integer... i)
    {
        list = Arrays.asList(i);
    }
}

class TestListWrapper {
    public static void main(String[] args) {

        Comparator<List<Integer>> byElement0 =
                (x,y) -> x.get(0).compareTo(y.get(0));

        ListWrapper list1 = new ListWrapper(2, 4, 6);
        ListWrapper list2 = new ListWrapper(4, 3, 5);
        Comparator<ListWrapper> byList
                = Comparator.comparing(x -> x.list, byElement0);
        System.out.println(byList.compare(list1,list2));

    }

}
