package plataforma.educativa.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plataforma.educativa.model.Role;
import plataforma.educativa.model.UserSec;

import java.util.Optional;
@Repository
public interface IUserRepository extends JpaRepository<UserSec,Long> {

    //Crea la sentencia en base al nombre en inglés del método
    //Tmb se puede hacer mediante Query pero en este caso no es necesario
    Optional<UserSec> findUserEntityByUsername(String username);

}
