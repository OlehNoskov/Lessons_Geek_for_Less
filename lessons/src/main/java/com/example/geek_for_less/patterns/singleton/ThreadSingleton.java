package com.example.geek_for_less.patterns.singleton;

public final class ThreadSingleton {
    // Поле обязательно должно быть объявлено volatile, чтобы двойная проверка
    // блокировки сработала как надо.
    private static volatile ThreadSingleton instance;

    public String value;

    private ThreadSingleton(String value) {
        this.value = value;
    }

    public static ThreadSingleton getInstance(String value) {
        // Техника, которую мы здесь применяем называется «блокировка с двойной
        // проверкой» (Double-Checked Locking). Она применяется, чтобы
        // предотвратить создание нескольких объектов-одиночек, если метод будет
        // вызван из нескольких потоков одновременно.
        //
        // Хотя переменная `result` вполне оправданно кажется здесь лишней, она
        // помогает избежать подводных камней реализации DCL в Java.
        ThreadSingleton result = instance;
        if (result != null) {
            return result;
        }
        synchronized(ThreadSingleton.class) {
            if (instance == null) {
                instance = new ThreadSingleton(value);
            }
            return instance;
        }
    }
}
