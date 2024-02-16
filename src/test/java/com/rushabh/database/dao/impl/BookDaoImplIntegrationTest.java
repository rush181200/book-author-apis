package com.rushabh.database.dao.impl;


import com.rushabh.database.TestDataUtil;
import com.rushabh.database.dao.AuthorDao;
import com.rushabh.database.domain.Author;
import com.rushabh.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookDaoImplIntegrationTest {

    private AuthorDao authorDao;
    private BookDaoImpl underTest;

    @Autowired
    public BookDaoImplIntegrationTest(BookDaoImpl underTest, AuthorDao authorDao){
        this.underTest = underTest;
        this.authorDao =authorDao;
    }

    @Test
    public void testThatBook(){
        Author author = TestDataUtil.createAuthorA();
        authorDao.create(author);
        Book book = TestDataUtil.createThatbookA();
        book.setAuthorId(author.getId());
        underTest.create(book);
        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatMultiple(){

            Author author = TestDataUtil.createAuthorA();
            authorDao.create(author);

            Book bookA = TestDataUtil.createThatbookA();
            bookA.setAuthorId(author.getId());
            underTest.create(bookA);
            Book bookB = TestDataUtil.createThatbookB();
            bookB.setAuthorId(author.getId());
            underTest.create(bookB);
            Book bookC = TestDataUtil.createThatbookC();
            bookC.setAuthorId(author.getId());
            underTest.create(bookC);

        List<Book> res = underTest.find();
        assertThat(res).hasSize(3).containsExactly(bookA,bookB,bookC);
    }

    @Test
    public void testThatUpdateBook(){
        Author author = TestDataUtil.createAuthorA();
        authorDao.create(author);

        Book bookA = TestDataUtil.createThatbookA();
        bookA.setAuthorId(author.getId());
        underTest.create(bookA);

        bookA.setTitle("UPDATED");
        underTest.update(bookA.getIsbn(),bookA);

        Optional<Book> result = underTest.findOne(bookA.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookA);
    }

    @Test
    public void testThatBookDelete(){
        Author author = TestDataUtil.createAuthorA();
        authorDao.create(author);

        Book bookA = TestDataUtil.createThatbookA();
        bookA.setAuthorId(author.getId());
        underTest.create(bookA);

        underTest.delete(bookA.getIsbn());

        Optional<Book> result = underTest.findOne(bookA.getIsbn());
        assertThat(result).isEmpty();
    }
}