package ba.unsa.etf.rpr;

import java.util.Stack;

import static ba.unsa.etf.rpr.ExpressionCheck.isExpressionValid;

/**
 * Class for evaluating arithmetic expressions using Djikstra's algorithm
 *
 */
public class ExpressionEvaluator {
    /**
     *
     * @param exp which represents the arithmetic expression
     * @return result of the arithmetic expression
     * @throws RuntimeException if arithmetic expression is not valid
     */
    public static Double evaluate(String exp) throws RuntimeException{
        Stack<Double> operands=new Stack<Double>();
        Stack<String> operators=new Stack<String>();
        exp.trim();
        if (!isExpressionValid(exp)) throw new RuntimeException("Expression is not valid");
        for(String c: exp.split(" ")){
            if(c.equals("(")) continue;
            if(c.equals("+")) operators.push(c);
            else if(c.equals("-")) operators.push(c);
            else if(c.equals("*")) operators.push(c);
            else if(c.equals("/")) operators.push(c);
            else if(c.equals("sqrt")) operators.push(c);
            else if(c.equals(")")){
                String op=operators.pop();
                double v=operands.pop();
                if (op.equals("+")) v=operands.pop()+v;
                else if(op.equals("-")) v=operands.pop()-v;
                else if(op.equals("*")) v=operands.pop()*v;
                else if(op.equals("/")) v=operands.pop()/v;
                else if(op.equals("sqrt")) v=Math.sqrt(v);
                operands.push(v);
            }
            else operands.push(Double.parseDouble(c));
        }
        return operands.pop();
    }
}