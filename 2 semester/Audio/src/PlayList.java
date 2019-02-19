import java.util.Comparator;

public class PlayList {
   private Comparator<AudioTrack> comparator;
   private AudioTrack[] listOfTracks;
   private int n = 0;

    public PlayList(int size) {
        this.listOfTracks = new AudioTrack[size];
    }

    public PlayList(int size, Comparator<AudioTrack> comparator) {
        this(size);
        this.comparator = comparator;
    }

    public void add(AudioTrack track) {
        int c = 0;
        if (comparator == null) {
            while (c < n && listOfTracks[c].compareTo(track) < 0) {
                c++;
            }
        } else {
            while (c < n && comparator.compare(listOfTracks[c], track) < 0) {
                c++;
            }
        }
        for (int i = n - 1; i >= c; i--) {
            listOfTracks[i + 1] = listOfTracks[i];
        }
        listOfTracks[c] = track;
        n++;
    }
}
