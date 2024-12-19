package com.kaige.entity;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;


/**
 * (User)实体类
 *
 * @author makejava
 * @since 2024-12-18 21:51:29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = -24941689591741963L;

    private Integer id;

    private String username;

    private String password;

    private String email;



}

