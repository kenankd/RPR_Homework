package ba.unsa.etf.rpr;

/**
 * Help class for ExpressionEvaluator, checks if arithmetic expression is valid
 */
public class ExpressionCheck {
    /**
     * checks if string is equal to sqrt
     * @param s
     * @return true if parameter string is sqrt
     */
    private static boolean isOperatorSqrt(String s){
        return s.equals("sqrt");
    }

    /**
     * checks if string is an operator
     * @param s string
     * @return  true if given string is an operator
     */
    private static boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*");
    }

    /**
     * checks if string is an operand
     * @param s string
     * @return true if string string is an operand
     */
    private static boolean isOperand(String s){
        if(s.equals("sqrt")) return false;
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

    /**
     * Checks if arithmetic expression is valid
     * @param s string which is the expression
     * @return true if expression is valid
     */
    public static boolean isExpressionValid(String s) {
        s.trim();
        //provjera prvog i zadnjeg znaka stringa
        if(s.charAt(0)!='(' || s.charAt(s.length()-1)!=')')
            return false;
        int numLeftParenthesis=0,numRightParenthesis=0,numOperators=0,pom=0;
        for(String a : s.split(" ")) {
            if(a.equals("(")){
                numLeftParenthesis=numLeftParenthesis+1;
                pom=0;
            }
            else if (a.equals(")")){
                numRightParenthesis=numRightParenthesis+1;
                if(pom>1) return false;
            }
            if(a.length()>1 && !a.equals("sqrt")){
                try{
                    Double.parseDouble(a);
                }
                catch(Exception e){
                    return false;
                }
            }
            if(isOperator(a) || isOperatorSqrt(a)){
                numOperators++;
                pom++;
            }
        }
        if(numLeftParenthesis!=numRightParenthesis || numOperators!=numRightParenthesis) return false;
        return true;
    }
}
