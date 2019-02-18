public class Student implements Comparable<Student> {
    private String name;
    private int id;
    private int group;
    private String university;

    public Student(String name, int id, int group, String university) {
        this.name = name;
        this.id = id;
        this.group = group;
        this.university = university;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public int compareTo(Student o) {
        int tmp = this.getName().compareTo(o.getName());
        if (tmp != 0) {
            return tmp;
        } else {
            return this.getId() - o.getId();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Student)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Student student = (Student) obj;
        return this.getId() == student.getId() && this.getName().equals(student.getName());
    }
}
