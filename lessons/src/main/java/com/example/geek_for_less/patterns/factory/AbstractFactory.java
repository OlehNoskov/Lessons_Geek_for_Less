package com.example.geek_for_less.patterns.factory;

public interface AbstractFactory {
    <T> T create(Class<T> clazz);
}