namespace Exercises
{
    public partial class Exercises
    {
        /*
        Given an array of ints, return true if every element is a 1 or a 4.
        Only14([1, 4, 1, 4]) → true
        Only14([1, 4, 2, 4]) → false
        Only14([1, 1]) → true
        */
        public bool Only14(int[] nums)
        {
            for (int i = 0; i < nums.Length; i++)
            {
                if (nums[i] != 1 && nums[i] != 4)
                {
                    return false;
                }
            }

            return true;
        }
    }
}
