public class StringToIntegerAtoi {
    StringToIntegerAtoi(){
        System.out.println(myAtoi("000+85"));
    }
    public int myAtoi(String s) {
        if(s.isEmpty()) return 0;
        int index = 0;
        int startPos = 0;
        boolean zeroOnHead = false;
        boolean positiveInt = true;
        boolean validFirst = false;
        while (index < s.length()){
            char ch = s.charAt(index);
            if(!validFirst){
                if(ch == ' ') {
                    if (index >= s.length() - 1 || zeroOnHead) return 0;
                    index++;
                    continue;
                } else if (ch == '0') {
                    zeroOnHead = true;
                    if (index >= s.length() - 1) return 0;
                    index++;
                    continue;
                } else if (ch == '+') {
                    if(zeroOnHead || index + 1 >= s.length() || !Character.isDigit(s.charAt(index + 1))){
                        return 0;
                    }
                    index++;
                    continue;
                } else if (ch == '-') {
                    if(zeroOnHead || index + 1 >= s.length() || !Character.isDigit(s.charAt(index + 1))){
                        return 0;
                    }
                    int i = index - 1;
                    while (i >= 0){
                        if(s.charAt(i) != ' ') return 0;
                        i--;
                    }
                    index++;
                    positiveInt = false;
                    continue;
                } else if (!Character.isDigit(ch)) {
                    return 0;
                }else{
                    startPos = index;
                    validFirst = true;
                }
            }else{
                if(!Character.isDigit(ch)) break;
            }
            index++;
        }

        String strRes = s.substring(startPos, index);
        if(strRes.length() > 10 || Long.parseLong(strRes) > Integer.MAX_VALUE) return positiveInt ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        long result = Long.parseLong(strRes);
        return positiveInt ? Integer.parseInt(String.valueOf(result)) : -Integer.parseInt(String.valueOf(result));
    }

}
