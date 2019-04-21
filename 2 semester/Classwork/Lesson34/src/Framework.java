

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Framework {
    public static <T> List<T> getMany(Class<T> aClass, int count, Object... params) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        List<T> list = new ArrayList<>();
        Constructor[] constructors = aClass.getConstructors();
        String[] typeParams = new String[params.length];
        for (int i = 0; i < params.length; i++) {
            typeParams[i] = params[i].getClass().getSimpleName();
        }
        for (int i = 0; i < typeParams.length; i++) {
            if (typeParams[i].equals("Integer")) {     //Без этого не обойтись, так как в varargs приходит Integer из за того, что он Object, а в исходном конструкторе студента обычный int
                typeParams[i] = "int";
            }
        }
        boolean flag = false;
        for (int j = 0; j < count; j++) {
            for (int i = 0; i < constructors.length; i++) {
               Class[] paramTypesConstructors = constructors[i].getParameterTypes();
                for (int k = 0; k < paramTypesConstructors.length; k++) {
                    if (paramTypesConstructors[k].getSimpleName().equals(typeParams[k])) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                }
                if (flag) {
                    list.add((T) constructors[i].newInstance(params));
                }
            }
        }
        return list;
    }
}



