package kmitl.esd.exercise2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import kmitl.esd.exercise2.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
/**
 * client
 */
public class Client {

    private static final Logger log = (Logger) LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Client.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8089"));
        app.run(args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    /**
     * Main entry point for the client
     */
    @Bean
    public CommandLineRunner GetAll(RestTemplate restTemplate) throws Exception {
        return args -> {
            /**
             * get
             */
            String response = callGetAll(restTemplate);
            log.info(String.format("GET call: " + response));
            /**
             * create
             */
            CustomerDTO createCustomer = callCreateCustomer(restTemplate);
            log.info("CREATE: " + createCustomer.toString());
            /**
             * update
             */
            CustomerDTO updateCustomer=callUpdateCustomer(restTemplate);
            log.info("UPDATE: " + updateCustomer.toString());
            /**
             * delete
             */
            ResponseEntity responseEntity =callDeleteCustomer(restTemplate,"0");
            String deleteResponse = callGetAll(restTemplate);
            log.info("DELETE : " +deleteResponse);

        };
    }

    /**
     * get all customers
     * @param restTemplate
     * @return String
     */
    String callGetAll(RestTemplate restTemplate) {
        StringBuffer url = new StringBuffer("http://localhost:8080/customer");
        String respString = restTemplate.getForObject(
                url.toString(), String.class);
        return respString;
    }

    /**
     * Create the customer
     * @param restTemplate
     * @return json
     * @throws JSONException
     */

    CustomerDTO callCreateCustomer(RestTemplate restTemplate) throws JSONException {
        JSONObject customers = new JSONObject();
        customers.put("id",8);
        customers.put("name","customerA");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(customers.toString(), headers);

        ResponseEntity<CustomerDTO> response = restTemplate.exchange("http://localhost:8080/customer", HttpMethod.POST, request, CustomerDTO.class);
        return response.getBody();

    }

    /**
     * Update customer info
     * @param restTemplate
     * @return json
     * @throws JSONException
     */

    CustomerDTO callUpdateCustomer(RestTemplate restTemplate) throws JSONException {
        JSONObject customers = new JSONObject();
        customers.put("id",9);
        customers.put("name","customerB");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(customers.toString(), headers);

        ResponseEntity<CustomerDTO> response = restTemplate.exchange("http://localhost:8000/customer", HttpMethod.PUT, request, CustomerDTO.class);

        return response.getBody();
    }

    /**
     * delete customer
     * @param restTemplate
     * @param customerId
     * @return String
     */

    ResponseEntity<String> callDeleteCustomer(RestTemplate restTemplate, String customerId) {
        ResponseEntity<String> response=restTemplate.exchange("http://localhost:8000/customer/" + customerId,HttpMethod.DELETE,null,String.class);
        return response;
    }




}