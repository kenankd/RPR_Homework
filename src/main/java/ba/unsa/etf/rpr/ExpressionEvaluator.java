package ba.unsa.etf.rpr;

import java.util.Stack;

import static ba.unsa.etf.rpr.ExpressionCheck.isExpressionValid;

public class ExpressionEvaluator {

    public static Double evaluate(String exp) throws RuntimeException{
        Stack<Double> operands=new Stack<Double>();
        Stack<String> operators=new Stack<String>();
        exp.trim();
        if (!isExpressionValid(exp)) throw new RuntimeException("Izraz nije validan");
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