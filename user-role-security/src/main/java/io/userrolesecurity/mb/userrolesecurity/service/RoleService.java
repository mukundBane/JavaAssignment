package io.userrolesecurity.mb.userrolesecurity.service;

import io.userrolesecurity.mb.userrolesecurity.entity.RoleEntity;
import io.userrolesecurity.mb.userrolesecurity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleEntity createRole(RoleEntity roleEntity) {
        return roleRepository.save(roleEntity);
    }
}
