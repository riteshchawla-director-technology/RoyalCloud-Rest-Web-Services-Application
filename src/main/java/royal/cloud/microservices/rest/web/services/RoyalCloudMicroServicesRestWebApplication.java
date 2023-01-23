package royal.cloud.microservices.rest.web.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import royal.cloud.core.apis.codebases.RoyalCloudCommonHelper;
import royal.cloud.core.apis.codebases.responses.RoyalCloudResponseEntity;
import royal.cloud.core.apis.codebases.responses.RoyalCloudRestResponseDTO;

@SpringBootApplication
@ComponentScan(basePackages = "loyal.mirror.microservices.rest.web.services.*")
public class RoyalCloudMicroServicesRestWebApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RoyalCloudMicroServicesRestWebApplication.class, args);
    }

    @Controller
    public static class LoyalMirrorGenericController {

        public static Gson gson = new GsonBuilder().create();

        public static String sampleJsonString = "{\n \"stringAsKey\" : \"stringAsValue\" \n}";

        public static String sampleJsonLong = "{\n \"stringAsKey\" : 78901 \n}";

        public static String sampleJsonBoolean = "{\n \"stringAsKey\" : true \n}";

        @GetMapping("/string")
        @ResponseBody
        public String handlerString() {
            return sampleJsonString;
        }

        @GetMapping("/boolean")
        @ResponseBody
        public String handleBoolean() {
            return sampleJsonBoolean;
        }

        @GetMapping("/long")
        @ResponseBody
        public String handlerLong() {
            return sampleJsonLong;
        }

        @GetMapping("/cloud")
        @ResponseBody
        public String handler() {
            return RoyalCloudCommonHelper.getInstance().getJsonStringFromObject(getSampleRestResponseDTO());
        }

        public static RoyalCloudRestResponseDTO getSampleRestResponseDTO() {
            RoyalCloudRestResponseDTO<RoyalCloudResponseEntity, String> responseDTO = new RoyalCloudRestResponseDTO(RoyalCloudResponseEntity.class);
            return responseDTO;
        }
    }
}