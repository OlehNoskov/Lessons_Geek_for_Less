package com.example.geek_for_less.patterns.builder.builder_first_example;

import com.example.geek_for_less.patterns.builder.builder_first_example.builders.AutomationBuilder;
import com.example.geek_for_less.patterns.builder.builder_first_example.builders.ManualBuilder;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        AutomationBuilder automationBuilder = new AutomationBuilder();
        ManualBuilder manualBuilder = new ManualBuilder();

        manager.constructorAutoBuild(automationBuilder);
        BuildMain buildMain1 = automationBuilder.getBuildEngine();

        manager.constructorManualBuild(manualBuilder);
        BuildMain buildMain2 = manualBuilder.getBuildEngine();

        System.out.println("Auto : " + buildMain1);
        System.out.println("Manual : " + buildMain2);

    }
}