import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class LongestPalindromicSubstring {
    LongestPalindromicSubstring(){
        System.out.println(longestPalindrome("tattarrattat"));
    }
    public String longestPalindrome(String s) {
        StringBuilder result = new StringBuilder(String.valueOf(s.charAt(0)));
        if(s.length() == 1) return s;
        if(s.charAt(0) == s.charAt(1)) result = new StringBuilder(String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(1)));
        if(s.length() == 2) return result.toString();

        for (int i = 1; i < s.length(); i++) {
            if(result.length() == 1 && i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                result = new StringBuilder(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i+1)));
            }
            ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
            arrayDeque.add(s.charAt(i));
            int index = i;

            while (index + 1 < s.length() && s.charAt(index) == s.charAt(index + 1)){
                arrayDeque.addLast(s.charAt(index + 1));
                index++;
            }

            int left = i - 1, right = index + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                arrayDeque.addFirst(s.charAt(left));
                arrayDeque.addLast(s.charAt(right));
                left--;
                right++;
            }
            if(arrayDeque.size() >= 2){
                boolean allSame = arrayDeque.stream().distinct().count() <= 1;
                if(allSame){
                    if(left >= 0 && arrayDeque.getFirst() == s.charAt(left)){
                        arrayDeque.addFirst(s.charAt(left));
                    }
                    if(right < s.length() && arrayDeque.getFirst() == s.charAt(right)){
                        arrayDeque.addLast(s.charAt(right));
                    }
                }
            }
            if(arrayDeque.size() > result.length()){
                result = new StringBuilder(arrayDeque.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining()));
            }
        }

        return result.toString();
    }

    /**
     * xxaxx
     * axx
     */
}
