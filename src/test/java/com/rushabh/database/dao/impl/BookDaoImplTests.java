//package com.rushabh.database.dao.impl;
//
//import com.rushabh.database.TestDataUtil;
//import com.rushabh.database.domain.Book;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)
//public class BookDaoImplTests {
//
//    @Mock
//    private JdbcTemplate jdbcTemplate;
//
//    @InjectMocks
//    private BookDaoImpl underTest;
//
//    @Test
//    public void testBook(){
//        Book book = TestDataUtil.createThatbookA();
//
//        underTest.create(book);
//
//        verify(jdbcTemplate).update(
//                eq("INSERT INTO books (isbn,title,author_id) VALUES (?,?,?)"),
//        eq("978-1-2345"),eq("The Shadow is Attic"),eq(1L));
//    }
//
//    @Test
//    public void testfindOneBook(){
//        underTest.findOne("978-1-2345");
//        verify(jdbcTemplate).query(
//                eq("SELECT isbn, title, author_id from books WHERE isbn =? LIMIT 1"),
//                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
//                eq("978-1-2345")
//        );
//    }
//
//    @Test
//    public void testThatFind(){
//        underTest.find();
//        verify(jdbcTemplate).query(
//                eq("SELECT isbn,title,author_id FROM books"),
//                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any()
//        );
//
//    }
//
//    @Test
//    public void testThatUpdateBook(){
//        Book book = TestDataUtil.createThatbookA();
//        underTest.update("978-1-2345",book);
//        verify(jdbcTemplate).update(
//                "UPDATE books SET isbn=?, title=?, author_id=? WHERE isbn=?",
//                "978-1-2345","The Shadow is Attic",1L,"978-1-2345"
//        );
//    }
//
//    @Test
//    public void testThatDelete(){
//        underTest.delete("978-1-2345");
//        verify(jdbcTemplate).update(
//                "DELETE FROM books WHERE isbn=?",
//                "978-1-2345"
//        );
//    }
//}
