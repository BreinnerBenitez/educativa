package plataforma.educativa.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import plataforma.educativa.dto.StudentDTO;
import plataforma.educativa.repository.IStudentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService{

  private final IStudentRepository studentRepository;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public List<StudentDTO> findAll() {
        return List.of();
    }

    @Override
    public StudentDTO findById(Long id) {
        return null;
    }

    @Override
    public StudentDTO update(Long id, StudentDTO studentDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
