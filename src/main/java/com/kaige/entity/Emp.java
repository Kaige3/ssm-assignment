package com.kaige.entity;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;


/**
 * (Emp)实体类
 *
 * @author makejava
 * @since 2024-12-18 21:51:28
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Emp implements Serializable {
    private static final long serialVersionUID = 144653297807110540L;
/**
     *  客户编号
     */
    private Integer id;
/**
     * 客户名称
     */
    private String name;
/**
     * 联系人
     */
    private String linkman;
/**
     * 移动电话

     */
    private String phone;
/**
     * 固定电话
     */
    private String telephone;
/**
     * 邮政编号
     */
    private String postalCode;
/**
     * 地址
     */
    private String address;
/**
     * 客户来源
     */
    private String sourceId;
/**
     * 所属行业
     */
    private String industryId;
/**
     * 客户级别
     */
    private Integer gradeId;



}

