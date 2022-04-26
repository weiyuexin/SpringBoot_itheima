package top.weiyuexin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.weiyuexin.domain.Book;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
