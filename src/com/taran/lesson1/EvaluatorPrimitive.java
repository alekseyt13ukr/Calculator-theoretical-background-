package com.taran.lesson1;

public enum EvaluatorPrimitive {
    PLUS("+") {
        String evaluator(Number secondOperand, Number firstOperand) {
            int resultEvaluatePrimitiveExpression = firstOperand.getValue() + secondOperand.getValue();
            return String.valueOf(resultEvaluatePrimitiveExpression);
        }
    },
    MINUS("-") {
        String evaluator(Number secondOperand, Number firstOperand) {
            int resultEvaluatePrimitiveExpression = firstOperand.getValue() - secondOperand.getValue();
            return String.valueOf(resultEvaluatePrimitiveExpression);
        }
    },
    MULTIPLE("*") {
        String evaluator(Number secondOperand, Number firstOperand) {
            int resultEvaluatePrimitiveExpression = firstOperand.getValue() * secondOperand.getValue();
            return String.valueOf(resultEvaluatePrimitiveExpression);
        }
    },
    DIVIDE("/") {
        String evaluator(Number secondOperand, Number firstOperand) {
            int resultEvaluatePrimitiveExpression = firstOperand.getValue() / secondOperand.getValue();
            return String.valueOf(resultEvaluatePrimitiveExpression);
        }
    };

    private final String sign;

    EvaluatorPrimitive(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return sign;
    }

    abstract String evaluator(Number secondOperand, Number firstOperand);
}
