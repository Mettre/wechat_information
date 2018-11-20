package com.mettre.wechat_information.vm;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class NewsVM {

    @NotBlank(message = "请输入新闻标题")
    private String newsTitle;

    @NotBlank(message = "新闻作者不能为空")
    private String publisherUserId;

    @NotBlank(message = "请输入新闻链接")
    private String newsLink;

    private String newsImage;
}
