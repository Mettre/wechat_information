package com.mettre.wechat_information.pojo;

import lombok.Data;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
public class ClockTimeBean implements Serializable {

    @Min(value = 1, message = "时间格式错误")
    private Integer hours;

    @Min(value = 1, message = "时间格式错误")
    private Integer minutes;

    @Min(value = 1, message = "时间格式错误")
    private Integer seconds;

    public ClockTimeBean() {
    }
}
