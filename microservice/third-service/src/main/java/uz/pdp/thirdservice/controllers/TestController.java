package uz.pdp.thirdservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/third")
public class TestController {

    @GetMapping("/test")
    public List<String> thirdService(){
        List<String> data = new ArrayList<>();
        data.add("This is third micro service");
        return  data;
    }

}
