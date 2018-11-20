package com.mettre.wechat_information.pojo;

import com.mettre.wechat_information.enum_.DynamicTypeEnum;
import com.mettre.wechat_information.utils.RandomUtil;
import com.mettre.wechat_information.vm.ReadVM;
import lombok.Data;

import java.util.Date;

@Data
public class Read {

    private String readId;

    private String dynamicId;

    private DynamicTypeEnum dynamicType;

    private String readerId;

    private String readerEquipment;

    private Date creationTime;

    public Read() {

    }

    public Read(String dynamicId, DynamicTypeEnum dynamicType, String readerId, String readerEquipment) {
        this.readId = RandomUtil.ReadInformationNumber();
        this.dynamicId = dynamicId;
        this.dynamicType = dynamicType;
        this.readerId = readerId;
        this.readerEquipment = readerEquipment;
        this.creationTime = new Date();
    }

    public Read(ReadVM readVM) {
        this.readId = RandomUtil.ReadInformationNumber();
        this.dynamicId = readVM.getDynamicId();
        this.dynamicType = readVM.getDynamicType();
        this.readerId = readVM.getReaderId();
        this.readerEquipment = readVM.getReaderEquipment();
        this.creationTime = new Date();
    }
}