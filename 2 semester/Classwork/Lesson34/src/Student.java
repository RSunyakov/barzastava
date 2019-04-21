public class Student {
    private int age;
   public String name;
   private int countOfDopkas;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void passExam(String exam) {
        System.out.println(exam + " сдал");
        System.out.println("Кстати меня зовут" + name);
    }

    private void passExam(String exam, int countOfTry) {
        System.out.println(exam + "сдал с " + countOfTry + " раза");
    }

    private void passExam(String exam, Integer mark) {
        System.out.println(exam + " sdal, получил " + mark);
    }


    public Student(String name) {
        this.name = name;
    }

    public Student(int age, String name, int countOfDopkas) {
        this.age = age;
        this.name = name;
        this.countOfDopkas = countOfDopkas;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", countOfDopkas=" + countOfDopkas +
                '}';
    }

}
