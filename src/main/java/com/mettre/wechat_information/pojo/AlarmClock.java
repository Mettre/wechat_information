package com.mettre.wechat_information.pojo;

import com.mettre.wechat_information.enum_.FrequencyEnum;
import com.mettre.wechat_information.utils.RandomUtil;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 闹钟
 */
public class AlarmClock {

    private String clockId;

    @NotBlank(message = "请输入设备号")
    private String equipmentId;

    @Valid
    @NotNull(message = "闹钟时间不能为空")
    private ClockTimeBean clockTime;

    private String clockTheme;

    private Integer many;

    @NotBlank(message = "请选择播放的音乐")
    private String music;

    private Boolean isOpen;

    private Boolean isShock;

    private FrequencyEnum frequency;

    private String customDay;//自定义开启日期（周一、周二...）

    public String getClockId() {
        return clockId;
    }

    public ClockTimeBean getClockTime() {
        return clockTime;
    }

    public void setClockTime(ClockTimeBean clockTime) {
        this.clockTime = clockTime;
    }

    public void setClockId(String clockId) {
        this.clockId = clockId == null ? null : clockId.trim();
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public String getClockTheme() {
        return clockTheme;
    }

    public void setClockTheme(String clockTheme) {
        this.clockTheme = clockTheme == null ? null : clockTheme.trim();
    }

    public Integer getMany() {
        return many;
    }

    public void setMany(Integer many) {
        this.many = many;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music == null ? null : music.trim();
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public Boolean getShock() {
        return isShock;
    }

    public void setShock(Boolean shock) {
        isShock = shock;
    }

    public FrequencyEnum getFrequency() {
        return frequency;
    }

    public void setFrequency(FrequencyEnum frequency) {
        this.frequency = frequency;
    }

    public String getCustomDay() {
        return customDay;
    }

    public void setCustomDay(String customDay) {
        this.customDay = customDay == null ? null : customDay.trim();
    }


    public AlarmClock() {
    }

    public AlarmClock(AlarmClock alarmClock) {
        this.clockId = RandomUtil.AlarmClockNumber();
        this.equipmentId = alarmClock.getEquipmentId();
        this.clockTime = alarmClock.getClockTime();
        this.clockTheme = alarmClock.getClockTheme();
        this.many = alarmClock.getMany() <= 0 ? 1 : alarmClock.getMany();
        this.music = alarmClock.getMusic();
        this.isOpen = alarmClock.getOpen();
        this.isShock = alarmClock.getShock();
        this.frequency = alarmClock.getFrequency();
        this.customDay = alarmClock.getCustomDay();
    }
}