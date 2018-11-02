package com.cheeryhu.java.design.factoryMethod;

public class ConcreteFactory extends Factory{
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}
