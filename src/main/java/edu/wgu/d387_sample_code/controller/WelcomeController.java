package edu.wgu.d387_sample_code.controller;

import edu.wgu.d387_sample_code.WelcomeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/jorge")
public class WelcomeController {
    private WelcomeMessage welcomeMessage;

    @Autowired
    public WelcomeController(WelcomeMessage welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    @GetMapping
    public List<String> getWelcomeMessage() {
        return welcomeMessage.getWelcomeArray();
    }
}