package com.mettre.wechat_information.vm;

import com.mettre.wechat_information.enum_.MomentsTypeEnum;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class MomentsVM {

    @NotBlank(message = "说说内容不能为空")
    private String momentsTitle;

    private String momentsImage;

    private MomentsTypeEnum momentsType;

}
