namespace Exercises
{
    public partial class Exercises
    {
        /*
        Given an int array length 2, return true if it contains a 2 or a 3.
        Has23([2, 5]) → true
        Has23([4, 3]) → true
        Has23([4, 5]) → false
        */
        public bool Has23(int[] nums)
        {
            for (int i = 0; i < nums.Length; i++)
            {
                if (nums[i] == 2 || nums[i] == 3)
                {
                    return true;
                }
            }

            return false;
        }
    }
}
