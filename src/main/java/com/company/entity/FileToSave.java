package com.company.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "files")
@Getter
@Setter
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

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private FileStatus fileStatus;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private CustomUser user;

}
