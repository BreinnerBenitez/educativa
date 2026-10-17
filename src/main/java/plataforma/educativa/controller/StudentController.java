package plataforma.educativa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import plataforma.educativa.dto.ProfessorDTO;
import plataforma.educativa.dto.StudentDTO;
import plataforma.educativa.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private  final StudentService studentService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StudentDTO> save(
            @RequestBody StudentDTO studentDTO) {

        return ResponseEntity.ok(studentService.save(studentDTO));
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() {

        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(studentService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(
            @PathVariable Long id,
            @RequestBody StudentDTO studentDTO) {

        return ResponseEntity.ok(
                studentService.update(id, studentDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        studentService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
