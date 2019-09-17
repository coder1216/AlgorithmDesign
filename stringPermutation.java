/*
String Permutation with/ without duplicate

                            {1, 2, 3}
        {1, (2, 3)}        {2, (1, 3)}        {3, (2, 1)}
    {1,2,(3)}  {1,3,(2)}  2,{1,3}  2,{3,1}   3,{2,1}    3,{2,1}
{1, 2, 3}

答案出现在leaf node

*/
// recursion 从上到下， for loop 从左往右
 private void dfs(char[] arr, int index, List<String> result){
     // base case
     if(index = arr.length - 1){
         result.add(new String(array));
         return;
     }
     for(int i = index; i < arr.length; i++){
         swap(arr, index, i);
         dfs(arr, index + 1, result);
         swap(arr, index, i);
     }
 }

 // if input has duplicate element

 private void DFS(char[] input, int level){
     if(level == input.length -1){
         // print
         return;
     }
     for(int i = level; i < input.length; i++){
         // if duplicate(hashset). 跳i -> continue
         swap(input, level, i);
         DFS(input, level+1);
         swap(input, level, i);
     }
 } 