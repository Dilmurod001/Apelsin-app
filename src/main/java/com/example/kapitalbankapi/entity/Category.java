package com.example.kapitalbankapi.entity;

import com.example.kapitalbankapi.entity.template.AbsEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Category extends AbsEntity {
    private String name;

}
