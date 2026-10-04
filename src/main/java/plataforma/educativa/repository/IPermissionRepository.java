package plataforma.educativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plataforma.educativa.model.Permission;
import plataforma.educativa.model.Role;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission,Long> {
}
