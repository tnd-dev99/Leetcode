public class Main {
    public static void main(String[] args) {
        //AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        //LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        //MergeTwoLists mergeTwoLists = new MergeTwoLists();
//        MergeSortedArray88 mergeSortedArray88 = new MergeSortedArray88();
        ReverseInteger reverseInteger = new ReverseInteger();
    }
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            s[i] = s[j];
        }
    }
}