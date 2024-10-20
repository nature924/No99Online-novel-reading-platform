package com.dao;

import com.entity.XiaoshuofenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiaoshuofenleiVO;
import com.entity.view.XiaoshuofenleiView;


/**
 * 小说分类
 * 
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
public interface XiaoshuofenleiDao extends BaseMapper<XiaoshuofenleiEntity> {
	
	List<XiaoshuofenleiVO> selectListVO(@Param("ew") Wrapper<XiaoshuofenleiEntity> wrapper);
	
	XiaoshuofenleiVO selectVO(@Param("ew") Wrapper<XiaoshuofenleiEntity> wrapper);
	
	List<XiaoshuofenleiView> selectListView(@Param("ew") Wrapper<XiaoshuofenleiEntity> wrapper);

	List<XiaoshuofenleiView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoshuofenleiEntity> wrapper);
	
	XiaoshuofenleiView selectView(@Param("ew") Wrapper<XiaoshuofenleiEntity> wrapper);
	

}
