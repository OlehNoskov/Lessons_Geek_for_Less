package com.example.geek_for_less.patterns.builder.builder_first_example;

public class AutomationBuilder implements Builder {
    private int id;
    private String type;

    @Override
    public void setId(int id) {
    this.id = id;
    }

    @Override
    public void setType(String type) {
    this.type = type + " : Automatic build";
    }

    public BuildMain getBuildEngine(){
        return new BuildMain(id, type);
    }
}