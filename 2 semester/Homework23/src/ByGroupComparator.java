import java.util.Comparator;

public class ByGroupComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getGroup() - o2.getGroup();
    }
}
