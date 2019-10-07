/**
 * 
 * 
 * 
 *              BFS 模板  levelOrderTraverse use queue
 */

 returnType bfs(root){
     new queue;
     queue.offer(root);
     minLen = 0; // 用来求路径长度
     while(!q.isEmpty()){ // 控制level长度
        // 处理当前level
          int size = q.size();
          while(size-- > 0){  // 进行size 次的 while loop
              cur = queue.poll(); // 每次取出当前节点
              next = convert(cur); // 如果是树，next就是左右孩子，如果是图，next就是邻居
              if(condition -> visited?){ // check visited，查环，因为不允许一个节点进去2次
                  q.offer(next);
              }
          } 
          minLen++;
     }

 }

 /**
  
*****************   把二维matrix 的某一个特定坐标i, j放入 一维坐标系  ***********************
matrix[m][n]

可以用 int[i][j]
也可以 int[s],  s = i * n + j

把坐标从1维里取出来， matrix[s] => i = i/n, j = j%n, n为col


  */


  