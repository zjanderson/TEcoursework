﻿namespace Exercises
{
    public partial class Exercises
    {
        /*
        Given an int array length 2, return true if it does not contain a 2 or 3.
        No23([4, 5]) → true
        No23([4, 2]) → false
        No23([3, 5]) → false
        */
        public bool No23(int[] nums)
        {
            for (int i = 0; i < nums.Length; i++)
            {
                if (nums[i] == 2 || nums[i] == 3)
                {
                    return false;
                }
            }

            return true;
        }
    }
}
