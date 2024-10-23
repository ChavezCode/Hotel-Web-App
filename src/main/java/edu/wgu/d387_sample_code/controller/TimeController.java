package edu.wgu.d387_sample_code.controller;

import edu.wgu.d387_sample_code.TimeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class TimeController {
    private TimeConversion timeConversion;

    @Autowired
    public TimeController(TimeConversion timeConversion) {
        this.timeConversion = timeConversion;
    }

    @GetMapping("/welcome")
    public List<String> getTime() {
        return timeConversion.getTimeConversion();
    }
}
