package com.kaige.entity;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;


/**
 * (Source)实体类
 *
 * @author makejava
 * @since 2024-12-18 21:51:29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Source implements Serializable {
    private static final long serialVersionUID = -14871723336800757L;

    private Integer sourceId;
/**
     * 客户来源名称
     */
    private String sourceName;
/**
     * 客户id
     */
    private Integer empId;



}

