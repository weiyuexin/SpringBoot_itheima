package top.weiyuexin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.weiyuexin.controller.utils.R;
import top.weiyuexin.domain.Book;
import top.weiyuexin.service.BookService;
import top.weiyuexin.service.IBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAllBooks(){
        return new R(true,bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book){
        return new R(bookService.save(book));
    }
    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.modify(book));
    }
    @DeleteMapping("{id}")
    public R delete(@PathVariable("id") Integer id){
        return new R(bookService.deleteById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable("id") Integer id){
        return new R(true,bookService.getById(id));
    }

    //分页
   /* @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable("currentPage") Integer currentPage,
                               @PathVariable("pageSize") Integer pageSize){
        IPage<Book> iPage = bookService.getPage(currentPage,pageSize);
        //如果当前页码值大于当前页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if(currentPage>iPage.getPages()){
            iPage = bookService.getPage((int)iPage.getPages(),pageSize);
        }
        return new R(true,iPage);
    }*/

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable("currentPage") Integer currentPage,
                     @PathVariable("pageSize") Integer pageSize,
                     Book book){
        IPage<Book> iPage = bookService.getPage(currentPage,pageSize,book);
        //如果当前页码值大于当前页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if(currentPage>iPage.getPages()){
            iPage = bookService.getPage((int)iPage.getPages(),pageSize,book);
        }
        return new R(true,iPage);
    }

}
