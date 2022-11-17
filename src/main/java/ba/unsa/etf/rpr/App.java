package ba.unsa.etf.rpr;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    try{
        ExpressionEvaluator e=new ExpressionEvaluator();
        Double rezultat = e.evaluate("( 1 + 2 )( 2 + 4 )");
        System.out.println("Rezultat aritmetickog izraza je " + rezultat);
    }
    catch(RuntimeException e){
        System.out.println("Aritmeticki izraz nije validan");
    }
    }
}
