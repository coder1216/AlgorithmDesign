import java.util.*;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class OrderedJunctionBoxes
{
    public static void main(String[] args) {

    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<String> orderedJunctionBoxes(int numberOfBoxes, List<String> boxList)
    {
        // WRITE YOUR CODE HERE
        if (boxList == null || boxList.size() == 0) return new ArrayList<>();
        Collections.sort(boxList, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return boxList;

    }
    // METHOD SIGNATURE ENDS
}

//nlgn

// To solve the problem, we modify the Collections.sort algorithm.
// fitst of all, we seperate the string into two part, and we compare the begining of seconde part.
// If the start of the second part is digit, then, we keep its orginal order.
// If the start of the seconde part is not digit, then, we sort it by Alphabet order.

