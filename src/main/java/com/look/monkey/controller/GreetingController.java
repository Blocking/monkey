package com.look.monkey.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.look.monkey.bean.Greeting;
import com.look.monkey.bean.HelloMessage;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
    		Thread.sleep(1000); // simulated delay
    		return new Greeting("Hello, " + message.getName() + "!");
    }

}
