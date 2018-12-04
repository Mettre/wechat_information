package com.mettre.wechat_information.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MomentsParameter {

    private String momentsId;

    private String momentsTitle;

    private Date creationTime;

    private String momentsImage;//暂时只单张图

    private UserBean userBean;

    @Data
    public static class UserBean{

        private String publisherUserName;

        private String publisherHeadAvatar;

        private String publisherUserId;
    }
}
