package plataforma.educativa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import plataforma.educativa.dto.CourseDTO;
import plataforma.educativa.model.Course;
import plataforma.educativa.repository.ICourseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {

    private final ICourseRepository courseRepository;

    @Override
    public CourseDTO save(CourseDTO CourseDTO) {
        Course course = Course.builder()
                .name(CourseDTO.name())
                .description(CourseDTO.description())
                .build();

        Course savedCourse = courseRepository.save(course);

        return new CourseDTO(
                savedCourse.getId(),
                savedCourse.getName(),
                savedCourse.getDescription()
        );

    }

    @Override
    public List<CourseDTO> findAll() {

        return courseRepository.findAll()
                .stream()
                .map(course -> new CourseDTO(
                        course.getId(),
                        course.getName(),
                        course.getDescription()
                ))
                .toList();


    }

    @Override
    public CourseDTO findById(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Curso no encontrado")
                );

        return new CourseDTO(
                course.getId(),
                course.getName(),
                course.getDescription()
        );
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

        return new CourseDTO(
                updatedCourse.getId(),
                updatedCourse.getName(),
                updatedCourse.getDescription()
        );

    }

    @Override
    public void delete(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Curso no encontrado")
                );

        courseRepository.delete(course);

    }
}
