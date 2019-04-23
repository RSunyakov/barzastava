public class AudioTrack implements Comparable<AudioTrack> {
    private int duration;
    private String title;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String author;

    @Override
    public int compareTo(AudioTrack o) {
        int d = duration - o.duration;
        if (d !=0) {
            return d;
        } else {
            return title.compareTo(o.title);
        }
        /*if (duration > o.duration) {
           return 1;
        } if (duration < o.duration) {
            return -1;
        }
        if (duration == o.duration) {
            return 0;
        }*/
    }
}
