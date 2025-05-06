public class ReverseInteger {
    ReverseInteger(){
        System.out.println(reverse(-2147483648));;
    }
    public int reverse(int x) {
        boolean positiveInteger = x > 0;
        if(x == 0) return 0;
        String numberStr = String.valueOf(Math.abs(x));
        if(Math.abs(x) < 0) return 0;
        boolean skipZero = true;
        StringBuilder resultStr = new StringBuilder();
        for (int j = numberStr.length() - 1; j >= 0; j--) {
            if(numberStr.charAt(j) == '0' && skipZero){
                continue;
            }
            skipZero = false;
            resultStr.append(numberStr.charAt(j));
        }
        long longNumber = Long.parseLong(resultStr.toString());
        if(longNumber > Integer.MAX_VALUE) return 0;
        return positiveInteger ? Integer.parseInt(resultStr.toString()) : -Integer.parseInt(resultStr.toString());
    }
}
