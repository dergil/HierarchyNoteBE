package com.example.hierarchy_notes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,String> {
}
