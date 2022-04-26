package top.weiyuexin.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.weiyuexin.domain.Book;
import top.weiyuexin.mapper.BookMapper;

@SpringBootTest
public class BookMapperTestCase {
    @Autowired
    private BookMapper bookMapper;
    @Test
    void testGetById(){
        System.out.println(bookMapper.selectById(3));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setName("汤家凤2023考研高数辅导书");
        book.setType("考研");
        book.setDescription("2023考研高数汤家凤");
        bookMapper.insert(book);
    }
}
