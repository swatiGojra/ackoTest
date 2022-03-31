package com.assignment.acko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NotificationManager {

    final String uri = "https://run.mocky.io/v3/fd99c100-f88a-4d70-aaf7-393dbbd5d99f";

    RestTemplate restTemplate = new RestTemplate();

    public String sendAlert(Integer phone) {
        NotificationReq reqBody = new NotificationReq(phone.toString(),
                "Too many 5xx!");
        String result = restTemplate.postForObject(uri, reqBody, String.class);
        return result;
    }

}