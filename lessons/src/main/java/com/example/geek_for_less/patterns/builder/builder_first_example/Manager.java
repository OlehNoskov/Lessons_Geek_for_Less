package com.example.geek_for_less.patterns.builder.builder_first_example;

import com.example.geek_for_less.patterns.builder.builder_first_example.builders.Builder;

public class Manager {

    public void constructorAutoBuild(Builder builder){
        builder.setId(1);
        builder.setType("Constructor Auto Build!");
    }

    public void constructorManualBuild(Builder builder){
        builder.setId(2);
        builder.setType("Constructor Manual Build!");
    }

    public void constructorOtherBuild(Builder builder){
        builder.setId(3);
        builder.setType("Constructor Other Build!");
    }
}