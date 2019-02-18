import java.util.Comparator;

public class ByUniversityComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getUniversity().compareTo(o2.getUniversity());
    }
}
