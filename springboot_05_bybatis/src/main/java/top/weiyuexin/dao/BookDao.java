package top.weiyuexin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.weiyuexin.domain.Book;
@Mapper
public interface BookDao {
    @Select("select * from book where id = #{id}")
    public Book getById(Integer id);
}
