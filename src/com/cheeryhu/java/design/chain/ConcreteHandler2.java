package com.cheeryhu.java.design.chain;

public class ConcreteHandler2 extends Handler{

    public ConcreteHandler2(Handler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if(request.getType() == RequestType.type2){
            System.out.println(request.getName());
            return;
        }
        if(successor != null){
            successor.handleRequest(request);
        }
    }
}
