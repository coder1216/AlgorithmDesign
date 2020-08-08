package YouTuBe;

import java.util.HashSet;

public class Video {
    private Integer id;
    private User createdBy;
    private String path;
    private VideoStatus videoStatus;
    private VideoContentStatus videoContentStatus;
    private int viewsCount;

    private HashSet<Integer> userLikes;
    private HashSet<Integer> userDisLikes;
    private HashSet<Integer> userComments;
}
