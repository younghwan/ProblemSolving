package Array.Reveal;

import java.util.Arrays;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {

        int[] ans = new int[deck.length];
        Arrays.sort(deck);

        for(int i = 0; i<deck.length; i++)
        {
            if(i%2 == 0)
            {
                ans[i] = deck[i];
            }
            else
            {
                ans[i] = -1;
            }
        }

        return ans;
    }
}