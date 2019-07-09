public class Recipe11_1 {
    public static void main (String[] args) {
        Recipe11_1 recipe = new Recipe11_1();
        recipe.startProcess();
    }

    private void startProcess() {
        try {
            int a = 5/0;
        }  catch (Exception e) {
            e.printStackTrace();
        }

    }
}
