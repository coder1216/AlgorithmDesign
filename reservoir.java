/**
 * 
 * Q5.1 solution for unlimited data streaming with k/n
streaming flow = [ ………]
List<Integer> checktargets = [0...99];
int i = 100;
while (i++) {
	int rand = random(i);
	if ( rand < 100 ) {
		checktargets[rand] = flow[i-1];
	}
	// if need, print checktarget[]; 
}
https://en.wikipedia.org/wiki/Reservoir_sampling
Reservoir sampling is a family of randomized algorithms for randomly choosing a sample of k items from a list S containing n items, where n is either a very large or unknown number. Typically n is large enough that the list doesn't fit into main memory.


 */