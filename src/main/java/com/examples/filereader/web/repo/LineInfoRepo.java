package com.examples.filereader.web.repo;

import com.examples.filereader.web.entity.LineInfo;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface LineInfoRepo extends CrudRepository<LineInfo, Integer> {

}
