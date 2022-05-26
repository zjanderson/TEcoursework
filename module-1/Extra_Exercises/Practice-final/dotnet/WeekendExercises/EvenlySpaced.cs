namespace Exercises
{
    public partial class Exercises
    {
        /*
        Given three ints, a b c, one of them is small, one is medium and one is large. Return true if the three values are evenly
        spaced, so the difference between small and medium is the same as the difference between medium and large.
        EvenlySpaced(2, 4, 6) → true
        EvenlySpaced(4, 6, 2) → true
        EvenlySpaced(4, 6, 3) → false
        */
        public bool EvenlySpaced(int a, int b, int c)
        {
            int smallestNumber = (a < b) ? a : b;
            smallestNumber = (smallestNumber < c) ? smallestNumber : c;

            int largestNumber = (a > b) ? a : b;
            largestNumber = (largestNumber > c) ? largestNumber : c;

            int mediumNumber = 0;
            if (a < b && b < c)
            {
                mediumNumber = b;
            }
            else if (c < a && a < b)
            {
                mediumNumber = a;
            }
            else
            {
                mediumNumber = c;
            }

            return (mediumNumber - smallestNumber) == (largestNumber - mediumNumber);
        }
    }
}
