package com.example.geek_for_less.dependency_injection.factory;

public interface AbstractFactory {
    <T> T create(Class<T> clazz);
}
