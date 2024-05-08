package com.example;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class productDTO {
    String containerName;
    Long containerWeight;
    Long createdBY;
}
