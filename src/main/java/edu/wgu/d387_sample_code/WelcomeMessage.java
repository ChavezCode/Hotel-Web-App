package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

import java.util.Properties;

public class WelcomeMessage extends Thread {

    //returns welcome message, STORE THIS TO CALL AS THREAD
    public String getWelcomeMessage() {
        Properties prop = new Properties();
        try {
            InputStream streamFr = new ClassPathResource("translation_fr_CA.properties").getInputStream();
            prop.load(streamFr);
            return prop.getProperty("welcome");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//thread below that prints welcome message
    @Override
    public void run() {

        Properties properties = new Properties();
        try {
            Thread.sleep(1000);
            InputStream streamFr = new ClassPathResource("translation_fr_CA.properties").getInputStream();
            properties.load(streamFr);
            System.out.println(properties.getProperty("welcome"));

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream streamEn = new ClassPathResource("translation_en_US.properties").getInputStream();
            properties.load(streamEn);
            System.out.println(properties.getProperty("welcome"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
