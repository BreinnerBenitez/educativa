package plataforma.educativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plataforma.educativa.model.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {
}
