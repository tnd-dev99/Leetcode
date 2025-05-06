public class MergeSortedArray88 {
    MergeSortedArray88(){
        merge(new int[]{0}, 0, new int[]{1}, 1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }

        if(m > 0 && n > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = m - 1; j >= 0; j--) {
                    if(nums2[i] >= nums1[j]){
                        nums1[j + 1] = nums2[i];
                        break;
                    }else{
                        nums1[j + 1] = nums1[j];
                        nums1[j] = nums2[i];
                    }
                }
                m++;
            }
        }

        System.out.println(nums1);
    }
}
