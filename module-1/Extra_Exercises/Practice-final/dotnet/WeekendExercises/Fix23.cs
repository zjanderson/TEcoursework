namespace Exercises
{
    public partial class Exercises
    {
        /*
        Given an int array length 3, if there is a 2 in the array immediately followed by a 3, set the 3 element to 0.
        Return the changed array.
        Fix23([1, 2, 3]) → [1, 2, 0]
        Fix23([2, 3, 5]) → [2, 0, 5]
        Fix23([1, 2, 1]) → [1, 2, 1]
        */
        public int[] Fix23(int[] nums)
        {
            for (int i = 0; i < nums.Length - 1; i++)
            {
                if (nums[i] == 2 && nums[i + 1] == 3)
                {
                    nums[i + 1] = 0;
                }
            }

            return nums;
        }
    }
}
