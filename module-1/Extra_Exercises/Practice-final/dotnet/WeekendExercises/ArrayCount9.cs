namespace Exercises
{
    public partial class Exercises
    {
        /*
        Given an array of ints, return the number of 9's in the array.
        ArrayCount9([1, 2, 9]) → 1
        ArrayCount9([1, 9, 9]) → 2
        ArrayCount9([1, 9, 9, 3, 9]) → 3
        */
        public int ArrayCount9(int[] nums)
        {
            int num9s = 0;

            // Loop through all of the numbers
            for (int i = 0; i < nums.Length; i++)
            {
                // If we see a 9, increment num9s
                if (nums[i] == 9)
                {
                    num9s++;
                }
            }

            return num9s;
        }
    }
}
