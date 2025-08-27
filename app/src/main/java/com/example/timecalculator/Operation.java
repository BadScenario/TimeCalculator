package com.example.timecalculator;

public class Operation {
    public static int getSec(String time) {
        int hour = 0;
        int minute = 0;
        int sec = 0;
        int sum;
        String[] arrayString = time.split("[h,m,s]");
        if (arrayString.length == 3) {
            hour = Integer.parseInt(arrayString[0]);
            minute = Integer.parseInt(arrayString[1]);
            sec = Integer.parseInt(arrayString[2]);
        }
        if (arrayString.length == 2) {
            minute = Integer.parseInt(arrayString[0]);
            sec = Integer.parseInt(arrayString[1]);
        }
        if (arrayString.length == 1) {
            sec = Integer.parseInt(arrayString[0]);
        }
        sum = hour * 3600 + minute * 60 + sec;

        return sum;
    }

    public static String getSum(String first, String second) {
        int operandOne = getSec(first);
        int operandTwo = getSec(second);
        int result = operandOne + operandTwo;
        return getStringFormat(result);
    }

    public static String getDiv(String first, String second) {
        int operandOne = getSec(first);
        int operandTwo = getSec(second);
        int result = operandOne - operandTwo;
        return getStringFormat(result);
    }
    public static String getStringFormat(int result) {
        int minute = 0;
        int sec = 0;
        int hour = result / 3600;
        if (hour >= 1) {
            minute = result % 3600 / 60;
        } else {
            minute = result / 60;
        }
        if (minute >= 1) {
            sec = result % 60;
        } else {
            sec = result;
        }
        return "" + hour + "h" + minute + "m" + sec + "s";
    }
}
