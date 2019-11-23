/**
 * 
 *    x --- a
 *          |
 *          b -- c -- d
 *          |         |
 *          ---- f -- e  
 * 
 *  O(V+E) 有向
 *  O(E) 无向
 */ 

class V{
    int id;
    List<V> nexts;
    Status status;
    private enum Status{
        INITIAL;
        VISITING;
        VISITED;
    } 
}

boolean has Cycle(V curr){
    if(curr.status == status.VISITING){
        return true;
    }
    if(curr.status == status.VISITED){
        return false;
    }
    curr.Status = status.VISITING;
    for(V next : curr.getNexts()){
        if(hasCycle(next)){
            return true;
        }
    }
    curr.status = status.VISITED;
    return false;
}
