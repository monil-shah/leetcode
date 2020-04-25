/*Rotate Image

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
*/



class Solution {
    public void rotate(int[][] matrix) {
        int col_length = matrix.length;
        int row_length = matrix[0].length;
        for(int row=0;row<col_length;row++){
            for(int col=row+1;col<row_length;col++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
            reverse(matrix[row],row_length);
        }
    }
    public void reverse(int[] row,int row_length){
        int low = 0;
        int high = row_length-1;
        while(low<high){
            int temp = row[low];
            row[low] = row[high];
            row[high] = temp;
            low++;
            high--;
        }
    }
}

// Time: O(n^2)  Space: O(1)