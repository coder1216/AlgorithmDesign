/*
preorder
like DFS

inorder
N/A

postorder
do sth then recursion

Deep Copy Tree

Deep Copy Graph vs Tree(1 cycle 2 directed 3 connected 4 DAG)

class GraphNode{
    int val;
    List<GraphNode> neis;
    List<Pair> vs HashMap<Graph, Weight>
}
Pair{

}

Use hashMap to de duplicate
HashMap 
key = reference value new node reference
1 do not visit the node we already copied
2 for new pointer, check if we already have the reference in the hashmap

S1, DFS (矮胖的时候用) recursion + hashmap
error: stack overflow

S2, BFS (瘦高的时候用) graph + queue + hashmap
error: out of memory

 
*/ 