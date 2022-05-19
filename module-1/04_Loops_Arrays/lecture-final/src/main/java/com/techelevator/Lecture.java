package com.techelevator;

public class Lecture {

    public static void main(String[] args) {
        int[] array = { 80, 8080, 443 }; // [80, 8080, 443]

        for ( int i = 0; i <= array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /*
    1. Return the created array
    */
    public int[] returnArray() {
        int[] array = { 80, 8080, 443 }; // [80, 8080, 443]
        return array;
    }

    /*
    2. Return the first element of the array
    */
    public int returnFirstElement() {
        int[] portNumbers = { 80, 8080, 443 };
        return portNumbers[0];
    }

    /*
    3. Return the last element of the array
    */
    public int returnLastElement() {
        int[] portNumbers = { 80, 8080, 443 };
        return portNumbers[2];
    }

    /*
    4. Return the first element of the array from the parameters
    */
    public int returnFirstElementOfParam(int[] passedInArray) {
        if (passedInArray.length > 0) {
            return passedInArray[0];
        }
        return 0;
    }

    /*
    5. Return the last element of the array from the parameters
    */
    public int returnLastElementOfParam(int[] passedInArray) {
        int lastIndex = passedInArray.length - 1;

        return passedInArray[lastIndex];
    }

    /*
    6. Here, a variable is defined within a block. How can we get the value of that outside of the block in order to
       return it? There are a couple of different ways of doing this, what can you come up with?
    */
    public int returnVariableFromBlock(int number) {
        int result;
        { // A new block with scoped variables

            result = number * 5;

        } // the result variable disappears here

        return result; // We want to return result here. How?
    }

    /*
    7. What will the variable result be at the end of the method? Change the number in the logic expression so that
       it returns true.
    */
    public boolean returnOperationInBlock() {
        int result = 5;

        {
            int multiplier = 10;
            result *= multiplier; // result = result * multiplier
        }

        return result == 50; // <-- Change the number to match result and make this be true
    }

    /*
    8. Return the only variable that is in scope at the return statement.
    */
    public double returnInScopeVariable() {
        double one = 1.0;
        {
            double three = 3.0;
            one += three;
            {
                double four = 4.0;
                three = four - one;
                one++;
            }

            double five = 5.0;
            double eight = five + three;
        }

        return one;
    }

    /*
    9. How many times do we go through this loop?
        Change the number in the logic expression so that it returns true.

        counter -> 4
        i -> 4

    */
    public boolean returnCounterFromLoop() {

        int[] arrayToLoopThrough = { 3, 4, 2, 9 };

        int counter = 0; // Must be started outside the block so that have access to it after the block

        for (int i = 0; i <= arrayToLoopThrough.length; i++) {
            counter++;
        }

        return counter == 4; // What should the number be to return true?
    }

    /*
    10. This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCorrectCount() {
        int[] arrayToLoopThrough = { 4, 23, 9 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 1; i <= arrayToLoopThrough.length; i++) {
            counter += 1;
        }

        return counter == 3;
    }

    /*
    11. This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCountCorrectTimes() {
        int[] arrayToLoopThrough = { 4, 23, 9, 4, 33 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter = counter + 1;
        }

        return counter == 5;
    }

    /*
    12. We want this loop to only count every other item starting at zero. What needs to change in the loop for
        it to do that?

        sum -> 12
        i -> 6
    */
    public boolean returnSumEveryOtherNumber() {
        int[] arrayToLoopThrough = { 4, 3, 4, 1, 4, 6 };

        int sum = 0;

        //     Start;       Keep going while       Increment by;
        for (int i = 0; i < arrayToLoopThrough.length; i = i + 2) {
            sum = sum + arrayToLoopThrough[i];
        }

        return sum == 12;
    }


    public boolean doesAOneExist(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                return true;
            }
        }

        return false;
    }

    public int howManyOnes(int[] nums) {
        int howMany = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                howMany++;
            }
        }

        return howMany;
    }

    public boolean areThereTwoOnes(int[] nums) {
        int howMany = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                howMany++;
            }
        }

        return howMany == 2;
    }

    public void printNamesInReverse(String[] names) {

        for (int i = names.length - 1; i >= 0; i--) {
            System.out.println(names[i]);
        }
    }

    public void assignTeams(String[] names) {
        String[] evenTeam = new String[(names.length / 2) + 1];
        String[] oddTeam = new String[(names.length / 2)];

        for (int i = 0; i < names.length; i += 2) {

        }

        for (int i = 1; i < names.length; i += 2) {

        }
    }


    /*
        Stack                       Heap
        x = 1
        y = 3

        array1 = 0x1111 ------>    [ 1, 5, 3 ]
        array2 = 0x1111

        array3 = 0x2222 ------->   [ 0, 0, 0 ]
     */
    public void testReferenceVsPrimitive() {
        int x = 1;

        int y = x;

        y += 2;


//        int[] array1 = { 1, 2, 3 };
        int[] array1 = new int[3];
        array1[0] = 1;
        array1[1] = 2;
        array1[2] = 3;
        int[] array2 = array1;

        int[] array3 = new int[3];

        array2[1] = 5;
    }



}