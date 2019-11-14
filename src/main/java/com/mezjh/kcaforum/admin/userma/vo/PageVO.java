package com.mezjh.kcaforum.admin.userma.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zjh
 * @date 2019/11/13
 */
@Data
public class PageVO {

    @NotNull(message = "当前页码不能为空")
    private int pageNum;
    @NotNull(message = "每页显示行数不能为空")
    private int pageSize;
}
