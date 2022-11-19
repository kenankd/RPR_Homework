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
    public static boolean isOperatorSqrt(String s){
        return s.equals("sqrt");
    }

    /**
     * checks if string is an operator
     * @param s string
     * @return  true if given string is an operator
     */
    public static boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*");
    }

    /**
     * checks if string is an operand
     * @param s string
     * @return true if string is an operand
     */
    public static boolean isOperand(String s){
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
        //smatrajmo da je prazan izraz takodjer nevalidan
        if(s.length()==0) return false;
        //provjera prvog i zadnjeg znaka stringa
        if(s.charAt(0)!='(' || s.charAt(s.length()-1)!=')')
            return false;

        int numLeftParenthesis=0,numRightParenthesis=0,numOperators=0,pom=0;
        boolean div = false,sqrt=false;
        for(String a : s.split(" ")) {
            if(a.equals("(")){
                numLeftParenthesis=numLeftParenthesis+1;
                pom=0;
            }
            else if (a.equals(")")){
                numRightParenthesis=numRightParenthesis+1;
                if(pom>1) return false;
                pom=0;
            }
            //provjera da li je sve odvojeno spaceom
            else if(a.length()>1 && !a.equals("sqrt")){
                try{
                    Double.parseDouble(a);
                }
                catch(Exception e){
                    return false;
                }
            }
            //provjera sintakse sqrt ( 4 )
            if(sqrt==true && !a.equals("(")) return false;
            if(isOperator(a)){
                //zbog dijeljenja sa nulom
                if(a.equals("/")) div = true;
                else div = false;
                numOperators++;
                pom++;
                sqrt=false;
            }
            if(isOperatorSqrt(a)){
                sqrt = true;
                pom--;
                numOperators++;
            }
            else sqrt = false;
            if(a.equals("0") && div == true) return false;
        }
        if(numLeftParenthesis!=numRightParenthesis || numOperators!=numRightParenthesis) return false;
        //nakon svakog operatora mora ici ili operand ili otvorena zagrada ili operator sqrt
        for(int i=0;i<s.length()-1;i++){
            if(isOperator(String.valueOf(s.charAt(i))) && !isOperand(String.valueOf(s.charAt(i+2))) && s.charAt(i+2)!='(' && !s.substring(i+2,i+6).equals("sqrt")) return false;
        }
        return true;
    }
}
