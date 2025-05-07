public class ContainerWithMostWater {
    ContainerWithMostWater(){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            if(height[i] == 0) continue;
            for (int j = i + 1; j < height.length; j++) {
                if(height[j] == 0) continue;
                int weight = j - i;
                int contain = weight * Math.min(height[i], height[j]);
                if(contain > maxArea) maxArea = contain;
            }
        }
        return maxArea;
    }

    public int maxAreaOptimize(int[] height) {
        int maxArea = 0;
        int bigest = 0;
        for (int i = 0, j = height.length - 1; i <= j; i++, j--) {
            bigest = Math.max(Math.max(height[i], height[j]), bigest);

        }

        for (int i = 0; i < height.length; i++) {
            if(height[i] == 0) continue;
            for (int j = i + 1; j < height.length; j++) {
                if(height[j] == 0) continue;
                int weight = j - i;
                int contain = weight * Math.min(height[i], height[j]);
                if(contain > maxArea) maxArea = contain;
            }
        }
        return maxArea;
    }
}
