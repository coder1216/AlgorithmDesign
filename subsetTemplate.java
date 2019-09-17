/*

2  1  3  2  4  2
2  2  2  1  3  4


a  b1  b2 


S2: DFS
{}
a		             {a}				{}
b1      	{a, b}	      	 {a}	           	{b}		{}
b2    {a, b, b}     {a, b}    {a, b}  {a}	{b, b}  {b}         {b}     {}
b3
c			                    {a,c} {a}	        {b, c}     {c}     {}          skip all b1 b2 b3 b… and
null



*/

// S2, use recursion to loop level
private void dfs(List<String> sol, char[] input, int level){
    if(level == input.length){ // base case
        // print or add sol
        return;
    }
    // case1: add
    // sol.add(input[level]);
    dfs(sol, input, level + 1);
    // sol.remove(input[level]);

    while(level < input.length && input[level] == input[level + 1]) level ++;

    // case2: not add
    dfs(sol, input, level + 1);

} 

/*
另一种搜索树

a b b b c
      level

1 2a 2b 2c
               l

1 	       2a
1 2       2a 2b

            ""
		a	b	b    b	c
	ab   ac   bb   bc        
 abb abc      


*/

private void dfs(List<String> sol, char[] input, int index){
    // add to sol
    for(int i = level; i < input.length; i++){
        if(i > index && input[i-1] == input[i]) continue;
    }
    // sol.add(input[level]);
    dfs(sol, input, index);
    // sol.remove(input[level]);
}
