package com.dmm.config;


import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RepublishMessageRecoverer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RabbitMQConfiguration {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());




    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.publisher-confirms}")
    private boolean publisherConfirm;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;

    @Value("${spring.rabbitmq.template.mandatory}")
    private boolean mandatory;

//    spring:
//    rabbitmq:
//    host: 127.0.0.1
//    username: guest
//    password: guest
//    port: 5672


    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setPublisherConfirms(publisherConfirm); // 开启消息确认模式
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    /* 此处设置为prototype是因为一个RabbitTemplate实例只能被设置一次ConfirmCallBack，否则会报错
       所以如果想保持singleton类型，则需要保证template不会被重复setConfirmCallBack */
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setMandatory(mandatory); // 开启消息返回模式
        // 将两种不同确认模式的回调接口实例传入
        template.setConfirmCallback(new CallBackSender());
        template.setReturnCallback(new CallBackSender());
        return template;
    }


//  SimpleMessageListener  bean 消費消息的模式
//    @Bean
//    public SimpleMessageListenerContainer messageContainer() {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
//        container.setQueueNames("first-queue");
//        container.setExposeListenerChannel(true);
//        container.setMaxConcurrentConsumers(1);
//        container.setConcurrentConsumers(1);
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        container.setMessageListener(new ChannelAwareMessageListener() {
//
//            public void onMessage(Message message, Channel channel) throws Exception {
//                try {
//                    long deliverTag = message.getMessageProperties().getDeliveryTag();
//                    System.out.println(
//                            "消费端接收到消息:" + new String(message.getBody()));
//                    System.out.println("[deliverTag:" + deliverTag + "] " + message.getMessageProperties().getReceivedRoutingKey());
//
////                    if (deliverTag%2 == 0) {
////                        System.out.println("消息处理失败，重新返回队列");
////                        throw new Exception("数据处理错误");
////                    }
//
//                    if (deliverTag%2 == 0) {
//                        System.out.println("消息处理失败，重新返回队列");
//                        throw new Exception("数据处理错误");
//                    }
//
//                    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    //
//               channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
//                    //channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//                    // channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
//                }
//            }
//        });
//        return container;
//
//    }


}
