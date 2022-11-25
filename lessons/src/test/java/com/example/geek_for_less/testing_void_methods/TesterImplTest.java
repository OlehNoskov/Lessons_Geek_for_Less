package com.example.geek_for_less.testing_void_methods;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class TesterImplTest {

    @Test
    public void setupTest(){
        TesterImpl tester = new TesterImpl();
        Runnable runnable = mock(Runnable.class);
        tester.setupTest("test");

        // Check, that method run (Runnable) did not call
        verify(runnable, never()).run();
    }

    @Test
    public void happyPathWithCallbackTest(){
        TesterImpl tester = new TesterImpl();
        Runnable runnable = mock(Runnable.class);
        tester.setupTest("test param", runnable);

        // Check, that method run (Runnable) called one time
        verify(runnable, times(1)).run();
    }
}