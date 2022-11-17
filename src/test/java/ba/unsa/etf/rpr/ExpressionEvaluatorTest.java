package ba.unsa.etf.rpr;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing calculating and parsing of an arithmetic expression
 */
public class ExpressionEvaluatorTest {
    @Test
    void testEvaluate1() {
        double x = ExpressionEvaluator.evaluate("( 1 + ( 3 * 2 ) )");
        assertEquals(7,x);
    }

    @Test
    void testEvaluate2() {
        double x = ExpressionEvaluator.evaluate("( 1 + ( 3 * ( 2 - ( 3 / ( 1 + ( sqrt 4 ) ) ) ) ) )");
        assertEquals(4,x);
    }

    @Test
    void testEvaluate3() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( 1 + ( 3 * 2 ) }");
        });
    }

    @Test
    void testEvaluate4() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( 1 + ( 3 * 2 ))");
        });
    }

    @Test
    void testEvaluate5() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("one plus one");
        });
    }

    @Test
    void testEvaluate6() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( one plus one )");
        });
    }

    @Test
    void testEvaluate7() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( sqrt )");
        });
    }

    @Test
    void testEvaluate8() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( 1 + ( sqrt ) )");
        });
    }

    @Test
    void testEvaluate9() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("sqrt");
        });
    }

    @Test
    void testEvaluate10() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( 1 + 2 + 3 )");
        });
    }

    @Test
    void testEvaluate11() {
        double x = ExpressionEvaluator.evaluate("( ( sqrt 25 ) + ( sqrt 100 ) )");
        assertEquals(15,x);
    }

    @Test
    void testEvaluate12() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( sqrt 25 + ( sqrt 100 ) )");
        });
    }

    @Test
    void testEvaluate13() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( 1 + ( 3 * 2 ) ) )");
        });
    }

    @Test
    void testEvaluate14() {
        double x = ExpressionEvaluator.evaluate("( ( sqrt 1 ) + ( 3 * ( ( sqrt 4 ) - ( 3 / ( 1 + ( sqrt 4 ) ) ) ) ) )");
        assertEquals(4,x);
    }

    @Test
    void testEvaluate15() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( ( ( 2 + 3 ) + sqrt 9 ) )");
        });
    }

    @Test
    void testEvaluate16() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( ( ( ( 2 + 3 + 4 ) ) ) )");
        });
    }


    @Test
    void testEvaluate17() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( ( ( ( ( 2 + 3 ) ) ) )");
        });
    }

    @Test
    void testEvaluate18() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( ( ( ( 2 + 3 ) ) ) ) )");
        });
    }

    @Test
    void testEvaluate19() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( ( 2 + 3 + 4 ) )");
        });
    }



}

