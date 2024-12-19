package com.kaige.entity;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;


/**
 * (Grade)实体类
 *
 * @author makejava
 * @since 2024-12-18 21:51:29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Grade implements Serializable {
    private static final long serialVersionUID = -52961856178500970L;

    private Integer gradeId;
/**
     * 等级名称
     */
    private String gradeName;
/**
     * 客户id
     */
    private Integer empId;



}

