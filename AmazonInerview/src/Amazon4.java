import java.util.*;

public class Amazon4 {

    public static void main(String[] args) {
        int[] in = {4, 2, 5, 1, 3, 6};
        int[] pre = {1, 2, 4, 5, 3, 6};

        postOrder(in, pre, 0, in.length - 1);
    }

    public static int preIndex = 0;
    public static void postOrder(int[] in, int[] pre, int inStart, int inEnd) {
        if (in == null || pre == null) return;
        if (inStart > inEnd) return;

        // Find index of next item in preorder traversal in inorder.
        int inIndex = search(in, inStart, inEnd, pre[preIndex++]);

        postOrder (in, pre, inStart, inIndex - 1);
        postOrder (in, pre, inIndex + 1, inEnd);

        System.out.print(in[inIndex++] + " ");
    }

    private static int search(int[] in, int inStart, int inEnd, int data) {
        int index = 0;
        for (index = inStart; index < inEnd; index++) {
            if (in[index] == data) {
                return index;
            }
        }
        return index;
    }
}
