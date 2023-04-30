package uz.pdp.firstservice.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


// @FeignClient(name = "SECOND-SERVICE")   bu ushbu microservicemiz (first-service)  qaysi micro service mizga borishini yozamiz (second-service) dan ma'lumot olmoqchi
// Bundan  @FeignClient(name="service name")  anotatsiyasini name property siga qaysi service ga borib data olmoqchi ekanligini yozamiz. Uni name ni bog'lanmoqchi (data omoqchi) bo'lgan applicationimizni ichidag  application properties (yml) dagi  spring.application.name property value sini qo'yamiz.
// Note Har bir boshqa service dan ma'lumot olish uchun aloxida interface ochib ishlatamiz  hozir 1 service 2 chidan olayapti    agar 1 service 3 dan olmochi bo'lsa yana bitta aloxida interface ochamiz 3 service bilan bog'lanish uchun

@FeignClient(name = "SECOND-SERVICE")
public interface FeignWithSecondService {

    // Bu o'sha bormoqchi bogan micro service ni ichidagi qaysi yo'lga borishi va undan fetch
    // Masalan bitta service mizdan  username va  password bervorsak 2 chi service bizga o'sha userni qaytarishi kerak  uni yo'li masalan  /api/v1/user/get-user api api lar uchun v1 version 1   user bu yerda service nomi
    @GetMapping("/api/v1/second/test")
     List<String> dataFromSecondService();
}
