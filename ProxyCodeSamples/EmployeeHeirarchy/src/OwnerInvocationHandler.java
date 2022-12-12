import java.lang.reflect.*;
public class OwnerInvocationHandler implements InvocationHandler {
    Person person;

    public OwnerInvocationHandler(Person person) {
        this.person = person;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            if (method.getName().equals("askForRaise"))
                throw new IllegalAccessException();
            else
                return method.invoke(person, args);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
