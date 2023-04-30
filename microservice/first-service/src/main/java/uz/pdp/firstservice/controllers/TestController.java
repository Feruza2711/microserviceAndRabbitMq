package uz.pdp.firstservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.firstservice.openfeign.FeignWithSecondService;
import uz.pdp.firstservice.payload.TestDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/first")
@RequiredArgsConstructor
public class TestController {

    private final FeignWithSecondService feign;

    @GetMapping
    public String firstService(){
        return "This is first micro service";
    }


    @GetMapping("/test")
    public List<String> fetchingDataFromSecondService(){
        List<String> data = feign.dataFromSecondService();
        data.add(firstService());
        return data;
    }


    @GetMapping("/json")
    public TestDTO jsonlik(){
        TestDTO testDTO = new TestDTO();
        List<String> data = new ArrayList<>();
        data.add("Tesha");
        data.add("BOLTA");
        data.add("KETMON");
        testDTO.setData(data);
        return testDTO;
    }
}
