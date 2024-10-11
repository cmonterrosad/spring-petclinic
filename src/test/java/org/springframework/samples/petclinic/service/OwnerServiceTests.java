package org.springframework.samples.petclinic.service;

import Configuration.ObjectMapper;
import Configuration.WebConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
// Ensure that if the mysql profile is active we connect to the real database:
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// @TestPropertySource("/application-postgres.properties")
@Import({ WebConfig.class })
public class OwnerServiceTests {

	@Autowired
	protected OwnerRepository owners;

	@Autowired
	protected OwnerService ownerService;

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	@Test
	void shouldFindOwnersByLastName() {
		Page<Owner> owners = this.owners.findAll(Pageable.ofSize(5));
		assertThat(owners).isNotEmpty();

		Page<Owner> serviceTest = this.ownerService.findAllOwners();
		assertThat(owners.getSize()).isEqualTo(serviceTest.getSize());
	}

	@Test
	void checkBookSize() {
		Owner owners = this.ownerService.findOwnerById(1);
		assertThat(owners).isNotNull();
		assertThat(owners.getBooks().size()).isEqualTo(4);
	}

}
