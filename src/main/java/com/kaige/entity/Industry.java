package com.kaige.entity;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;


/**
 * (Industry)实体类
 *
 * @author makejava
 * @since 2024-12-18 21:51:29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Industry implements Serializable {
    private static final long serialVersionUID = -36778794711443964L;

    private Integer industryId;
/**
     * 行业名称
     */
    private String industryName;
/**
     * 客户id
     */
    private Integer empId;



}

