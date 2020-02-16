package edu.postgraduate.programExercise.abstracttest.example.bank;

public class ManageMoney extends TransactionTemplate{
    @Override
    public void transact() {
        System.out.println("I have 2,000,000$ in my account, I need to manage money!");
    }
}
