package com.orange.freelance_rfb.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JobCreatorDto {
    private Long jobId;
    private String login;
    private String description;
    private Integer price;
}
