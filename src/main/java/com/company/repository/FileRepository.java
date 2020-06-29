package com.company.repository;

import com.company.entity.FileStatus;
import com.company.entity.FileToSave;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileToSave, Long> {

    @Query(value = "select f from FileToSave f where f.fileName like %:name% order by f.id desc")
    Page<FileToSave> findByFileName(Pageable pageable, @Param("name") String name);

    @Query(value = "select f from FileToSave f where f.fileName like %:name%  and f.fileStatus=:status order by f.id desc")
    Page<FileToSave> findAllByFileStatusOrderByIdDesc(Pageable pageable, @Param("name") String name,
                                                      @Param("status") FileStatus fileStatus);

    Page<FileToSave> findAllByUser_LoginAndFileStatusIs(Pageable pageable, String userLogin, FileStatus fileStatus);

    Page<FileToSave> findAllByFileStatusIs(FileStatus status, Pageable pageable);

}