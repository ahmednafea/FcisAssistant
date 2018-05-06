package FcisAssistant;

public class Post {
    protected String Poster;
    protected String Gender;
    protected String PostContent;
    protected String PostTime;
    protected int PosterImage;
    public Post(String poster,String post,String gender){
        PostContent=post;
        Poster=poster;
        Gender=gender;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPostContent() {
        return PostContent;
    }

    public void setPostContent(String postContent) {
        PostContent = postContent;
    }

    public String getPostTime() {
        return PostTime;
    }

    public void setPostTime(String postTime) {
        PostTime = postTime;
    }

    public int getPosterImage() {
        return PosterImage;
    }

    public void setPosterImage(int posterImage) {
        PosterImage = posterImage;
    }
}
