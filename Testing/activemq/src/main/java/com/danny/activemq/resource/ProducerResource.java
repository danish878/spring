package com.danny.activemq.resource;

import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@AllArgsConstructor

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

    private JmsTemplate jmsTemplate;
    private Queue queue;

    @GetMapping("/{message}")
    public String publish(@PathVariable("message") final String message) {
        jmsTemplate.convertAndSend(queue, message);
        return "Published Successfully";
    }
}
