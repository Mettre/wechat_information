package com.mettre.wechat_information.vm;

import com.mettre.wechat_information.enum_.DynamicTypeEnum;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;


@Data
public class ReadVM {

    @NotBlank(message = "请输入资讯id")
    private String dynamicId;

    @NotBlank(message = "请输入资讯类别")
    private DynamicTypeEnum dynamicType;

    private String readerId;

    private String readerEquipment;

}
