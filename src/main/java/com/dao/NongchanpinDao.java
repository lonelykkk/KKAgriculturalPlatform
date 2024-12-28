package com.dao;

import com.entity.NongchanpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.NongchanpinView;

/**
 * 农产品 Dao 接口
 *
 * @author 
 */
public interface NongchanpinDao extends BaseMapper<NongchanpinEntity> {

   List<NongchanpinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
