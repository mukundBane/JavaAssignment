package io.userrolesecurity.mb.userrolesecurity.repository;

import io.userrolesecurity.mb.userrolesecurity.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

}
