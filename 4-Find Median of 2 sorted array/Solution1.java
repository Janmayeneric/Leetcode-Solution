class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
        *   This is a very complicated way to find the solution
        *   The performance is not good, and memory allocation is bad too
        *   the basic idea is find the median of two array, and keep two sides of both array
        *   balanced
        *   The problem is that the boundary case is so many .................
        *   
        *
        * -------------------------Overview-------------------------------------
        *    RunTime: 8ms
        *    Memroy: 51.5MB
        */
        
        // first boundary case, when one or both array is zero
        if(nums1.length == 0 || nums2.length == 0){
            int[] res = nums1.length == 0? nums2:nums1;
            
            if(res.length == 0){
                return 0;
            }else{
                if(res.length % 2 == 0){
                    int mid = res.length/2;
                    return (res[mid - 1] + res[mid])/2.;
                }else{
                    return res[res.length/2];
                }
            }
        }
        
        // Make sure the long and short array
        int[] arrL = new int[0];
        int[] arrS = new int[0];
        if(nums1.length > nums2.length){
            arrL = nums1;
            arrS = nums2;
        }else{
            arrL = nums2;
            arrS = nums1;
        }
        
        
        boolean isEvenL = (arrL.length % 2 == 0);
        boolean isEvenS = (arrS.length % 2 == 0);
        
        if(!(isEvenL || isEvenS)){
            return oddPlusOdd(arrL,arrS);
        }
        
        int cutL = arrL.length/2;
        int cutS = arrS.length/2;
        
        boolean stop = false;
        boolean leftReduce = false;
        boolean started = false;
        while(!stop){
            if(isEvenS){
                if(cutS == 0 || cutS == arrS.length){
                    break;
                }
            }else{
                if(cutS == 0 || cutS == arrS.length-1){
                    break;
                }
                
            }
            
            int rightS = arrS[cutS];
            int rightL = arrL[cutL];
            int leftS = isEvenS?arrS[cutS - 1]:rightS;
            int leftL = isEvenL?arrL[cutL - 1]:rightL;
            
            
            if(leftL > rightS){
                if(started && leftReduce){
                    break;
                }
                
                -- cutL;
                ++ cutS;
                started = true;
                leftReduce = false;
            }else if(leftS > rightL){
                if(started && !leftReduce){
                    break;
                }
                
                ++ cutL;
                -- cutS;
                started = true;
                leftReduce = true;
            }else{
                break;
            }
            
            
        }
        
        
        
        
        if(isEvenS){ 
            if(cutS == 0 || cutS == arrS.length){
                if(arrS.length == arrL.length){
                    return (cutS == 0) ?
                        (arrS[cutS]+arrL[cutL-1])/2.:
                        (arrL[cutL]+arrS[cutS-1])/2.;
                    }
                if(!isEvenL){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    if(cutS == 0){
                        list.add(arrS[cutS]);
                        list.add(arrL[cutL]);
                        list.add(arrL[cutL-1]);
                    }else{
                        list.add(arrS[cutS-1]);
                        list.add(arrL[cutL]);
                        list.add(arrL[cutL+1]);
                    }
                    
                    Collections.sort(list);
                    return list.get(1);
                }else{
                    return (cutS == 0)?
                            (arrL[cutL - 1] +
                                (arrL[cutL] < arrS[cutS]?
                                    arrL[cutL]:arrS[cutS]))/2.
                            :(arrL[cutL]+
                                (arrL[cutL -1] > arrS[cutS-1]?
                                    arrL[cutL -1]:arrS[cutS-1]))/2.;
                }
            }else{
                if(isEvenL){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(arrS[cutS -1]);
                    list.add(arrS[cutS]);
                    list.add(arrL[cutL - 1]);
                    list.add(arrL[cutL]);
                    Collections.sort(list);
                    return (list.get(1)+list.get(2))/2.;
                }else{
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(arrS[cutS -1]);
                    list.add(arrS[cutS]);
                    list.add(arrL[cutL]);
                    Collections.sort(list);
                    return list.get(1);
                }
            }
        }else{
            if(cutS < 0 || cutS == arrS.length){
                return cutS < 0 ? arrL[cutL - 1]:arrL[cutL];
            }
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(arrL[cutL -1]);
            list.add(arrL[cutL]);
            list.add(arrS[cutS]);
            Collections.sort(list);
            return list.get(1);
        }
        
    }
    
    
    
    private double oddPlusOdd(int[] arrL, int[] arrS){
        int cutL = arrL.length / 2;
        int cutS = arrS.length / 2;
        boolean started = false;
        boolean leftCutS = false;
        while(cutS > 0 && cutS < arrS.length - 1){
            if(cutL > 0){
                if(arrL[cutL - 1] > arrS[cutS] ){
                    if(started && leftCutS){
                        break;
                    }
                    ++cutS;
                    --cutL;
                    leftCutS = false;
                    started = true;
                    continue;
                }   
            }
            if(cutL + 1< arrL.length){
                if(started && !leftCutS){
                    break;
                }
                if(arrL[cutL+1] < arrS[cutS]){
                    --cutS;
                    ++cutL;
                    leftCutS = true; 
                    started = true;
                    continue;
                }
            }
            if(cutS > 0){
                
                if(started && !leftCutS){
                    break;
                }
               if(arrS[cutS - 1] > arrL[cutL]){
                   ++cutL;
                   --cutS;
                   leftCutS = true;
                   started = true;
                   continue;
               } 
            }
            if(cutS+1 < arrS.length){
                if(started && leftCutS){
                        break;
                    }
                if(arrS[cutS+1] < arrL[cutL]){
                    --cutL;
                    ++cutS;
                    leftCutS = false;
                    started = true;
                    continue;
                }
            }
            break;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int left = 0;
        int right = 0;
        list.add(arrS[cutS]);
        list.add(arrL[cutL]);
        if(cutS > 0){
            list.add(arrS[cutS -1]);
            ++ left;
        }
        if(cutS < (arrS.length - 1)){
            list.add(arrS[cutS + 1]);
            ++ right;
        }
        if(cutL > 0){
            list.add(arrL[cutL -1]);
            ++ left;
        }
        if(cutL < (arrL.length - 1)){
            list.add(arrL[cutL + 1]);
            ++ right;
        }
        
        if(left < right){
            list.add(arrL[cutL - 2]);
        }
        if(left > right){
            list.add(arrL[cutL + 2]);
        }
        int mid = list.size()/2;
        Collections.sort(list);
        return list.size() % 2 == 0?
            (list.get(mid -1) + list.get(mid))/2.
            :list.get(mid);
    }
    
    
}