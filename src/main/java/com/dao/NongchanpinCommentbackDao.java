package com.dao;

import com.entity.NongchanpinCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.NongchanpinCommentbackView;

/**
 * 农产品评价 Dao 接口
 *
 * @author 
 */
public interface NongchanpinCommentbackDao extends BaseMapper<NongchanpinCommentbackEntity> {

   List<NongchanpinCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
