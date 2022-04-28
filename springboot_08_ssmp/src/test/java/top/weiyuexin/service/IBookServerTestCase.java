package top.weiyuexin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.weiyuexin.domain.Book;

@SpringBootTest
public class IBookServerTestCase {
    @Autowired
    private IBookService service;
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试");
        book.setDescription("测试服务层");
        book.setName("ceshi一下");
        service.save(book);
    }
    @Test
    void testGetById(){
        System.out.println(service.getById(3));
    }
    @Test
    void testGetAll(){
        service.list();
    }
    @Test
    void testDelete(){
        service.removeById(739889168);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(739889168);
        book.setType("测试update");
        book.setDescription("测试服务层update");
        book.setName("ceshi update一下");
        service.updateById(book);
    }

    @Test
    void testGetPage(){
        IPage<Book> ipage = new Page<>(2,5);
        service.page(ipage);
        System.out.println("当前页为: "+ipage.getCurrent());
        System.out.println("每一页的条数 "+ipage.getSize());
        System.out.println("表中数据总条数: "+ipage.getTotal());
        System.out.println("一共的页数: "+ipage.getPages());
        System.out.println("查到的数据: "+ipage.getRecords());
    }
}
