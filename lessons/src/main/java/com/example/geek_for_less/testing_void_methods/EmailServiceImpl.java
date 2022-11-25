package com.example.geek_for_less.testing_void_methods;

public class EmailServiceImpl implements EmailService {

    // For Service logic
    @Override
    public void sendEmail(String email) {
        sendEmail(email, null, null);
    }

    // For Testing
    public void sendEmail(String email, Runnable callback1, Runnable callback2) {
        if (email.contains("test")) {
            if (callback1 != null) {
                callback1.run();
            }
            return;
        }

        if (email.startsWith("test body")) {
            if (callback2 != null) {
                callback2.run();
            }
            System.out.println(email);
        }
    }
}