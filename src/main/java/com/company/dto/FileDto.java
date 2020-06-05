package com.company.dto;

public class FileDto {

    private String originFileName;
    private byte[] content;
    private long size;

    public FileDto(String originFileName, byte[] content, long size) {
        this.originFileName = originFileName;
        this.content = content;
        this.size = size;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
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
}
