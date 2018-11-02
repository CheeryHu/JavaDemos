package com.cheeryhu.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class WarehouseServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        System.out.println("Constructing server implementation");
        WarehouseImpl house = new WarehouseImpl();
        System.out.println("Binding server implementation registry");
        LocateRegistry.createRegistry(1099);
        Naming.bind("rmi://localhost:1099/central_warehoues", house);
        System.out.println("Waiting for invocations from clients ...");
    }
}
