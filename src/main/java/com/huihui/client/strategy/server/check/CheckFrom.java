package com.huihui.client.strategy.server.check;

import com.huihui.client.pojo.ReqMessage;

/**
 * @className: CheckFrom
 * @description:
 * @author: huihui
 * @createDate: 2019-09-11
 * @version: 1.0
 */
public abstract class CheckFrom  {

    boolean checkFrom(ReqMessage reqMessage){
        return false;
    }
}
