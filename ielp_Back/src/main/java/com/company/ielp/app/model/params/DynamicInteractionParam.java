package com.company.ielp.app.model.params;

import lombok.Data;

/**
 * 互动表单，包含点赞与评论功能
 * @author 幕冬
 */
@Data
public class DynamicInteractionParam {

    private Boolean isLike;
    private Boolean isComment;
    private String commentInfo;
    private Integer dynamicId;
    private Integer userId;

}
