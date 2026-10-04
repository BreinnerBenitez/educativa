package plataforma.educativa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plataforma.educativa.dto.CourseDTO;
import plataforma.educativa.service.ICourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDTO> save(
            @RequestBody CourseDTO CourseDTO) {

        return ResponseEntity.ok(
                courseService.save(CourseDTO)
        );
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll() {

        return ResponseEntity.ok(
                courseService.findAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                courseService.findById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(
            @PathVariable Long id,
            @RequestBody CourseDTO CourseDTO) {

        return ResponseEntity.ok(
                courseService.update(id, CourseDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        courseService.delete(id);

        return ResponseEntity.noContent().build();


    }
}
