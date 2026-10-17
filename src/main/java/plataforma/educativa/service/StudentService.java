package plataforma.educativa.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import plataforma.educativa.dto.StudentDTO;
import plataforma.educativa.model.Professor;
import plataforma.educativa.model.Student;
import plataforma.educativa.repository.IStudentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {

    private final IStudentRepository studentRepository;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {


        Student student = Student.builder()
                .name(studentDTO.name())
                .email(studentDTO.email())
                .build();

        Student savedStudent = studentRepository.save(student);

        return toRecord(savedStudent);

    }

    @Override
    public List<StudentDTO> findAll() {

        return studentRepository.findAll()
                .stream()
                .map(this::toRecord)
                .toList();
    }

    @Override
    public StudentDTO findById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Profesor no encontrado con ID: " + id)
                );

        return toRecord(student);
    }

    @Override
    public StudentDTO update(Long id, StudentDTO studentDTO) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Profesor no encontrado con ID: " + id)
                );

        student.setName(studentDTO.name());
        student.setEmail(studentDTO.email());

        Student updatedStudent = studentRepository.save(student);

        return toRecord(updatedStudent);


    }

    @Override
    public void delete(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Profesor no encontrado con ID: " + id)
                );

        studentRepository.delete(student);
    }

    private StudentDTO toRecord(Student student) {

        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getEmail()
        );
    }
}
