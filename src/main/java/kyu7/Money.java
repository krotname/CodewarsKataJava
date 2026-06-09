package kyu7;



public class Money {

    //7 https://www.codewars.com/kata/563f037412e5ada593000114/train/java

    public static int calculateYears(double principal, double interest, double tax, double desired) {
        if (principal >= desired) return 0;
        int years = 0;
        while (principal < desired) {
            double addOneYear = principal * interest;
            principal = principal + (addOneYear - addOneYear * tax);
            years++;
        }
        return years;
    }

}
