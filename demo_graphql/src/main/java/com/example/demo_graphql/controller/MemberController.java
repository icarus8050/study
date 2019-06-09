package com.example.demo_graphql.controller;

import com.example.demo_graphql.service.MemberService;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@Slf4j
public class MemberController {

    private final GraphQL graphQL;

    @Autowired
    public MemberController(MemberService memberService) {
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withBasePackages("com.example.demo_graphql")
                .withOperationsFromSingleton(memberService, MemberService.class)
                .generate();
        this.graphQL = GraphQL.newGraphQL(schema).build();
    }

    /*@Autowired
    public MemberController(MemberQuery memberQuery) {
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withBasePackages("com.example.demo_graphql")
                .withResolverBuilders(
                        new AnnotatedResolverBuilder())
                .withOperationsFromSingleton(memberQuery)
                .generate();
        graphQL = GraphQL.newGraphQL(schema).build();
    }*/

    @PostMapping(value = "/graphql",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, Object> indexFromAnnotated(@RequestBody Map<String, String> request,
                                                  HttpServletRequest raw) {
        ExecutionResult executionResult = graphQL.execute(ExecutionInput.newExecutionInput()
                .query(request.get("query"))
                .operationName(request.get("operationName"))
                .context(raw)
                .build());
        log.info("test aaaaaaaaa");
        return executionResult.toSpecification();
    }
}
