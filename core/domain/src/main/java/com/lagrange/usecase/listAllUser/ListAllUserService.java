package com.lagrange.usecase.listAllUser;

import com.lagrange.usecase.model.user.UserDto;

import java.util.List;

public interface ListAllUserService {
    List<UserDto> listAll();
}
