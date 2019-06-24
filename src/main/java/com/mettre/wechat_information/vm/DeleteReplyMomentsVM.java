package com.mettre.wechat_information.vm;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class DeleteReplyMomentsVM {

    @NotBlank(message = "评论id为空")
    String replyId;
}
