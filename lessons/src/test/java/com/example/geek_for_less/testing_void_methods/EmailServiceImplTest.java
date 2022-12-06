package com.example.geek_for_less.testing_void_methods;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class EmailServiceImplTest {

    @Test
    public void happyPath() {
        EmailServiceImpl emailService = new EmailServiceImpl();
        Runnable runnable1 = mock(Runnable.class);
        Runnable runnable2 = mock(Runnable.class);
        emailService.sendEmail("test body", runnable1, runnable2);

        verify(runnable1, times(1)).run();
        verify(runnable2, never()).run();
    }
}