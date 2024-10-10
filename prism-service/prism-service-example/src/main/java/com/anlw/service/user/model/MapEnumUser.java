package com.anlw.service.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

/**
 * @author anliwen
 */
@Data
public class MapEnumUser {

    @Schema(description = "姓名", allowableValues = "张飞,关羽,赵云")
    private String name;

    @Schema(description = "枚举类型",allowableValues = "[PICTURE、AUDIO、VIDEO、URL]",requiredMode = REQUIRED)
    private CourseType courseType;
}
