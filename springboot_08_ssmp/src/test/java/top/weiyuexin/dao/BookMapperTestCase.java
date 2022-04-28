package top.weiyuexin.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    void testGetAll(){
        System.out.println(bookMapper.selectList(null));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setName("汤家凤2023考研高数辅导书");
        book.setType("考研");
        book.setDescription("2023考研高数汤家凤");
        bookMapper.insert(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(739889166);
        book.setType("数学");
        bookMapper.updateById(book);

    }

    @Test
    void testDelete(){
        bookMapper.deleteById(739889166);
    }
    /*测试分页*/
    @Test
    void testGetPage(){
        IPage ipage = new Page(2,5);
        bookMapper.selectPage(ipage,null);
        System.out.println("当前页为: "+ipage.getCurrent());
        System.out.println("每一页的条数 "+ipage.getSize());
        System.out.println("表中数据总条数: "+ipage.getTotal());
        System.out.println("一共的页数: "+ipage.getPages());
        System.out.println("查到的数据: "+ipage.getRecords());
    }
    /*测试条件查询*/
    @Test
    void testGetBy(){
        //1.新建QueryWrapper对象
        QueryWrapper<Book> qw = new QueryWrapper<>();
        //2.条件
        qw.like("type","考研");
        //3.根据条件查询
        bookMapper.selectList(qw);

    }
    @Test
    void testGetBy2(){
        String name=null;
        //1.新建QueryWrapper对象
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        //2.条件
        //if(name!=null) lqw.like(Book::getName,name);   //第一种解决参数为空的办法
        //第二种解决参数为空的方法
        lqw.like(name != null,Book::getName,name);
        //3.根据条件查询
        bookMapper.selectList(lqw);
    }
}
