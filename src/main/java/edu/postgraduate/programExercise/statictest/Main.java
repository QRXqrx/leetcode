package edu.postgraduate.programExercise.statictest;

import edu.postgraduate.programExercise.statictest.example.Bank;
import edu.postgraduate.programExercise.statictest.example.Order;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(Class.forName("edu.postgraduate.programExercise.statictest.example.Bank").getSimpleName()
                + ": "
                + (bank1 == bank2)); // 证明两个bank是相同的

        Order order1 = Order.getInstance();
        Order order2 = Order.getInstance();
        System.out.println(Class.forName("edu.postgraduate.programExercise.statictest.example.Order").getSimpleName()
                + ": "
                + (order1 == order2)); // 证明两个order是相同的

    }
}
