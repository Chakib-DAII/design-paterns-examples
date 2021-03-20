package com.example.design.patterns.operational.repository;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

/**
 * Created by chakib.daii on 3/20/2021.
 */
@Entity
@Table(name = "samples")
public class SampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SAMPLE_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SAMPLE_DESCRIPTION")
    private String description;

    public SampleEntity() {
    }

    public SampleEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SampleEntity{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
