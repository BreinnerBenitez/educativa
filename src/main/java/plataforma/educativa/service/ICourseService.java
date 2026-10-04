package plataforma.educativa.service;

import org.springframework.stereotype.Service;
import plataforma.educativa.dto.CourseDTO;

import java.util.List;

@Service
public interface ICourseService {

    CourseDTO save(CourseDTO CourseDTO);

    List<CourseDTO> findAll();

    CourseDTO findById(Long id);

    CourseDTO update(Long id, CourseDTO CourseDTO);

    void delete(Long id);
}
