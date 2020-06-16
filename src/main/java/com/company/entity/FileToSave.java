package com.company.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "files")
@Data
@NoArgsConstructor

public class FileToSave {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "content", columnDefinition = "longblob")
    private byte[] content;

    @Column(name = "size")
    private long size;
}
