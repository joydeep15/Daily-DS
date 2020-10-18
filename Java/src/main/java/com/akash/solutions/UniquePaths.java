package com.akash.solutions;

/*import java.util.HashMap;
import java.util.Map;
import java.util.Objects;*/

/*class _2dArr{
    int i,j;

    public _2dArr(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        _2dArr dArr = (_2dArr) o;
        return i == dArr.i &&
                j == dArr.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}*/

class UniquePaths {
//    public static Map<_2dArr,Integer> lookup = new HashMap<>();
    static int[][] dpState = new int[101][101];
    public static void main(String[] args) {
        int m =3, n=7;
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                dpState[i][j] = -1;
            }
        }
        System.out.println(uniquePaths(m,n));
        System.out.println(countWays(0,0,m,n));
//        System.out.println(recursiveDPCountWays(0,0,m,n));
        System.out.println(arrWay(0,0,m,n));
    }
    //iterative solution (DP)
    public static int uniquePaths(int m, int n) {
        int[][] count = new int[m][n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i == m-1 || j == n-1){
                    count[i][j] = 1;
                } else{
                    count[i][j] = count[i+1][j] + count[i][j+1];
                }
            }
        }
        return count[0][0];
        // return countWays(0,0,m,n);
    }
    // recursive solution
    private static int countWays(int i, int j, int m, int n){
        if(i== m-1 || j== n-1) return 1;
        return countWays(i+1,j,m,n) + countWays(i,j+1,m,n);
    }
    //recursive DP
/*    private static int recursiveDPCountWays(int i, int j, int m, int n){
        if(i== m-1 || j== n-1) return 1;
        _2dArr lookupKey = new _2dArr(i,j);
        if(lookup.containsKey(lookupKey)) return lookup.get(lookupKey);
        Integer ans = recursiveDPCountWays(i+1,j,m,n) + recursiveDPCountWays(i,j+1,m,n);
        lookup.put(lookupKey, ans);
        return lookup.get(lookupKey);
    }*/
    private static int arrWay(int i, int j, int m, int n){
        if(i== m-1 || j== n-1) return 1;
        if(dpState[i][j] != -1) return dpState[i][j];
        return dpState[i][j] = arrWay(i+1,j,m,n) + arrWay(i,j+1,m,n);
    }
}
