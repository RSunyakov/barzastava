import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SortedStudentGroup ssg = new SortedStudentGroup(5, (o1, o2) -> o1.getId() - o2.getId());
        Comparator<Student> comparator1 = (o1,o2) -> o1.getName().compareTo(o2.getName());
        SortedStudentGroup group2 = new SortedStudentGroup(10, comparator1);
        Comparator<Student> comparator2 = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getGroup() - o2.getGroup();
            }
        };
        SortedStudentGroup group3 = new SortedStudentGroup(10, comparator2);
        SortedStudentGroup group4 = new SortedStudentGroup(10, (o1, o2) -> o1.getUniversity().compareTo(o2.getUniversity()));
        SortedStudentGroup group = new SortedStudentGroup(10, ((o1, o2) -> o1.getGroup() - o2.getId()));
        Student stud1 = new Student("Петя", 1, 1, "КФУ" );
        Student stud2 = new Student("Аркадий", 2, 2, "КФУ" );
        Student stud3 = new Student("Геннадий", 3, 3, "КФУ" );
        Student stud4 = new Student("Владимир", 4, 4, "КФУ" );
        ssg.add(stud1);
        ssg.add(stud2);
        ssg.add(stud3);
        ssg.add(stud4);
        for (int i = 0; i < 4; i++) {
            System.out.println(ssg.groupOfStudent[i].toString());
        }
    }
}
