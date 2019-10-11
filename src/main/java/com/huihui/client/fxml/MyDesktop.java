package com.huihui.client.fxml;

import com.huihui.client.ClientApplication;
import com.huihui.client.server.NettyClientServer;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @className: MyDesktop
 * @description:
 * @author: huihui
 * @createDate: 2019-10-10
 * @version: 1.0
 */
public class MyDesktop extends Application implements Runnable {


    public void run(){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
        ClientApplication.runNetty();
    }



}
