import java.util.HashMap;
import java.util.Map;

public class ZigzagConversion {
    ZigzagConversion(){
        System.out.println(convert("A", 1));
    }
    public String convert(String s, int numRows) {
        Map<Integer, StringBuilder> rowMap = new HashMap<Integer, StringBuilder>();
        StringBuilder result = new StringBuilder();
        int row = 1;
        boolean down = true;
        for (int i = 0; i < s.length(); i++) {
            if(down){
                StringBuilder stringBuilder = new StringBuilder();
                if(rowMap.containsKey(row)){
                    stringBuilder = rowMap.get(row);
                }
                stringBuilder.append(s.charAt(i));
                rowMap.put(row, stringBuilder);
                if(row < numRows) row++;
                if(row == numRows) down = false;
            }else{
                StringBuilder stringBuilder = new StringBuilder();
                if(rowMap.containsKey(row)){
                    stringBuilder = rowMap.get(row);
                }
                stringBuilder.append(s.charAt(i));
                rowMap.put(row, stringBuilder);
                if(row > 1) row--;
                if(row == 1) down = true;
            }
        }
        rowMap.forEach((integer, stringBuilder) -> {
            result.append(stringBuilder);
        });

        return result.toString();
    }


    /**
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     */
}
