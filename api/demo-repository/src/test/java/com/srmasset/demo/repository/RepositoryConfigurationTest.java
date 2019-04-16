package com.srmasset.demo.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = "com.srmasset.demo.repository.entity")
@EnableJpaRepositories(basePackages = {"com.srmasset.demo.repository"})
public class RepositoryConfigurationTest {
}
