package com.company.repository;

import com.company.entity.FileToSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileToSave,Long> {

}
