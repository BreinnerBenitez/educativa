package plataforma.educativa.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Set;
@JsonPropertyOrder({"id", "name", "description"})
public record CourseDTO(Long id,
                        String name,
                        String description
) {
}
