package com.mettre.wechat_information.vm;

import com.mettre.wechat_information.enum_.MomentsTypeEnum;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class MomentsVM {

    @NotBlank(message = "说说内容不能为空")
    private String momentsTitle;

    @NotBlank(message = "发布人不能为空")
    private String publisherUserId;

    private String momentsImage;

    private MomentsTypeEnum momentsType;

}
