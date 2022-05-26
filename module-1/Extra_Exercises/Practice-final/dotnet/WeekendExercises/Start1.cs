namespace Exercises
{
    public partial class Exercises
    {
        /*
        Start with 2 int arrays, a and b, of any length. Return how many of the arrays have 1 as their first element.
        Start1([1, 2, 3], [1, 3]) → 2
        Start1([7, 2, 3], [1]) → 1
        Start1([1, 2], []) → 1
        */
        public int Start1(int[] a, int[] b)
        {
            int numArrays = 0;

            if (a.Length > 0 && a[0] == 1)
            {
                numArrays++;
            }
            if (b.Length > 0 && b[0] == 1)
            {
                numArrays++;
            }

            return numArrays;
        }
    }
}
