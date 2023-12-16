package com.keyin.Admin.Repository;

import com.keyin.Admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "admin", path = "admin")
public interface AdminRepository extends JpaRepository<Admin, Long> {

}