package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {
    private static boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*");
    }
    private static boolean isOperand(String s){
        try{
            Double.parseDouble(s);
        }
        catch(NullPointerException e1){
            return false;
        }
        catch( NumberFormatException e2){
            return false;
        }
        return true;
    }
    private static boolean isExpressionValid(String s) {
        s.trim();
        //provjera prvog i zadnjeg znaka stringa
        if(s.charAt(0)!='(' || s.charAt(s.length()-1)!=')')
            return false;
        //provjera postojanja spacea izmedju svakog operanda, operatora i zagrada
        int numLeftParenthesis=0,numRightParenthesis=0;
        for(int i=1;i<s.length()-2;i++) {
            if (i % 2 != 0 && s.charAt(i) != ' ') {
                return false;
            }
            if(s.charAt(i)=='(') numLeftParenthesis=numLeftParenthesis+1;
            else if (s.charAt(i)==')') numRightParenthesis=numRightParenthesis+1;
            if(isOperator(String.valueOf(s.charAt(i)))
                    && (!isOperand(String.valueOf(s.charAt(i-2))) || !isOperand(String.valueOf(s.charAt(i+2)))))
                return false;
            if(isOperand(String.valueOf(s.charAt(i))) && !isOperator(String.valueOf(s.charAt(i-2))) && !isOperator(String.valueOf(s.charAt(i+2))))
                return false;
        }
        if(numLeftParenthesis!=numRightParenthesis) return false;
        return true;
    }
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
            else if(c.equals(")")){
                String op=operators.pop();
                double v=operands.pop();
                if (op.equals("+")) v=operands.pop()+v;
                else if(op.equals("-")) v=operands.pop()-v;
                else if(op.equals("*")) v=operands.pop()*v;
                else if(op.equals("/")) v=operands.pop()-v;
                operands.push(v);
            }
            else operands.push(Double.parseDouble(c));
        }
        return operands.pop();
    }
}