class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // 1 2 2 3 0 0   
        // 2 5 6       
        
        // i=0, j=0; -> 1 < 2 유지 i++
        // i=1, j=0; -> 2 <= 2 -> 유지 i++
        // i=2, j=0; -> 3 > 2 -> 오른쪽으로 shift + 값 넣기
        // i=3, j=1; -> 10 > 8 -> 오른쪽으로 shift + 8 넣기
        // i=4, j=2; -> 10 < 12 -> 유지
        
        int length = m + n;
        
        int i = 0;
        int j = 0;
        
        while (i < length && j < n) {
            if (nums1[i] > nums2[j]) {
                System.out.println("i = " + i + ", j = " + j + " -> " + nums1[i] + " > " + nums2[j]);
                // 오른쪽으로 shift + 값 넣기
                for (int left = length - 1; left > i; left--) {
                    nums1[left] = nums1[left - 1];
                    System.out.println("left : " + left + " -> " + nums1[left] + ", " + nums1[left - 1]);
                }
                nums1[i] = nums2[j];
                i++;
                j++;
                m++;
            }else {
                System.out.println("i = " + i + ", j = " + j + "-> " + nums1[i] + " <= " + nums2[j]);
                i++;
            }
        }
        
        if (m < length) {
            
            while (m < length) {
                nums1[m] = nums2[j];
                m++;
                j++;
            }
            
        }
        
    }
}