package plataforma.educativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plataforma.educativa.model.Professor;

@Repository
public interface IProfessorRepository extends JpaRepository<Professor,Long> {
}
