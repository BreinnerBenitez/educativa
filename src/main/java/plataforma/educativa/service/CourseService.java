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
        return List.of();
    }

    @Override
    public CourseDTO findById(Long id) {
        return null;
    }

    @Override
    public CourseDTO update(Long id, CourseDTO CourseDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
