import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortedStudentGroupV2 {
    private List<Student> ls;
    private Comparator<Student> comparator;

    public SortedStudentGroupV2() {
        this.ls = new ArrayList<>();
    }

    public SortedStudentGroupV2(Comparator<Student> comparator) {
        this.ls = new ArrayList<>();
        this.comparator = comparator;
    }

    public void add(Student student) {
        ls.add(student);
        ls.sort(comparator);
    }
}
