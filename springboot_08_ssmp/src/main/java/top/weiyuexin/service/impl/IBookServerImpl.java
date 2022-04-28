package top.weiyuexin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.weiyuexin.domain.Book;
import top.weiyuexin.mapper.BookMapper;
import top.weiyuexin.service.IBookService;
@Service
public class IBookServerImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public Boolean saveBook(Book book) {
        return bookMapper.insert(book)>0;
    }

    @Override
    public Boolean modify(Book book) {
        return bookMapper.updateById(book)>0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return bookMapper.deleteById(id)>0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> ipage = new Page<>(currentPage,pageSize);
        bookMapper.selectPage(ipage,null);
        return ipage;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        IPage<Book> ipage = new Page<>(currentPage,pageSize);
        bookMapper.selectPage(ipage,lqw);
        return ipage;
    }
}
