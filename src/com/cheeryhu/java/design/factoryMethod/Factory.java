package com.cheeryhu.java.design.factoryMethod;

public abstract class Factory {
    abstract public Product factoryMethod();
    public void doSomething(){
        Product product = factoryMethod();
        // doSomething with the product
    }
}
