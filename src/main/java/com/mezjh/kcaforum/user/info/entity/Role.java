package com.mezjh.kcaforum.user.info.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 角色
 * @author zjh
 * @date 2020/4/21
 */
@Data
public class Role implements Serializable {
    public static int STATUS_NORMAL = 0;
    public static int STATUS_CLOSED = 1;

    public static String ROLE_ADMIN = "admin";

    public static long ADMIN_ID = 1;

    private long id;

    private String name;

    private String description;

    private int status;

    private List<Permission> permissions;
}
