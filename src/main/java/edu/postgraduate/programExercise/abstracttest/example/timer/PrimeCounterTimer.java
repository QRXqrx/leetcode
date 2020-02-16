package edu.postgraduate.programExercise.abstracttest.example.timer;

public class PrimeCounterTimer extends TimerTemplate{

    private boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void method() {
        final int N = 1000;
        for(int i = 2; i <= N; i++) {
            if(isPrime(i)) {
                System.out.println(i);
            }
        }
    }

}
