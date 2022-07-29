package com.example.libraryautomation.dataAccess;

import com.example.libraryautomation.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {


     public Library findLibraryByNameContaining(String name);


}
