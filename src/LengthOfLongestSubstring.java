import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    LengthOfLongestSubstring(){
        System.out.println(lengthOfLongestSubstring("pwwkew"));;
    }

    /**
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * loop chuỗi -> chọn kí tự đầu -> tạo Set để lưu va kiem tra
     * -> neu ki tu da co thi chon ki tu ke tiep
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<String> currentString = new HashSet<>();
            currentString.add(String.valueOf(s.charAt(i)));
            for (int j = i + 1; j < s.length(); j++) {
                if(currentString.contains(String.valueOf(s.charAt(j)))) break;
                currentString.add(String.valueOf(s.charAt(j)));
            }
            if(result < currentString.size()) result = currentString.size();
        }
        return result;
    }
}
