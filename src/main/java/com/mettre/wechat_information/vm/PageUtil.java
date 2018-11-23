package com.mettre.wechat_information.vm;

import lombok.Data;
import org.hibernate.validator.constraints.Range;


@Data
public class PageUtil {

    @Range(min = 0, message = "分页参数不全")
    private Integer page;

    @Range(min = 1, message = "分页参数不全")
    private Integer size;
}
