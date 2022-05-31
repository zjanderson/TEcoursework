package com.techelevator;

public  class TwoCharacters {

        /*
	 Given a string and an index, return a string length 2 starting at the given index.
	 If the index is  too big or too small to define a string length 2,
	    use the first 2 chars.
	 The string length will be at least 2.

	 twoChar("java", 0) → "ja"
	 twoChar("java", 2) → "va"
	 twoChar("java", 3) → "ja"

	 diagram a solution?
     */
        public static void main(String[] args) {
        twoChar("java", 0);
        twoChar("java", 2);
        twoChar("java", 3);
        twoChar("java", 4);
        twoChar("java", -1);
        twoChar("Hello", 0);
        twoChar("Hello", 1);
        twoChar("Hello", 99);
        twoChar("Hello", 3);
        twoChar("Hello", 4);
        twoChar("Hello", 5);
        twoChar("Hello", -7);
        twoChar("Hello", 6);
        twoChar("Hello", -1);
        twoChar("yay", 0);

        }


    public static String twoChar(String str, int index) {
       String result = "";

       if (index < 0  || index + 2 > str.length() ){
               result = str.substring(0,2);
       } else {

               result = str.substring(index, index + 2);
       }
        return result;
    }
}
