public class IntegerToRoman {
    IntegerToRoman(){
        System.out.println(intToRoman(3749));
    }
    public String intToRoman(int num) {
        String numStr = String.valueOf(num);
        String result = "";
        while(!numStr.isEmpty()){
            int unit = Integer.parseInt(String.valueOf(numStr.charAt(0)));
            if(unit > 0) {
                result += buildAPart(unit, numStr.length());
            }
            numStr = numStr.substring(1);
        }
        return result;
    }

    private String buildAPart(int num, int magnitude){
        String five = "", unit = "", nine = "";
        String strBuild = "";
        if(magnitude == 4){
            if(num == 1) return "M";
            if(num == 2) return "MM";
            if(num == 3) return "MMM";
        } else if (magnitude == 3) {
            five = "D";
            unit = "C";
            nine = "CM";
        } else if (magnitude == 2) {
            five = "L";
            unit = "X";
            nine = "XC";
        }else {
            five = "V";
            unit = "I";
            nine = "IX";
        }
        if(num == 5){
            return five;
        } else if (num == 9) {
            return nine;
        }else if(num == 4){
            return unit + five;
        }else{
            int stop = num;
            if (num - 5 > 0){
                stop = num - 5;
                strBuild = five;
            }
            for (int i = 0; i < stop; i++) {
                strBuild += unit;
            }
        }
        return strBuild;
    }
    /**
     * x = 7 | 2
     * 5
     * x
     *
     */
}
