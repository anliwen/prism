package com.prism.api.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author anliwen
 */
@Data
@TableName("db_faithquant_prism.tb_test")
public class Test {
    private Integer id;
    private String username;
    private String password;
}
