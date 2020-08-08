// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class LengthEachScene
{
    public static void main(String[] args) {

    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<Integer> lengthEachScene(List<Character> inputList)
    {
        // WRITE YOUR CODE HERE
        if (inputList == null || inputList.size() == 0) return new ArrayList<>();
        int[] map = new int[26];
        List<Integer> res = new ArrayList<>();

        // save the last occur index for each Character
        for (int i = 0; i < inputList.size(); i++) {
            map[inputList.get(i) - 'a'] = i;
        }

        // save the end index of the current sub String
        int start = 0;
        int end = 0;
        for (int i = 0; i < inputList.size(); i++) {
            end = Math.max(end, map[inputList.get(i) - 'a']);
            if (end == i) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
    // METHOD SIGNATURE ENDS
}

/*
the basic idea is
traverse the string and record the last index of each char.
then, using pointer to record the start and end position of the current sub string. Add the length pointer into result list.

Time: O(inputList.size())
Space: use a size 26 map to save last occur char will occupy O(26) which could be seemed as O(1)
* */