// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;
// CLASS BEGINS, THIS CLASS IS REQUIRED
class PopularFeatures
{
    public static void main(String[] args) {

    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests)
    {
        // WRITE YOUR CODE HERE
        ArrayList<String> res = new ArrayList<>();
        if (possibleFeatures == null || possibleFeatures.size() == 0 || featureRequests == null || featureRequests.size() == 0 || topFeatures < 0 || numFeatureRequests < 0 || numFeatures < 0) return res;

        Set<String> set = new HashSet<>();
        for (String s : possibleFeatures) {
            s = s.toLowerCase();
            set.add(s);
        }
        Map<String, Integer> map = new HashMap<>();
        for (String featureRequest : featureRequests) {
            for (String possibleFeature : set) {
                if (isPossible(featureRequest, possibleFeature)) {
                    map.put(possibleFeature, map.getOrDefault(possibleFeature, 0) + 1);
                }
            }
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if (map.get(a) == map.get(b)) return b.compareTo(a);
            else return map.get(a) - map.get(b);
        });

        for (String s : map.keySet()) {
            minHeap.offer(s);
            if (minHeap.size() > topFeatures) minHeap.poll();
        }

        while (!minHeap.isEmpty()) res.add(0, minHeap.poll());

        return res;
    }

    private boolean isPossible(String featureRequest, String possibleFeature) {

        String[] arr = featureRequest.split(" ");
        for (String s : arr) {
            s = s.toLowerCase();
            if (s.equals(possibleFeature)) {
                return true;
            }
        }
        return false;
    }
    // METHOD SIGNATURE ENDS
}


/*

Use hashset to store the possible eature. use hasmap to store the count of possible feature. to get the topfeature here we use a size of topfeature minheap to keep the topfeature item 
if the count in the map is same we use string's compareTo method.


Time O(possibleFeatures * times) + O(FeatureRequirestSize * MaxLength of sentence) + O(possibleFeature * log(topFeature)) + O(topFeature * logTopFeature)
Space : O(possibleFeature + topFeature)
*/

/*
*
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;
// CLASS BEGINS, THIS CLASS IS REQUIRED
class Solution
{
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

        // save all toys into set avoid duplicate name influence result
        Set<String> set = new HashSet<>();
        for (String s : toys) {
            s = s.toLowerCase();
            set.add(s);
        }

        // use map to count the frequence of each toy in quotes.
        // key is the toy, value is the occurence frequence
        Map<String, Integer> map = new HashMap<>();
        for (String quote : quotes) {
            for (String toy : set) {
                if (helper(quote, toy)) {
                    map.put(toy, map.getOrDefault(toy, 0) + 1);
                }
            }
        }

        // use minHeap to reorder toy based on occurence frequence and get topToys
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
}*
*
*
*
*
* */