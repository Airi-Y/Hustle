import java.lang.reflect.*;

public class EmployeeInvocationHandler implements InvocationHandler {
    Person person;

    public EmployeeInvocationHandler(Person person) {
        this.person = person;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            if(method.getName().startsWith("get"))
                return method.invoke(person, args);
            else if (method.getName().startsWith("set"))
                throw new IllegalAccessException();
            else if (method.getName().startsWith("ask"))
                return method.invoke(person, args);
            else
                throw new IllegalAccessException();

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
