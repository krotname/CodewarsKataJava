package kyu6;



public class TenMinWalk {

    //6 https://www.codewars.com/kata/54da539698b8a2ad76000228/train/java

    public static boolean isValid(char[] walk) {
        if (walk == null || walk.length != 10) {
            return false;
        }

        int northSouth = 0;
        int eastWest = 0;
        for (char c : walk) {
            switch (c) {
                case 'n' -> northSouth++;
                case 's' -> northSouth--;
                case 'e' -> eastWest++;
                case 'w' -> eastWest--;
                default -> {
                    return false;
                }
            }
        }
        return northSouth == 0 && eastWest == 0;
    }



}
