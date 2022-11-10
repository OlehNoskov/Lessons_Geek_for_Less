package com.example.geek_for_less.patterns.dependency_injection.factory;

public interface AbstractFactory {
    <T> T create(Class<T> clazz);
}
