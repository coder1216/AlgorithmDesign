/*
devide set with equal sum up
subset II ALL subsequence of sorted string



		' '
			a		b1	b2
		         a b		b b
		      a b b


				                    {}
			                   /		    \
      a		          {a}                         { }
		           /	    \                  /             \
      b1        {a,b1}         {a}	         {b}            {}           n

      b2     {a,b1,b2} {a, b1}   

      b3                

      c			{a, c} {a}

case1: add without any rescrition
case2: not add
Termination level == array.length

{
    // if we decide on all position
    // we have a complete subset, all locate on the leaf node
    if(index == array.length){
        result.add(sb.toString());
        return;
    }
    // case1, add character at index
    sb.append(array[index]);
    helper(array, sb, index + 1, result);

    // wall
    // remove the added character when bactracking to the upper level
    sb.deleteCharAt(sb.length() - 1);
    // remove duplicate
    while(index < input.length() - 1 && input[index] == input[index + 1]) index++;

    // case2. NOT add character at index
    helper(array, sb, index + 1, result);
}

*/


class Solution{
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> res = new ArrayList<>();
        dfs(nums, ans, res, 0);
        return res;
    }
    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> res, int index){
        // 答案都出在叶子节点，所以遍历到叶子节点时，答案全部加进ans
        if(index == nums.length - 1){
            ans.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[index]);
        // 遍历一边
        dfs(nums, ans, res, index + 1);
        // back tracking
        res.remove(res.size()-1);
         // remove duplicate
       // while(index < nums.length() - 1 && nums[index] == nums[index + 1]) index++;
        // 走另一边
        dfs(nums, ans, res, index + 1);

    }
}



/*

class Solution{
    public List<List<Integer>> subset(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if(nums == null) return res;
        dfs(nums, res, ans, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> ans, int index){
        // collect the result from leaf nodes
        if(index == nums.length - 1){
            res.add(new ArrayList<>(ans));
            return;
        }

        ans.add(nums[index]);
        dfs(nums, res, ans, index + 1);
        ans.remove(ans.size() - 1);
        // remove duplicate
       // while(index < input.length() - 1 && input[index] == input[index + 1]) index++;
        dfs(nums, res, ans, index + 1);
    }
}

*/
