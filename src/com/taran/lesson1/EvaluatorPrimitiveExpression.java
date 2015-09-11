package com.taran.lesson1;

public class EvaluatorPrimitiveExpression {

    private String sign;
    private Number secondOperand;
    private Number firstOperand;

    public EvaluatorPrimitiveExpression(String sign, Number secondOperand, Number firstOperand) {
        this.sign = sign;
        this.secondOperand = secondOperand;
        this.firstOperand = firstOperand;
    }

    public String evaluatePrimitiveExpression() {
        int resultEvaluatePrimitiveExpression = 0;
        switch (sign) {
            case ("+") :
                resultEvaluatePrimitiveExpression = firstOperand.getValue() + secondOperand.getValue();
                break;
            case ("-") :
                resultEvaluatePrimitiveExpression = firstOperand.getValue() - secondOperand.getValue();
                break;
            case ("*") :
                resultEvaluatePrimitiveExpression = firstOperand.getValue() * secondOperand.getValue();
                break;
            case ("/") :
                resultEvaluatePrimitiveExpression = firstOperand.getValue() / secondOperand.getValue();
                break;
        }

        return String.valueOf(resultEvaluatePrimitiveExpression);
    }
}
