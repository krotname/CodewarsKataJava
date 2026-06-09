package kyu6;


import java.math.BigInteger;


public class Prime {

    //6 https://www.codewars.com/kata/5262119038c0985a5b00029f/train/java

    public static boolean isPrime(int num) {
        return num > 0 && BigInteger.valueOf(num).isProbablePrime((int) Math.log(num) + 1);
    }




}
