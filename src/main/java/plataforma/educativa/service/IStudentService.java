package plataforma.educativa.service;


import plataforma.educativa.dto.StudentDTO;

import java.util.List;


public interface IStudentService {


    StudentDTO save(StudentDTO studentDTO);

    List<StudentDTO> findAll();

    StudentDTO findById(Long id);

    StudentDTO update(Long id, StudentDTO studentDTO);

    void delete(Long id);


}
