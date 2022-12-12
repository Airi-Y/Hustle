package Remote;

import java.rmi.Naming;

// this is the client
public class SayHelloTest {
    public static void main(String[] args) {
        try {
            HelloRemote service = (HelloRemote) Naming.lookup("rmi://127.0.0.1:1888/hello"); //
            String sayHello = service.sayHello();

            System.out.println(sayHello);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
















//try {
//        HelloRemote service = (HelloRemote) Naming.lookup("rmi://127.0.0.1:1888/hello"); // cast
//        String helloStr = service.sayHello();
//
//        System.out.println(helloStr);
//
//        } catch (Exception e) {
//        e.printStackTrace();
//        }
