package ba.unsa.etf.rpr;

import java.util.Objects;

import static ba.unsa.etf.rpr.ExpressionCheck.*;

/**
 * Class that tests ExpressionEvaluator, gets expression through command line
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            ExpressionEvaluator e = new ExpressionEvaluator();
            Double result = e.evaluate((args[0]));
            System.out.println(result);
        }
        catch(RuntimeException e){
            System.out.println("Izraz nije ispravan");
        }
        //ovako bi se izveo main da iz cmd-a saljemo niz stringova
    /*  try {
            if (args.length < 4 || !Objects.equals(args[0], "(")) {
                throw new RuntimeException();
            }
            StringBuilder build = new StringBuilder("");
            for (String s : args) {
                if (!isOperator(s) && !isOperand(s) && !isOperatorSqrt(s) && !s.equals("(") && !s.equals(")"))
                    throw new RuntimeException();
                build.append(s).append(" ");
            }
            ExpressionEvaluator e = new ExpressionEvaluator();
            String rez=build.toString();
            Double result = e.evaluate(rez.trim());
            System.out.println(result);
        }
        catch(RuntimeException e){
            System.out.println("Izraz nije ispravan");
        }
 */
    }
}
