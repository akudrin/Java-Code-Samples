import junit.framework.Assert;
import org.java9recipes.chapter11.recipe11_02.Recipe_11_2_MathAdder;
import org.java9recipes.chapter11.recipe11_02.Recipe_11_2_MathAdder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Recipe11_2_MathAdderTest {
    
    public Recipe11_2_MathAdderTest(){
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddBehavior() {
        Recipe_11_2_MathAdder adder = new Recipe_11_2_MathAdder();
        for (int i =0;i < 100;i++) {
            for (int j =0;j < 100;j++) {
                Assert.assertEquals(i+j,adder.addNumbers(i,j));

            }
        }
    }

    @Test
    public void testSubstractBehavior() {
        Recipe_11_2_MathAdder adder = new Recipe_11_2_MathAdder();
        for (int i =0;i < 100;i++) {
            for (int j =0;j < 100;j++) {
                Assert.assertEquals(i-j,adder.substractNumber(i,j));

            }
        }
    }
}
