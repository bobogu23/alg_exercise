package com.alg.exercise.new20231215hot100.repeat;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: gu
 * @Date: 2023/12/23 下午2:05
 */
public class SpiralOrder_11 {

    public static void main(String[] args) {
        int[][] arr ={{2,5,8},{4,0,-1}};
        SpiralOrder_11 s = new SpiralOrder_11();
        List<Integer> res = s.spiralOrder(arr);

    }

    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int l_min = 0 , r_max = n - 1,down_max = m -1,up_max = 0;
        List<Integer> res = new ArrayList<>();
        while(true){
            //从左往右，缩小上界
            for(int col = l_min ;col<= r_max;col++){
                res.add(matrix[up_max][col]);
            }
            up_max++;
            if(up_max > down_max){ //上界超过下届
                break;
            }

            //从上往下，缩小右边界
            for(int row = up_max ;row <= down_max;row++){
                res.add(matrix[row][r_max]);
            }
            r_max--;
            if(r_max < l_min){ //右边界超过左边界
                break;
            }

            //从右往左，缩小下边界
            for(int col = r_max ;col >= l_min;col--){
                res.add(matrix[down_max][col]);
            }
            down_max--;
            if(down_max < up_max){
                break;
            }

            //从下往上，缩小左边界
            for(int row = down_max ;row >= up_max;row--){
                res.add(matrix[row][l_min]);
            }
            l_min++;
            if(l_min > r_max){
                break;
            }
        }
        return res;

    }


}
