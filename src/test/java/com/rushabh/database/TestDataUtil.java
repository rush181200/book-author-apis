package com.rushabh.database;

import com.rushabh.database.domain.Author;
import com.rushabh.database.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){

    }

    public static Author createAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Rushabh")
                .age(80)
                .build();
    }

    public static Author createAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Thom")
                .age(20)
                .build();
    }
    public static Author createAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Hesse")
                .age(30)
                .build();
    }

    public static Book createThatbookA() {
        return Book.builder()
                .isbn("978-1-2345")
                .title("The Shadow is Attic")
                .authorId(1L).build();
    }
    public static Book createThatbookB() {
        return Book.builder()
                .isbn("978-1-2346")
                .title("Shadow")
                .authorId(1L).build();
    }
    public static Book createThatbookC() {
        return Book.builder()
                .isbn("978-1-2347")
                .title("ALONE")
                .authorId(1L).build();
    }
}
