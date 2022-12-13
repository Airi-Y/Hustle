package Remote;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

//step 2 - create a remote implementation

// 2.1 implement remote interface
// 2.2 extend UnicastRemoteObject - this gives your class a remote functionality
public class HelloRemoteImpl extends UnicastRemoteObject implements HelloRemote{

    // 2.3 write a no-args constructor that throws RemoteException
    public HelloRemoteImpl() throws RemoteException {};

    @Override
    public String sayHello() throws RemoteException {
        return "Server says, \"Hello!\"";
    }

    // 2.4 register to registry
    public static void main(String[] args) {
        try {
            int PORT = 1888;

            HelloRemote service = new HelloRemoteImpl();
            Registry registry = LocateRegistry.createRegistry(PORT); // register
            registry.rebind("hello", service);
            System.out.println("Service is running...");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
