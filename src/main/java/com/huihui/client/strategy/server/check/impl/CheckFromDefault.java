package com.huihui.client.strategy.server.check.impl;

import com.huihui.client.common.ProConfig;
import com.huihui.client.pojo.ReadMessage;
import com.huihui.client.pojo.ReturnMessage;
import com.huihui.client.strategy.server.check.CheckFrom;
import org.apache.commons.lang3.StringUtils;

/**
 * @className: CheckFromDefault
 * @description:
 * @author: huihui
 * @createDate: 2019-09-24
 * @version: 1.0
 */
public class CheckFromDefault extends CheckFrom {


    @Override
    public boolean checkFrom(ReadMessage readMessage) {
        if(StringUtils.equals(readMessage.getFrom(), ProConfig.SERVER_NAME.getCode())){
            return true;
        }
        return false;
    }
}
