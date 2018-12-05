package com.mettre.wechat_information.enum_;

public enum MomentsTypeEnum {

    PURE_TEXT(100), PHOTO(200);

    public int momentsType;

    MomentsTypeEnum(int momentsType) {
        this.momentsType = momentsType;
    }

    public int getMomentsType(int momentsType) {
        return momentsType;
    }
}
