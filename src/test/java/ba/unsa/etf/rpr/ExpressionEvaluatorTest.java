package ba.unsa.etf.rpr;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing calculating and parsing of an arithmetic expression
 */
public class ExpressionEvaluatorTest {
    @Test
    void simpleTest(){
        assertEquals(156,ExpressionEvaluator.evaluate("( 122 + 34 )"));
    }
    @Test
    void doubleTest(){
        assertEquals(39,ExpressionEvaluator.evaluate("( 34 + ( 2 * ( 5 / 2 ) ) )"));
    }
    @Test
    void doubleTest1(){
        assertEquals(2,ExpressionEvaluator.evaluate("( sqrt 4 )"));
    }
    @Test
    void largeEquationTest(){
        assertEquals(76,ExpressionEvaluator.evaluate("( 34 + ( 2 * ( ( sqrt 49 ) * 3 ) ) )"));
    }
    @Test
    void validityOfExpressionTest(){
        assertThrows(RuntimeException.class,()->{ double d = ExpressionEvaluator.evaluate("( 1 + ( 2 * ( sqrt + 3 ) ) )");});
    }
    @Test
    void validityofExpressionTest2(){
        assertThrows(RuntimeException.class,()->{ double d = ExpressionEvaluator.evaluate("( 1 + ( 2* 3 ) )");});
    }
    @Test
    void validityofExpressionTest3(){
        assertThrows(RuntimeException.class,()->{ double d = ExpressionEvaluator.evaluate("( 1 + ( 2 * 3n ) )");});
    }
    @Test
    void validityofExpressionTest4(){
        assertThrows(RuntimeException.class,()->{ double d = ExpressionEvaluator.evaluate("( 1 + ( / * ( sqrt 25 ) ) )");});
    }
    @Test
    void validityofExpressionTest5(){
        assertThrows(RuntimeException.class,()->{ double d = ExpressionEvaluator.evaluate("( 1 + ( 2 * 3 ) ( 4 )");});
    }
    @Test
    void validityofExpressionTest6(){
        assertThrows(RuntimeException.class,()->{ double d = ExpressionEvaluator.evaluate("( 1 + ( 3 ) )");});
    }
    @Test
    void precisionTest(){
        assertEquals(37.25,ExpressionEvaluator.evaluate("( 34 + ( 2 * ( 52 / 32 ) ) )"));
    }
}

