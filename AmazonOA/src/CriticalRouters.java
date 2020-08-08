import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class CriticalRouters {
    public static void main(String[] args) {
        System.out.println("success!");
    }

    // IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
    // CLASS BEGINS, THIS CLASS IS REQUIRED
    public class Solution
    {
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        private List<Integer> res;
        private Set<Integer> visited;
        private Map<Integer, Integer> rankings;
        private int ranking;
        private Set<Integer> set;
        List<Integer> criticalRouters(int numRouters, int numLinks,
                                      ArrayList<ArrayList<Integer>> links)
        {
            // WRITE YOUR CODE HERE
            // Corner case.
            if(numRouters == 0 || numLinks == 0 || links == null ||
                    links.size() == 0 || links.get(0) == null || links.get(0).size() == 0){
                return new ArrayList<>();
            }
            if(numLinks < numRouters - 1) return new ArrayList<>();
            int n = numRouters;
            // Construct the graph.
            Map<Integer, List<Integer>> graph = new HashMap<>();
            int minId = Integer.MAX_VALUE;
            for(List<Integer> link : links){
                minId = Math.min( Math.min( link.get(0), link.get(1) ), minId );
                if(!graph.containsKey(link.get(0))){
                    graph.put(link.get(0), new ArrayList<>());
                }
                if(!graph.containsKey(link.get(1))){
                    graph.put(link.get(1), new ArrayList<>());

                }
                graph.get(link.get(0)).add(link.get(1));
                graph.get(link.get(1)).add(link.get(0));

            }
            res = new ArrayList<>();
            set = new HashSet<>();
            visited = new HashSet<>();
            rankings = new HashMap<>();
            int preNode = minId;
            int curNode = minId;
            ranking = 0;
            dfs(graph, preNode, curNode, ranking);
            // Get non-critical routers.
            for(int i : set){
                res.add(i);
            }
            return res;
        }
        private void dfs(Map<Integer, List<Integer>> graph, int preNode, int curNode, int ranking){
            // Ranking of first node is 1.
            ranking ++;
            rankings.put(curNode, ranking);
            visited.add(curNode);
            int tempRanking = rankings.get(curNode);
            for(int nextNode : graph.get(curNode)){
                if(nextNode == preNode) continue;
                // Do dfs on neighbors never been visited before.
                if(!visited.contains(nextNode)){
                    dfs(graph, curNode, nextNode, ranking);
                }
                // Update the ranking of curNode.
                int newRanking = Math.min(rankings.get(curNode), rankings.get(nextNode));
                rankings.put(curNode, newRanking);
                // Critical edges found.
                if(tempRanking < rankings.get(nextNode)){
                    if(graph.get(curNode).size() > 1){
                        set.add(curNode);
                    }
                    if(graph.get(nextNode).size() > 1){
                        set.add(nextNode);
                    }
                }
            }
        }
        // METHOD SIGNATURE ENDS
    }

/*
    time complexity:
        1. Build graph:  O(size of links) which is O(E), suppose E is the total number of edges in graph.
        2. Depth first search on graph we built: O(E) since we need to go through every edge in our graph, and the number of
           edges can be O(V^2).
        Hence the total time complexoty is O(E*E).
    space complexity:
        res : O(V), where V is number of vertice.
        visited : O(V).
        rankings : O(V).
        set : O(V).
        graph : O(E), where E is the number of edges.

    solution:
        We can suppose that routers are vertice on a graph, and the links are the edges of the graph.
        Hence we can build a graph by using HashMap based on the input links.

        The next step is to find out the "Critical Edges" in our graph. To do so, we can do depth first search on our graph
        and give each vertex a ranking, which represents the order we meet the vertex during our dfs. We alse need to know
        whether the vertex is touched before during our dfs, hence we need a HashSet visited to do it. Let's say we are in
        one curNode of the graph,
        we need to go through all of it's neighbors, if the neighbor is touched before, we compare
        the ranking of it to curNode's ranking. If not, we do dfs on this neighbor. No matter which case happened, we update
        curNode's ranking to the minimum one based on it's neighbors. If a neighbor's ranking is even larger than the initial
        ranking of curNode(before we update it), we can say there is a critical edge between this neighbor and curNode. CurNode
        and neighbor are two "critical routers". We also need to pay attention that even a node is on a critical edge, if it has
        only one neighbor, we can say it is still a non-critical routers.
        By doing so, we can find all critical routers.
*/

}
