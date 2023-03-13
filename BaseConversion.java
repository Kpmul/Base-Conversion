/*
The goal is to change a given number from one base to another.
The first line contains an integer which is the base that the number N is represented in (base#1).
The second line contains an integer which is the base that the number N should be transformed into (base#2).
The third line contains a value which represents N in the specified base. 
 */

import java.util.*;

public class baseConversion {

    public static String baseList = "0123456789abcdefghijklmnopqrstuvwxyz";
    
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int b1 = Integer.parseInt(sc.nextLine());
        int b2 = Integer.parseInt(sc.nextLine());
        String check = sc.nextLine();

        long base10 = convertBase10(check,b1);
        System.out.println(convertToBase(base10, b2));

    }
    public static long convertBase10(String check, int base1){

        long sum = 0;
        int power = 0;

        for(int i=check.length()-1;i>=0;i--){
            char c = check.charAt(i);
            int d = baseList.indexOf(c);
            sum += d*(Math.pow(base1,power));
            power++;
        }
        return sum;
    }

    public static String convertToBase(long base10, int b2){

        long rem;
        String str = "";
        String revStr = "";

        while(base10 > 0){

            rem = base10 % b2;
            int rem2 = (int)rem;
            str += baseList.charAt(rem2);
            base10 = base10 / b2;
        }
        for(int i=str.length()-1;i>=0;i--){
            revStr += str.charAt(i);
        }
        return revStr;
    }
}
