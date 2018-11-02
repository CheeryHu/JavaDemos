package com.cheeryhu.java.design.command;

public class Invoker {

    private Command[] onCommands;
    private Command[] offCommands;
    private final int slotNum = 7;

    public Invoker(){
        this.onCommands = new Command[slotNum];
        this.offCommands = new Command[slotNum];
    }

    public void setOnCommands(Command commands, int slot){
        onCommands[slot] = commands;
    }

    public void setOffCommands(Command commands, int slot) {
        offCommands[slot] = commands;
    }

    public void onButtonWasPushed(int slot){
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot){
        offCommands[slot].execute();
    }
}
