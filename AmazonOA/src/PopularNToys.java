// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;
// CLASS BEGINS, THIS CLASS IS REQUIRED
class PopularNToys
{
    public static void main(String[] args) {

    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> popularNToys(int numToys,
                                          int topToys,
                                          List<String> toys,
                                          int numQuotes,
                                          List<String> quotes)
    {
        // WRITE YOUR CODE HERE
        // corner cases
        if (toys == null || toys.size() == 0 || quotes == null || quotes.size() == 0 || numToys < 0 || topToys < 0 || numQuotes < 0) return new ArrayList<>();

        // initialize output
        ArrayList<String> res = new ArrayList<>();
        // toys : n
        // quotes : m

        // save all toys into set avoid duplicate name influence result
        // time O(n)
        // space O(n)
        Set<String> set = new HashSet<>();
        for (String s : toys) {
            s = s.toLowerCase();
            set.add(s);
        }

        // use map to count the frequency of each toy in quotes.
        // key is the toy, value is the occurrence frequency
        // O(m * n)
        Map<String, Integer> map = new HashMap<>();
        for (String quote : quotes) {
            for (String toy : set) {
                if (helper(quote, toy)) {
                    map.put(toy, map.getOrDefault(toy, 0) + 1);
                }
            }
        }

        // use minHeap to reorder toy based on occurrence frequency and get topToys
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if (map.get(a) == map.get(b)) return b.compareTo(a);
            else return map.get(a) - map.get(b);
        });

        for (String s : map.keySet()) {
            minHeap.offer(s);
            if (minHeap.size() > topToys) minHeap.poll();
        }

        while (!minHeap.isEmpty()) res.add(0, minHeap.poll());

        return res;
    }

    // helper function is used to check if the toy is in quote 
    private boolean helper(String quote, String toy) {
        String[] arr = quote.split("\\s+");
        for (String s : arr) {
            s = s.toLowerCase();
            if (s.equals(toy)) {
                return true;
            }
        }
        return false;
    }
    // METHOD SIGNATURE ENDS
}


/*
the basic idea is
1, use hashset to store all toys, avoid duplicate name influence result.
2, use hashmap to count the occurrence of each toy, key is toy, value is frequency of occurrence
3, use priorityQueue to get top N toys in the quotes based on the frequency of occurrence
4, Add all the top N toys into res list.

Use hashset to store the possible eature. use hasmap to store the count of possible feature.
to get the topfeature here we use a size of topfeature minheap to keep the topfeature item
if the count in the map is same we use string's compareTo method.

O(toys.size() * frequency) + O(quotes.size() * MaxLength of Sentence) + O(toys.size() * log(topToys)) + O(topToys * log(topToys))
Time O(possibleFeatures * times) + O(FeatureRequirestSize * MaxLength of sentence) + O(possibleFeature * log(topFeature)) + O(topFeature * logTopFeature)

O(toys + topToys)
Space : O(possibleFeature + topFeature)
*/
