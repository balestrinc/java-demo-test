package com.srmasset.demo.repository;

import com.srmasset.demo.api.Risk;
import com.srmasset.demo.repository.entity.ClientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RepositoryConfigurationTest.class)
@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository repository;

    @Test
    public void findOnedReturnClient() {
        ClientEntity created = this.repository.save(new ClientEntity("Patrick", 1000d, 2, Risk.A));
        ClientEntity client = this.repository.findOne(created.getId());

        assertThat(client.getName()).isEqualTo("Patrick");
        assertThat(client.getCreditLimit()).isEqualTo(1000d);
        assertThat(client.getInterestRate()).isEqualTo((short) 2);
        assertThat(client.getRisk()).isEqualTo(Risk.A);

    }
}
