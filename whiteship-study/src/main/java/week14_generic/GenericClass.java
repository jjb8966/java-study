package week14_generic;

import java.util.ArrayList;
import java.util.List;

public class GenericClass<T> {

    private List<T> values = new ArrayList<>();

    public void simpleMethod(T param) {
        values.add(param);
    }

    public T useClassTypeParameter(T param) {
        return param;
    }

    public <E> E useMethodTypeParameter(E param1, T param2) {
        return param1;
    }
}
