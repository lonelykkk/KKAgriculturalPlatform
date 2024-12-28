package com.dao;

import com.entity.NongchanpinCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.NongchanpinCollectionView;

/**
 * 农产品收藏 Dao 接口
 *
 * @author 
 */
public interface NongchanpinCollectionDao extends BaseMapper<NongchanpinCollectionEntity> {

   List<NongchanpinCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
