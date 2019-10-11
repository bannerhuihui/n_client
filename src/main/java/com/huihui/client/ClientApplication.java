package com.huihui.client;

import com.huihui.client.fxml.MyDesktop;
import com.huihui.client.server.NettyClientServer;
import com.spring4all.mongodb.EnableMongoPlus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@EnableMongoPlus
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
        run();
        //runNetty();
    }

    public static void run(){
        Thread thread = new Thread(new MyDesktop());
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void runNetty(){
        Thread t1 = new Thread(new NettyClientServer());
        t1.start();
        try {
            t1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
