package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

import java.util.Properties;

public class MultiThread extends Thread {

    @Override
    public void run() {

        Properties properties = new Properties();
        try {
            Thread.sleep(1000);
            InputStream streamFr = new ClassPathResource("translation_fr_CA.properties").getInputStream();
            properties.load(streamFr);
            System.out.println(properties.getProperty("welcome"));
            InputStream streamEn = new ClassPathResource("translation_en_US.properties").getInputStream();
            properties.load(streamEn);
            System.out.println(properties.getProperty("welcome"));

        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }
}
