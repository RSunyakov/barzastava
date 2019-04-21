import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

public class MainFramework {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        List<Student> lis1 = Framework.getMany(Student.class, 10, 10, "Вася", 10);
        Arrays.stream(lis1.toArray()).forEach(s -> System.out.println(s));
        }
    }
