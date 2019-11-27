package com.dmm.test;

import com.dmm.util.RedisTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * @author DMM
 * @create 2019/11/1
 */
@RunWith(SpringRunner.class)
//
@SpringBootTest
public class BaseTest {

    @Autowired
    RedisTool redisTool;

    @Test
    public void aa(){

        String pattern="pa_123*";

        Consumer<byte[]> consumer=new Consumer<byte[]>() {
            @Override
            public void accept(byte[] bytes) {
                System.out.println(new String(bytes)+"---------------------------");
            }
        };

        redisTool.scan(pattern,consumer);
    }

    @Test
    public void bb(){

        String key="20191101";

        String[] strings=new String[11];

        for(int i=0;i<strings.length;i++){
            strings[i]="abc"+i;
        }

        redisTool.hset(key,strings);
    }
    @Test
    public void cc() throws IOException {


        redisTool.getPattern("a","abc*",5L);
    }


}

