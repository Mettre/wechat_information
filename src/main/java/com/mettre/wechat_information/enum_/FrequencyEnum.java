package com.mettre.wechat_information.enum_;

/**
 * 闹钟频率
 */
public enum FrequencyEnum {

    EVERYDAY("每天"), HOLIDAY("节假日"),CUSTOM("自定义");

    private String frequency;

    FrequencyEnum(String frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static boolean contains(String frequency) {
        for (FrequencyEnum typeEnum : FrequencyEnum.values()) {
            if (typeEnum.name().equals(frequency)) {
                return true;
            }
        }
        return false;
    }
}
