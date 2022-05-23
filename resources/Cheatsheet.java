package com.techelevator;

public class Cheatsheet {

    public static void main(String[] args) {









        /*
        Variables
         */

        // Declaration
        int wholeNumber;
        boolean isColdOutside;

        // Initialization
        double decimalNumber = 1.5;

        // Assignment
        decimalNumber = 2.5;

        /* Data Types

        boolean -> true or false

        byte - whole number
        short - whole number
        int - whole number
        long - whole number

        float - floating point number
        double - floating point number

        char -> a single character, denoted with ''
        String -> a string of 0 or more characters, denoted with ""

         */


        /*
        Arithmetic Expressions
         */

        int sum = 1 + 2;
        int product = 5 * 7;
        int complexProduct = 5 * 7 * 25;

        int one = 1;
        int two = 2;
        int sumWithVariables = one + two; // expressions can use variables in place of literal values

        int remainder = 5 % 2; // remainder is 1


        /* Boolean Expressions contain either Comparison Operators or Logical Operators (or both)
         */

        /*
        Comparison Operators

        IS EQUAL TO     -> ==

        IS NOT EQUAL TO -> !=

        IS GREATER THAN ->  >

        IS LESS THAN    ->  <

        IS GREATER THAN OR EQUAL TO -> >=
        IS LESS THAN OR EQUAL TO    -> <=
         */


        /*
        Logical Operators

        NOT -> !    !true is false
                    !false is true

        OR -> ||    true || anything is true
                    false || false is false

        AND -> &&   true && true is true
                    false && anything is false

        XOR -> ^    opposites are true. sames are false e.g.
                    false ^ false is false
                    true ^ false is true
         */


        /*
        Logical Branching

        -> 1 if block
        -> can have 0 or many else if blocks
        -> can have 0 or 1 else block

        if(<boolean_expression>) {

        } else if (<boolean_expression>) {

        } else if (<boolean_expression>) {

        } else {

        }

         */

        /*
        Arrays
         */

        // create an array of size 4 with numbers in it
        int[] numbers = { 1, 2, 5, -1 };

        // create an array of size 4 with default values in it i.e. [ 0, 0, 0, 0 ]
        int[] numbers2 = new int[4];

        // access an array's element at index 2, assign it's value to a variable
        int someNumber = numbers[2];

        // assign value within the array to be 3
        numbers[2] = 3;

        /*
        Loops
         */

        // loop through numbers from 0 until it reaches the end
        for (int i = 0; i < numbers.length; i++) {

        }

    }


}

