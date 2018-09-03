package io.github.cepr0.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ModelRepoTest {

	@Autowired private ModelRepo modelRepo;

	private Model model1;
	private Model model2;

	@Before
	public void setUp() {
		model1 = modelRepo.save(new Model("model"));
		model2 = modelRepo.save(new Model("model"));
	}

	@Test
	public void updateWithQuery_shouldReturn1() {
		assertThat(modelRepo.updateWithQuery(model1.getId(), "updated")).isEqualTo(1);
	}
	
	@Test
	public void updateWithQuery_shouldReturn0() {
		assertThat(modelRepo.updateWithQuery(200, "updated")).isEqualTo(0);
	}
	
	@Test
	public void deleteWithQuery_shouldReturn1() {
		assertThat(modelRepo.deleteWithQuery(model2.getId())).isEqualTo(1);
	}
	
	@Test
	public void updateWithNativeQuery_shouldReturn1() {
		assertThat(modelRepo.updateWithNativeQuery(model1.getId(), "updated")).isEqualTo(1);
	}
	
	@Test
	public void deleteWithNativeQuery_shouldReturn1() {
		assertThat(modelRepo.deleteWithNativeQuery(model2.getId())).isEqualTo(1);
	}
	
	@Test
	public void insertWithNativeQuery_shouldReturn1() {
		assertThat(modelRepo.insertWithNativeQuery(100, "model3")).isEqualTo(1);
	}
	
	@Test
	public void updateWithQueryByName_shouldReturn2() {
		assertThat(modelRepo.updateWithQueryByName("model", "updated")).isEqualTo(2);
	}
}