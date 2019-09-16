import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ImmutableCollections {
    public static void main(String[] args) {

    }

    @Test(expected = UnsupportedOperationException.class)
    public void showImmutabilityAdd() throws Exception {
        List<Integer> intList = List.of(1, 2, 3);
        intList.add(99);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void showImmutabilityClear() throws Exception {
        List<Integer> intList = List.of(1, 2, 3);
        intList.clear();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void showImmutabilityRemove() throws Exception {
        List<Integer> intList = List.of(1, 2, 3);
        intList.remove(0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void showImmutabilityReplace() throws Exception {
        List<Integer> intList = List.of(1, 2, 3);
        intList.replaceAll(n -> -n);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void showImmutabilitySet() throws Exception {
        List<Integer> intList = List.of(1, 2, 3);
        intList.set(0, 99);
    }

    @Test
    public void areWeImmutableOrArentWe() throws Exception {
        List<Holder> holders = List.of(new Holder(1), new Holder(2));
        assertEquals(1, holders.get(0).getX());
        holders.get(0).setX(4);
        assertEquals(4, holders.get(0).getX());
    }

}

class Holder {
    private int x;

    public Holder(int x) {
        this.x = x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}
