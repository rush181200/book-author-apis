package com.rushabh.database.dao.impl;


import com.rushabh.database.TestDataUtil;
import com.rushabh.database.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorDaoImplIntegrationTest {
    private AuthorDaoImpl underTest;

    @Autowired
    public AuthorDaoImplIntegrationTest(AuthorDaoImpl underTest){
        this.underTest = underTest;
    }

    @Test
    public void testAuthorCreateAndGet(){
        Author author = TestDataUtil.createAuthorA();
        underTest.create(author);
        Optional<Author> result = underTest.findOne(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatMultipleAuthors(){
        Author authorA = TestDataUtil.createAuthorA();
        underTest.create(authorA);
        Author authorB = TestDataUtil.createAuthorB();
        underTest.create(authorB);
        Author authorC = TestDataUtil.createAuthorC();
        underTest.create(authorC);

        List<Author> result = underTest.find();
        assertThat(result).hasSize(3);
        assertThat(result).containsExactly(authorA,authorB,authorC);
    }

    @Test
    public void testThatUpdate(){
        Author authorA = TestDataUtil.createAuthorA();
        underTest.create(authorA);
        authorA.setName("UPDATED");
        underTest.update(authorA.getId(),authorA);
        Optional<Author> result = underTest.findOne(authorA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorA);
    }

    @Test
    public void TestThatAuthorDelete(){
        Author authorA = TestDataUtil.createAuthorA();
        underTest.create(authorA);
        underTest.delete(authorA.getId());
        underTest.findOne(authorA.getId());
        Optional<Author> res = underTest.findOne(authorA.getId());
        assertThat(res).isEmpty();
    }
}
