package com.riskmanagement.back_riskmanagement.dto.model;


import com.riskmanagement.back_riskmanagement.entity.ThreatEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Threat {

    private Integer id;
    private Integer userId;

    @NotNull(message = "Name is required")
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    private String name;

    @NotNull(message = "Description is required")
    @Size(min = 1, max = 500, message = "Description must be between 1 and 500 characters")
    private String description;
    private String type;
    private boolean active;
    private String creationDate;
    private String modificationDate;

    public static Threat fromEntity(ThreatEntity threatEntity) {
        return Threat
                .builder()
                .id(threatEntity.getId())
                .userId(threatEntity.getUserId())
                .name(threatEntity.getName())
                .description(threatEntity.getDescription())
                .type(threatEntity.getType())
                .active(threatEntity.isActive())
                .creationDate(String.valueOf(threatEntity.getCreationDate()))
                .modificationDate(String.valueOf(threatEntity.getModificationDate()))
                .build();
    }

    public static ThreatEntity toEntity(Threat threat) {
        return ThreatEntity
                .builder()
                .id(threat.getId())
                .userId(threat.getUserId())
                .name(threat.getName())
                .description(threat.getDescription())
                .type(threat.getType())
                .active(threat.isActive())
                .creationDate(LocalDate.parse(threat.getCreationDate()))
                .modificationDate(LocalDate.parse(threat.getModificationDate()))
                .build();
    }
}