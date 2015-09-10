package com.taran.lesson1;

public class CalculatePrimitiveExpr {

    private String sign;
    private Number secondOperand;
    private Number firstOperand;

    public CalculatePrimitiveExpr(String sign, Number secondOperand, Number firstOperand) {
        this.sign = sign;
        this.secondOperand = secondOperand;
        this.firstOperand = firstOperand;
    }

    public String calculatePrimitiveExpr() {
        int resultEvaluatePrimExpr = 0;
        switch (sign) {
            case ("+") :
                resultEvaluatePrimExpr = firstOperand.parseInt() + secondOperand.parseInt();
                break;
            case ("-") :
                resultEvaluatePrimExpr = firstOperand.parseInt() - secondOperand.parseInt();
                break;
            case ("*") :
                resultEvaluatePrimExpr = firstOperand.parseInt() * secondOperand.parseInt();
                break;
            case ("/") :
                resultEvaluatePrimExpr = firstOperand.parseInt() / secondOperand.parseInt();
                break;
        }

        String resultEvaluatePrimExprStr = String.valueOf(resultEvaluatePrimExpr);
        return resultEvaluatePrimExprStr;
    }
}
