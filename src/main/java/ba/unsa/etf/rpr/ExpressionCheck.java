package ba.unsa.etf.rpr;

public class ExpressionCheck {
    private static boolean isOperatorSqrt(String s){
        return s.equals("sqrt");
    }
    private static boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*");
    }
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
    public static boolean isExpressionValid(String s) {
        s.trim();
        //provjera prvog i zadnjeg znaka stringa
        if(s.charAt(0)!='(' || s.charAt(s.length()-1)!=')')
            return false;
        int numLeftParenthesis=0,numRightParenthesis=0,numOperators=0;
        for(String a : s.split(" ")) {
            if(a.equals("(")) numLeftParenthesis=numLeftParenthesis+1;
            else if (a.equals(")")) numRightParenthesis=numRightParenthesis+1;
            if(a.length()>1 && !a.equals("sqrt")){
                try{
                    Double.parseDouble(a);
                }
                catch(Exception e){
                    return false;
                }
            }
            if(isOperator(a) || isOperatorSqrt(a)) numOperators++;
        }
        if(numLeftParenthesis!=numRightParenthesis || numOperators!=numRightParenthesis) return false;
        return true;
    }
}
