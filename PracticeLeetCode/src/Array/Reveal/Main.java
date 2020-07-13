package Array.Reveal;
//950
//        Input: [17,13,11,2,3,5,7]
//        Output: [2,13,3,11,5,17,7]
//        Explanation:
//
//        In a deck of cards, every card has a unique integer.  You can order the deck in any order you want.
//
//        Initially, all the cards start face down (unrevealed) in one deck.
//
//        Now, you do the following steps repeatedly, until all cards are revealed:
//
//        Take the top card of the deck, reveal it, and take it out of the deck.
//        If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
//        If there are still unrevealed cards, go back to step 1.  Otherwise, stop.
//        Return an ordering of the deck that would reveal the cards in increasing order.
//
//        The first entry in the answer is considered to be the top of the deck.

public class Main {

    public static void main(String[] args) {
        int[] arr = {17,13,11,2,3,5,7};
        int[] test;
        Solution solution = new Solution();

        test = solution.deckRevealedIncreasing(arr);

        for(int n : test)
        {
            System.out.print(n);
        }
    }





}
