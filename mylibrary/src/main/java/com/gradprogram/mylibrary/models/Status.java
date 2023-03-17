package com.gradprogram.mylibrary.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity(name = "statuses")
public class Status {
    @Id
    @GeneratedValue
    private Long status_id;
    private String status;
}
