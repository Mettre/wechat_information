package com.mettre.wechat_information.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mettre.wechat_information.utils.RandomUtil;
import com.mettre.wechat_information.vm.MomentsVM;
import lombok.Data;

import java.util.Date;

@Data
public class Moments {

    private String momentsId;

    private String momentsTitle;

    private String publisherUserId;

    private Date creationTime;

    @JsonIgnore
    private Boolean isShow;

    private String momentsImage;

    private String publisherUserName;

    private String publisherHeadAvatar;

    public Moments() {

    }

    public Moments(MomentsVM momentsVM) {
        this.momentsId = RandomUtil.generateUserId();
        this.momentsTitle = momentsVM.getMomentsTitle();
        this.publisherUserId = momentsVM.getPublisherUserId();
        this.creationTime = new Date();
        this.isShow = true;
        this.momentsImage = momentsVM.getMomentsImage();
    }
}