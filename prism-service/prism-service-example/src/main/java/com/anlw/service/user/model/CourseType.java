package com.anlw.service.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author anliwen
 */
@Getter
@AllArgsConstructor
@Schema(allowableValues = "[PICTURE、AUDIO]")
public enum CourseType {
    /**
     * 图文
     */
    PICTURE(1021, "图文"),
    /**
     * 音频
     */
    AUDIO(103, "音频");

    private final int type;
    private final String desc;

    @Override
    public String toString() {
        return this.type + ":" + this.desc;
    }
}
