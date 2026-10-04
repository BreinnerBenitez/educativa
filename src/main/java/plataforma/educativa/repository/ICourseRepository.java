package plataforma.educativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plataforma.educativa.model.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course,Long> {
}
