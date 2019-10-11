package com.huihui.client.strategy.server.check;

import com.huihui.client.pojo.ReadMessage;
import com.huihui.client.pojo.ReturnMessage;

/**
 * @className: CheckFrom
 * @description:
 * @author: huihui
 * @createDate: 2019-09-11
 * @version: 1.0
 */
public abstract class CheckFrom  {

    public boolean checkFrom(ReadMessage readMessage){
        return false;
    }
}
