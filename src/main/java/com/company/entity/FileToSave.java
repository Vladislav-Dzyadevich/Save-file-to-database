package com.company.entity;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class FileToSave {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "content", columnDefinition = "blob")
    private byte[] content;

    @Column(name = "size")
    private long size;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public FileToSave() {
    }
}
