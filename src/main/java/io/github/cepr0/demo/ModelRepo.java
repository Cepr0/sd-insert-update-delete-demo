package io.github.cepr0.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ModelRepo extends JpaRepository<Model, Integer> {
	
	@Modifying
	@Query(value = "insert into model values (?1, ?2)", nativeQuery = true)
	int insertWithNativeQuery(Integer id, String name);

	@Modifying
	@Query("update Model m set m.name = ?2 where m.id = ?1")
	int updateWithQuery(int id, String name);
	
	@Modifying
	@Query("update Model m set m.name = ?2 where m.name = ?1")
	int updateWithQueryByName(String oldName, String newName);

	@Modifying
	@Query("delete from Model m where m.id = ?1")
	int deleteWithQuery(int id);
	
	@Modifying
	@Query(value = "update model m set m.name = ?2 where m.id = ?1", nativeQuery = true)
	int updateWithNativeQuery(int id, String name);
	
	@Modifying
	@Query(value = "delete from model m where m.id = ?1", nativeQuery = true)
	int deleteWithNativeQuery(int id);
}
