package edu.postgraduate.programExercise.abstracttest.example.bank;

public class DrawMoney extends TransactionTemplate{
    @Override
    public void transact() {
        System.out.println("I need to draw some money!");
    }
}
