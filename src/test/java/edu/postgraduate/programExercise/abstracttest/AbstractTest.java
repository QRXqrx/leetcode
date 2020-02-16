package edu.postgraduate.programExercise.abstracttest;

import edu.postgraduate.programExercise.abstracttest.example.bank.DrawMoney;
import edu.postgraduate.programExercise.abstracttest.example.bank.ManageMoney;
import edu.postgraduate.programExercise.abstracttest.example.timer.PrimeCounterTimer;
import org.junit.Test;


public class AbstractTest {
    @Test
    public void testBankTransaction() {
        DrawMoney drawMoney = new DrawMoney();
        drawMoney.process();
        System.out.println("--------------------------");
        ManageMoney manageMoney = new ManageMoney();
        manageMoney.process();
    }

    @Test
    public void testTimer() {
        PrimeCounterTimer timer = new PrimeCounterTimer();
        timer.printTime();
    }
}
