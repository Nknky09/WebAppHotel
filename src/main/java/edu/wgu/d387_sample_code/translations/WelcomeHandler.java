package edu.wgu.d387_sample_code.translations;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WelcomeHandler {
    private static final ExecutorService messageExecutor = Executors.newFixedThreadPool(2);

    public static String[] handleMessages() {
        String[] messages = new String[2];
        CountDownLatch latch = new CountDownLatch(2);

        messageExecutor.execute(() -> {
            try {
                ResourceBundle bundle = ResourceBundle.getBundle("welcome", Locale.US);
                messages[0] = bundle.getString("welcome");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        messageExecutor.execute(() -> {
            try {
                ResourceBundle bundle = ResourceBundle.getBundle("welcome", Locale.CANADA_FRENCH);
                messages[1] = bundle.getString("welcome");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        try {
            latch.await(); // Wait for both tasks to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return messages;
    }
}
