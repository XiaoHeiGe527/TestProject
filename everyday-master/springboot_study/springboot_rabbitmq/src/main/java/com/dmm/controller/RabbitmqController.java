package com.dmm.controller;

import com.dmm.test.MsgProducer;
import com.dmm.utils.ProductMq;
import com.dmm.utils.RabbitmqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/mq")
public class RabbitmqController {

    @Autowired
    private RabbitmqUtils rabbitmqUtils;

    @Autowired
    private ProductMq productMq;

    @Autowired
    private MsgProducer firstSender;

    @RequestMapping
    public void index(){

        System.out.println("請求盡量");
    }

    @RequestMapping(value = "{id}")
    public void sendMq(@PathVariable long id){
        System.out.println(id+"0000000000000000");
//        for (long i=0;i<id;i++)
//        {
            rabbitmqUtils.sendDmm(id);
//        }
    }

    @RequestMapping(value = "/A/{id}")
    public void sendMqA(@PathVariable long id){
        System.out.println(id+"0000000000000000");
        rabbitmqUtils.sendAA(id);
        rabbitmqUtils.sendAB(id);
        rabbitmqUtils.sendAC(id);
    }
    @RequestMapping(value = "/B/{id}")
    public void sendMqB(@PathVariable long id){
        System.out.println(id+"0000000000000000");
        rabbitmqUtils.sendBA(id);
//        System.out.println("-----");
//        rabbitmqUtils.sendBB(id);
//        System.out.println("-----");
//        rabbitmqUtils.sendBC(id);
    }
    @RequestMapping(value = "/C/{id}")
    public void sendMqC(@PathVariable long id){
        System.out.println(id+"0000000000000000");
        rabbitmqUtils.sendCA(id);
        rabbitmqUtils.sendCB(id);
        rabbitmqUtils.sendCC(id);
    }
    @RequestMapping(value = "/hello/{id}")
    public void sendMq100(@PathVariable long id){
        System.out.println(id+"0000000000000000");
        productMq.send();
    }

    @RequestMapping(value = "/id/{id}")
    public void sendMq10(@PathVariable Long id){
        System.out.println(id+"0000000000000000");
        rabbitmqUtils.sendId(id);
    }



    @RequestMapping(value = "/channel/{id}")
    public void channelTest(@PathVariable Long id){
        System.out.println(id+"0000000000000000");
        rabbitmqUtils.sendId(id);
    }



//    @GetMapping("/send")
//    public String send(String message) {
//        String uuid = UUID.randomUUID().toString();
////        firstSender.send(uuid, message);
//        firstSender.sendAdmin(uuid, message);
//        return uuid;
//    }


    @GetMapping("/firstSend")
    public String testSend(String message) {
        String uuid = UUID.randomUUID().toString();
//        firstSender.send(uuid, message);
        firstSender.firstSend(message);
        return uuid;
    }
//MsgProducer

}
