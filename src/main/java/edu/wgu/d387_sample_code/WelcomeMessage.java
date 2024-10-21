package edu.wgu.d387_sample_code;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import static java.util.concurrent.Executors.newFixedThreadPool;

@Component
public class WelcomeMessage implements Runnable {
    static ExecutorService messageExecutor = newFixedThreadPool(5);

    public List<String> getWelcomeArray() {
        ArrayList<String> welcomeArray = new ArrayList<>(2);
        Properties properties = new Properties();
        CountDownLatch latch = new CountDownLatch(2); // Two properties files

        messageExecutor.execute(() -> {
            try (InputStream streamEn = new ClassPathResource("translation_en_US.properties").getInputStream()) {
                properties.load(streamEn);
                welcomeArray.add(properties.getProperty("welcome"));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown(); // Decrement the count
            }
        });

        messageExecutor.execute(() -> {
            try (InputStream streamFr = new ClassPathResource("translation_fr_CA.properties").getInputStream()) {
                properties.load(streamFr);
                welcomeArray.add(properties.getProperty("welcome"));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown(); // Decrement the count
            }
        });

        try {
            latch.await(); // Wait for both tasks to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
            e.printStackTrace();
        }

        return welcomeArray;
    }

    @Override
    public void run() {
        List<String> welcomeMessages = getWelcomeArray();
        System.out.println(welcomeMessages);
    }
}
