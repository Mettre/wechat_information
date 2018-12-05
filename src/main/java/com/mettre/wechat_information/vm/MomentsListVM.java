package com.mettre.wechat_information.vm;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class MomentsListVM extends PageUtil {

    @NotBlank(message = "查询人不能为空")
    String userId;
}
