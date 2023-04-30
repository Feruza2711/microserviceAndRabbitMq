package uz.pdp.secondservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.secondservice.openfeign.FeignWithThirdService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/second")
@RequiredArgsConstructor
public class TestController {
    private final FeignWithThirdService feignWithThirdService;

    @GetMapping
    public String secondService(){
        return "This is second micro service";
    }


    @GetMapping("/test")
    public List<String> fetchingDataFromThirdService(){
        List<String> data = feignWithThirdService.dataFromThirdService();
        data.add(secondService());
        return data;
    }
}
