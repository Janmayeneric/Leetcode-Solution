class Solution {
    /**
    * Brute force
    *
    *
    * -------------------------OverView 
    *  Time: 11ms
    *  Memory: 51.2MB
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i:nums1){
            list.add(i);
        }
        for(int i:nums2){
            list.add(i);
        }
        
        Collections.sort(list);

        int mid = list.size() /2;
        if(list.size() % 2 == 0) return (list.get(mid)+list.get(mid-1))/2.; 
            else return list.get(mid);
    }
}