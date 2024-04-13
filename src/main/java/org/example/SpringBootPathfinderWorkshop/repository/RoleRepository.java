package org.example.SpringBootPathfinderWorkshop.repository;

import org.example.SpringBootPathfinderWorkshop.model.entity.Role;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    Role findByName(RoleNameEnum roleNameEnum);
}
