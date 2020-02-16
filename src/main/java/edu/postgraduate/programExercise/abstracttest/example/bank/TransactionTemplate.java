package edu.postgraduate.programExercise.abstracttest.example.bank;

 public abstract class TransactionTemplate {

    private void takeNumber() {
        System.out.println("Take number...");
    }
    private void evaluate() {
        System.out.println("Evaluate this transaction...");
    }

    public abstract void transact();

    public void process() {
        takeNumber();
        transact();
        evaluate();
    }

}
