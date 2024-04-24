package com.example.rabbitsender.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Message {
    //    private NotificationType type;
    @NotEmpty
    @NotBlank
    @NotNull
    private String message;
    private ZonedDateTime time;
    @NotEmpty
    @NotBlank
    @NotNull
    private String external_id;
}
