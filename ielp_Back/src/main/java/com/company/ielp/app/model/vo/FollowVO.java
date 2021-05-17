package com.company.ielp.app.model.vo;

import com.company.ielp.app.model.dto.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class FollowVO extends BaseVO {

    List<UserDTO> follows;

    List<UserDTO> followers;

}
