namespace Exercises
{
    public partial class Exercises
    {
        /*
        Given three ints, a b c, return true if one of them is 10 or more less than one of the others.
        LessBy10(1, 7, 11) → true
        LessBy10(1, 7, 10) → false
        LessBy10(11, 1, 7) → true
        */
        public bool LessBy10(int a, int b, int c)
        {
            // Split up over multiple lines to increase readability
            bool LessBy10 =
                (b - a) >= 10 ||
                (b - c) >= 10 ||
                (c - a) >= 10 ||
                (c - b) >= 10 ||
                (a - b) >= 10 ||
                (a - c) >= 10;

            // Or use Math.min and Math.max to get the low and high values and see if the delta is more than 10

            return LessBy10;
        }
    }
}
