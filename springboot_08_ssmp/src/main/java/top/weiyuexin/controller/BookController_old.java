package top.weiyuexin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.weiyuexin.domain.Book;
import top.weiyuexin.service.IBookService;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController_old {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }
    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.modify(book);
    }
    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable("id") Integer id){
        return bookService.deleteById(id);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable("id") Integer id){
        return bookService.getById(id);
    }

    //分页
    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable("currentPage") Integer currentPage,
                               @PathVariable("pageSize") Integer pageSize){
        return bookService.getPage(currentPage,pageSize, null);
    }

}
