package Remote;

import java.rmi.*;

// step 1 - create a remote interface
public interface HelloRemote extends Remote {
    String sayHello() throws RemoteException;
}

