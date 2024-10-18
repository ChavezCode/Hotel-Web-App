package edu.wgu.d387_sample_code;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class WelcomeMessage implements Runnable {
    static ExecutorService messageExecutor=newFixedThreadPool(5);

    //get welcome messages and store them into string array

    List<String>welcomeArray = new ArrayList<>(4);
    @Override
    public void run() {


        Properties properties=new Properties();
        messageExecutor.execute(()-> {

            try {
                InputStream streamEn = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(streamEn);
                welcomeArray.add(properties.getProperty("welcome"));
                streamEn.close();
                streamEn = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(streamEn);
                welcomeArray.add(properties.getProperty("welcome"));
                streamEn.close();
                InputStream streamFr = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(streamFr);
                welcomeArray.add(properties.getProperty("welcome"));
                streamFr.close();
                streamFr = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(streamFr);
                welcomeArray.add(properties.getProperty("welcome"));
                streamFr.close();
//                System.out.println(properties.getProperty("welcome"));
                return welcomeArray;
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
//        messageExecutor.execute(()-> {
//            try {
//                InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
//                properties.load(stream);
//                welcomeArray.add(properties.getProperty("welcome"));
//                stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
//                properties.load(stream);
//                welcomeArray.add(properties.getProperty("welcome"));
//                System.out.println(welcomeArray);
//
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
    }






}
