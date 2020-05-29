package com.miaoph.cn.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (PhUser)实体类
 *
 * @author makejava
 * @since 2020-05-28 17:37:44
 */
@Data
public class PhUser implements Serializable {
    private static final long serialVersionUID = -73632477583526296L;
    
    private int id;
    
    private String name;
    
    private Integer age;

}