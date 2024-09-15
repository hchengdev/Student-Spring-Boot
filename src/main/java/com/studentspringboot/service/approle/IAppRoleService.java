package com.studentspringboot.service.approle;

import com.studentspringboot.model.AppRole;
import com.studentspringboot.service.IGenerateService;

public interface IAppRoleService extends IGenerateService<AppRole> {
    AppRole findByName(String name);
}
