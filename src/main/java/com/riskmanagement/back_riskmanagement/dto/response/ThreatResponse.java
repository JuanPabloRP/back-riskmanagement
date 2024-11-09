package com.riskmanagement.back_riskmanagement.dto.response;


import com.riskmanagement.back_riskmanagement.dto.model.Threat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThreatResponse {
    private Integer id;
    private Integer userId;
    private String name;
    private String description;
    private String type;
    private boolean active;
    private String creationDate;
    private String modificationDate;

    public static ThreatResponse fromModel(Threat threat) {
        return ThreatResponse
                .builder()
                .id(threat.getId())
                .userId(threat.getUserId())
                .name(threat.getName())
                .description(threat.getDescription())
                .type(threat.getType())
                .active(threat.isActive())
                .creationDate(threat.getCreationDate())
                .modificationDate(threat.getModificationDate())
                .build();
    }
}