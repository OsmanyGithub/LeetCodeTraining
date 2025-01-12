class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            if (nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }
            
            else if(nums1[i] < nums2[j]){
                i++;
            }
            
            else{
                j++;
            }
        }
        
        int [] result = new int[list.size()];
        for (i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}