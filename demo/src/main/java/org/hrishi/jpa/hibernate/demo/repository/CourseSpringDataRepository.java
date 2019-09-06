package org.hrishi.jpa.hibernate.demo.repository;

import java.util.List;

import org.hrishi.jpa.hibernate.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{
	
	List<Course> findByName(String name);
	List<Course> countByName(String name);
	List<Course> findByNameAndId(String name, Long id);
	List<Course> findByNameOrderByIdDesc(String name);
	@Query("Select c From Course c where name like '%100%'")
	List<Course> courseWith100InName();
	
	@Query(value = "Select * From Course c where name like '%100%'", nativeQuery = true)
	List<Course> courseWith100InNameUsingNativeQuery();
	
	@Query(name = "query_get_all_courses")
	List<Course> courseWithAnyNameUsingNamedQuery();
}
