package com.company.repository;

import com.company.entity.FileStatus;
import com.company.entity.FileToSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileToSave, Long> {
    @Query(value = "select f from FileToSave f where f.fileName like %:name%")
    List<FileToSave> findByFileName(@Param("name") String name);

    List<FileToSave> findAllByFileStatus(FileStatus fileStatus);

    List<FileToSave> findAllByUser_LoginAndFileStatusIs(String userLogin, FileStatus fileStatus);
}