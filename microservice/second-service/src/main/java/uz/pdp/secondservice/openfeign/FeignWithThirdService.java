package uz.pdp.secondservice.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name = "THIRD-SERVICE")
public interface FeignWithThirdService {

    @GetMapping("/api/v1/third/test")
    List<String> dataFromThirdService();
}
