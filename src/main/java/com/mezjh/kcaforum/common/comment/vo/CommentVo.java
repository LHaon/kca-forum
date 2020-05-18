package com.mezjh.kcaforum.common.comment.vo;

import com.mezjh.kcaforum.common.comment.entity.CommentInfo;
import com.mezjh.kcaforum.common.text.entity.TextInfo;
import com.mezjh.kcaforum.user.info.entity.User;
import lombok.Data;

import java.util.Date;

/**
 * @author zjh
 * @date 2020/5/16
 */
@Data
public class CommentVo extends CommentInfo {

    private User user;
    private CommentVo parent;
    private TextInfo post;
}
