import java.util.Comparator;
import java.util.List;

public class SortedStudentGroup {
    public Student[] groupOfStudent;
    private Comparator<Student> comparator;

    public SortedStudentGroup(int size) {
        this.groupOfStudent = new Student[size];
    }

    public SortedStudentGroup(int size, Comparator<Student> comparator) {
        this(size);
        this.comparator = comparator;
    }

    public void add(Student student) {
        if (comparator == null) {
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
                    if (student.compareTo(groupOfStudent[i - 1]) < 0) {
                        Student tmp = groupOfStudent[i - 1];
                        groupOfStudent[i - 1] = student;
                        groupOfStudent[i] = tmp;
                        break;
                    }
                    if (student.compareTo(groupOfStudent[i-1]) > 0) {
                        groupOfStudent[i] = student;
                        break;
                    }
                    if (student.compareTo(groupOfStudent[i - 1]) == 0) {
                        groupOfStudent[i] = student;
                        break;
                    }
                }
            }
        }
    }
