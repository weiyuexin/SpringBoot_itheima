package top.weiyuexin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//lombok
@Data  // = @Getter+@Setter
public class Book {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String type;
    private String name;
    private String description;
}
