package com.mezjh.kcaforum.user.info.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zjh
 * @date 2020/4/21
 */
@Data
public class Permission implements Serializable {
    private Long id;

    private Long parentId;

    private String name;

    private String description;

    private Integer weight;

    private Integer version;
}
