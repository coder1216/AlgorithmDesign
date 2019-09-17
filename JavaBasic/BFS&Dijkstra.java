/*
1, define the cost
2, start status  -> state
3, expand / generate rule -> convert
4, terminate
5, duplicate


Fidn two strings from dictonary, without common character, with the max product of length
dictonary -> input big

w1, abbbhcdef
w2, hijjkk


for every possible w1{
    for every possible w2{
        if(无重复) max = Math.max(max, w1.length() * w2.length());
    }
}

s2, 虽然没节省时间复杂度，但是效率更高。因为计算乘积可以在O(1)时间做到，判重则需要在On时间，所以先计算乘积，如果乘积小于max，则不需要进行判重，直接舍去即可


for every possible w1{
    for every possible w2{
        if(w1.length() * w2.length() <= max) contine;
        if(无重复) max = w1.length() * w2.length();
       // if(无重复) max = Math.max(max, w1.length() * w2.length());
    }
}

Time O(n^2 * k1 * k2)  -> O(n^2 * (k1 + k2))


S2,
sory by length in descending order  -> result[]  10, 8, 5, 2, 1





*/