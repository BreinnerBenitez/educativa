package plataforma.educativa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import plataforma.educativa.dto.CourseDTO;
import plataforma.educativa.dto.ProfessorDTO;
import plataforma.educativa.model.Course;
import plataforma.educativa.model.Professor;
import plataforma.educativa.repository.ICourseRepository;
import plataforma.educativa.repository.IProfessorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {

    private final ICourseRepository courseRepository;
    private final IProfessorRepository professorRepository;

    @Override
    public CourseDTO save(CourseDTO courseDTO) {

        Professor professor = professorRepository
                .findById(courseDTO.professorId())
                .orElseThrow(() ->
                        new RuntimeException("Profesor no encontrado")
                );

        Course course = Course.builder()
                .name(courseDTO.name())
                .description(courseDTO.description())
                .professor(professor)
                .build();

        Course savedCourse = courseRepository.save(course);

        return  toDTO(savedCourse);

    }

    @Override
    public List<CourseDTO> findAll() {

        return courseRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();


    }

    @Override
    public CourseDTO findById(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Curso no encontrado")
                );

        return toDTO(course);
    }

    @Override
    public CourseDTO update(Long id, CourseDTO CourseDTO) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Curso no encontrado")
                );

        course.setName(CourseDTO.name());
        course.setDescription(CourseDTO.description());

        Course updatedCourse = courseRepository.save(course);

        return toDTO(updatedCourse);

    }

    @Override
    public void delete(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Curso no encontrado")
                );

        courseRepository.delete(course);


    }


    private CourseDTO toDTO(Course course) {

        return new CourseDTO(
                course.getId(),
                course.getDescription(),
                course.getName(),
                course.getProfessor().getId()
        );

    }
}
