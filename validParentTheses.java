/*
valid permutation of n pairs()
n paris -> 2n 个
说明( < n  -> ) < n(小于左括号数量)

valid permutation of n pairs(), m pairs[], p pairs{}


valid xml / html
palindrome break

Given a string containing, just the characters (), {}, [], determine if the input string is valid
The buckets must close in the correct order, (), and ()[]{} are all valid but (] and ([)] are not

((())) is oaky


S1,
one pass with number of () and then check
1,left_so_far >= right_so_far
2,left_so_far == right_so_far

s2,
stack
case1, if ([{, push into stack
    else if stack top matcjed -> pop
    else not matched -> return false
*/