package com.cheeryhu.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {

    private Map<String, Double> prices;

    protected WarehouseImpl() throws RemoteException{
        prices = new HashMap<>();
        prices.put("mate7", 3700.00);
    }

    @Override
    public double getPrice(String description) throws RemoteException {
        Double price = prices.get(description);
        return price == null ? 0 : price;
    }
}
