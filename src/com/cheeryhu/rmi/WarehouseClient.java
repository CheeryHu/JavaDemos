package com.cheeryhu.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class WarehouseClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        System.out.println("RMI registry binding:");
        String url = "rmi://localhost:1099/central_warehoues";
        Warehouse house = (Warehouse) Naming.lookup(url);
        String desc = "mate7";
        double price = house.getPrice(desc);
        System.out.println(desc + ":" + price);
    }
}
