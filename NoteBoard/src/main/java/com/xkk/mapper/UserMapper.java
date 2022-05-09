package com.xkk.mapper;


import com.xkk.bean.DO.LoginDO;
import com.xkk.bean.DO.LoginsDO;
import com.xkk.bean.DO.UserDO;
import com.xkk.bean.DO.UserListDO;
import com.xkk.bean.DTO.LoginDTO;
import com.xkk.bean.DTO.UpdateActiveDTO;
import com.xkk.bean.DTO.UpdateAvatarDTO;

import java.util.List;

public interface UserMapper {
    UserDO getInfo(Integer id);
    LoginDO login(LoginDTO loginDTO);
    Integer updateActive(UpdateActiveDTO updateActiveDTO);
    LoginsDO logins();
    List<String> findActive();
    List<UserListDO> findAllUser();
    Integer delUser(Integer id);
    Integer updateAvatar(UpdateAvatarDTO updateAvatarDTO);
}
