package com.mettre.wechat_information.base;

import com.mettre.wechat_information.enum_.ResultEnum;
import com.mettre.wechat_information.exception.CustomerException;

public class ReturnType {

    public static int ReturnType(int type, ResultEnum resultEnum) {
        if (type < 1) {
            throw new CustomerException(resultEnum);
        }
        return type;
    }

    public static Object ReturnType(Object object, ResultEnum resultEnum) {
        if (object == null) {
            throw new CustomerException(resultEnum);
        }
        return object;
    }
}
