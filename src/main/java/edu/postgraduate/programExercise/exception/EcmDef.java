package edu.postgraduate.programExercise.exception;

import edu.postgraduate.programExercise.exception.myexceptions.NegativeParameterException;

public class EcmDef {


    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int result = -1;
        EcmDef ecmDef = new EcmDef();

        try {
            x = Integer.parseInt(args[0]);
            y = Integer.parseInt(args[1]);
            result = ecmDef.ecm(x, y);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NegativeParameterException e) {
            e.printStackTrace();
        }

        if(result == -1) {
            System.out.println("程序运行失败！请阅读报错信息后重新输入！");
        } else {
            System.out.println("x / y = " + result);
        }
    }

    private int ecm(int x, int y) {
        if(x < 0 || y < 0) {
            String msg = "";
            if(x < 0) {
                msg += (x + " ");
            }
            if(y < 0) {
                msg += y;
            }
            throw new NegativeParameterException("For input: " + msg);
        }
        return x / y;
    }
}
