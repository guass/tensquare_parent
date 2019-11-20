package utils;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
public class PageUtils<T> {

    public  static  <T> PageInfo<T> reverToPage(List<T> list, int size, int page){
        PageHelper.startPage(page,size);
        PageInfo<T> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
