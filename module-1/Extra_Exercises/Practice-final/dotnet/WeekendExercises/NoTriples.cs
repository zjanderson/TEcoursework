﻿namespace Exercises
{
    public partial class Exercises
    {
        /*
        Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array.
        Return true if the array does not contain any triples.
        NoTriples([1, 1, 2, 2, 1]) → true
        NoTriples([1, 1, 2, 2, 2, 1]) → false
        NoTriples([1, 1, 1, 2, 2, 2, 1]) → false
        */
        public bool NoTriples(int[] nums)
        {
            for (int i = 0; i < nums.Length - 2; i++)
            {
                // If we have three sequential valies that are the same
                if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2])
                {
                    return false;
                }
            }

            return true;
        }
    }
}
