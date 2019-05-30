package com.example.demo_graphql;

import com.example.demo_graphql.domain.Member;
import com.example.demo_graphql.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemoGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGraphqlApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(MemberRepository memberRepository) {
        return (args) -> {
            Member member = Member.builder().name("aa").age(1L).build();
            memberRepository.save(member);
        };
    }
}
