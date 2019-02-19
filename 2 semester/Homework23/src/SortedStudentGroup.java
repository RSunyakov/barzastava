import java.util.Comparator;
import java.util.List;

public class SortedStudentGroup {
    public Student[] groupOfStudent;
    private Comparator<Student> comparator;
    int n =0;

    public SortedStudentGroup(int size) {
        this.groupOfStudent = new Student[size];
    }

    public SortedStudentGroup(int size, Comparator<Student> comparator) {
        this(size);
        this.comparator = comparator;
    }

    public void add(Student student) {
   /*     if (comparator == null) {
            for (int i = 0; i < groupOfStudent.length; i++) {
                if (groupOfStudent[i] == null) {
                    groupOfStudent[i] = student;
                }
            }
        } else {
           if (groupOfStudent[0] == null) {
               groupOfStudent[0] = student;
           }
            for (int i = 1; i < groupOfStudent.length; i++) {
                    if (comparator.compare(student, groupOfStudent[i - 1]) < 0) {
                        Student tmp = groupOfStudent[i - 1];
                        groupOfStudent[i - 1] = student;
                        groupOfStudent[i] = tmp;
                        break;
                    }
                    if (comparator.compare(student, groupOfStudent[i - 1]) > 0) {
                        groupOfStudent[i] = student;
                        break;
                    }
                    if (comparator.compare(student, groupOfStudent[i - 1]) == 0) {
                        groupOfStudent[i] = student;
                        break;
                    }
                }
            }*/
        int c = 0;
        if (comparator == null) {
            while (c < n && groupOfStudent[c].compareTo(student) < 0) {
                c++;
            }
        } else {
            while (c < n && comparator.compare(groupOfStudent[c], student) < 0) {
                c++;
            }
        }
        for (int i = n - 1; i >= c; i--) {
            groupOfStudent[i + 1] = groupOfStudent[i];
        }
        groupOfStudent[c] = student;
        n++;
        }
    }
