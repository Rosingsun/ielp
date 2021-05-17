package com.company.ielp.app.model.entity;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.company.ielp.app.model.dto.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * 用户
 * @author 幕冬儿
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String nickName;
    private String profile;
    private String email;
    private String phoneNumber;
    private String passWord;
    private String sex;
    private Date birthday;
    private Integer clockInContinuity;
    private Integer clockInTotal;
    private Integer studyTime;
    private Integer identifyImg;

    public UserDTO toUserDTO() {
        UserDTO userDTO = new UserDTO();
        BeanUtil.copyProperties(this, userDTO);
        return userDTO;
    }
}
