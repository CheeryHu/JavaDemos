package com.cheeryhu.java.design.memento;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class Client {

    public static void main(String[] args){
        Calculator calculator = new CalculatorImp();
        calculator.setFirstNumber(10);
        calculator.setSecondNumber(100);

        System.out.println(calculator.getCalculationResult());

        PreviousCalculationToCareTaker memento = calculator.backupLastCalculation();
        calculator.setFirstNumber(17);
        calculator.setSecondNumber(-290);

        System.out.println(calculator.getCalculationResult());
        calculator.restorePreviousCalculation(memento);
        System.out.println(calculator.getCalculationResult());
    }
}
