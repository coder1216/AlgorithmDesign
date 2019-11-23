
// dfs
// V+E
class V{
    int id;
    List<V> nexts;
    Status status;
    private enum Status{
        INITIAL,
        VISITING,
        VISITED;
    } 
}

boolean hasCycle(V curr){
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
    curr.status = Status.VISITED;
    res.add(0, curr.val);
    return false;
}

// bfs

// class V{
//     int id;
//     List<V> nexts;
//     Status status;
//     private enum Status{
//         INITIAL;
//         VISITING;
//         VISITED;
//     }
// }

// boolean hasCycle(V curr){
//     if(curr.status == status.VISITING){
//         return true;
//     }
//     if(curr.status == status.VISITED){
//         return false;
//     }

//     curr.status = Status.VISITING;
//     for(V next : nexts){
//         if(hasCysle(next)){
//             return true;
//         }
//     }
//     curr.status = Status.VISITED;
//     res.add(0, curr.val);
//     return false;
// }
