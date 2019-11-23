/**
 * 
 */

  public class V{
        int id;
        V parent;
        int size;
        public V(int id){
            this.id = id;
            parent = this; // parent 初始值给自己
            size = 1;
        }
  }

  class UnionFind{
      public UnionFind(){

      }
      public boolean find(V p, V q){ // find if p and q in/under same root
          return root(p) == root(q);
      }
      public void union(V p, V q){ 
          V rootP = root(p);
          V rootQ = root(q);
          if(rootP.size > rootQ.size){ // q -> p
              rootQ.parent = rootP;
              rootP.size += rootQ.size;
          }else{ // p -> q
              rootP.parent = rootQ;
              rootQ.size += rootP.size;
          }
      }
      private V root(V p){ // 压缩路径
          V curr = p;
          while(curr.parent != curr){
                curr.parent  = curr.parent.parent;
                curr = curr.parent;
          }
          p.parent = curr;
          return curr;
      }
  }