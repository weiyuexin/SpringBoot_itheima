package top.weiyuexin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import top.weiyuexin.domain.Book;

public interface IBookService extends IService<Book> {
    /*
    自定义的方法
     */
    Boolean saveBook(Book book);
    Boolean modify(Book book);
    Boolean deleteById(Integer id);
    IPage<Book> getPage(int currentPage, int pageSize);
    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
