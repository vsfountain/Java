package com.ternaryoperators.minimum;
/**
 * Q10. Find the minimum of two numbers using ternary operators.
 * @author Kristen
 * @version 10/29/2018
 */
import java.util.Scanner;
public class TernaryOperators 
{
    public static void main(String[] args) 
    {
        int num1, num2, result, temp;
        /* Scanner is used for getting user input. 
         * The nextInt() method of scanner reads the
         * integer entered by user.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Number:");
        num1 = scanner.nextInt();
        System.out.println("Enter Second Number:");
        num2 = scanner.nextInt();
       
        /* In first step we are comparing only num1 and
         * num2  to get final result.
         */
        
        temp = num1 < num2 ? num1:num2;
        result = num2< temp ? num2:temp;
        System.out.println("Smallest Number is:"+result);
    }
}


