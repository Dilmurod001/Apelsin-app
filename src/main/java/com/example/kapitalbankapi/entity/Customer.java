package com.example.kapitalbankapi.entity;

import com.example.kapitalbankapi.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends AbsEntity {

    private String name;
    private String country;
    private String address;
    private String phone;
}
