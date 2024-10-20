package com.dao;

import com.entity.XiaoshuopingfenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiaoshuopingfenVO;
import com.entity.view.XiaoshuopingfenView;


/**
 * 小说评分
 * 
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
public interface XiaoshuopingfenDao extends BaseMapper<XiaoshuopingfenEntity> {
	
	List<XiaoshuopingfenVO> selectListVO(@Param("ew") Wrapper<XiaoshuopingfenEntity> wrapper);
	
	XiaoshuopingfenVO selectVO(@Param("ew") Wrapper<XiaoshuopingfenEntity> wrapper);
	
	List<XiaoshuopingfenView> selectListView(@Param("ew") Wrapper<XiaoshuopingfenEntity> wrapper);

	List<XiaoshuopingfenView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoshuopingfenEntity> wrapper);
	
	XiaoshuopingfenView selectView(@Param("ew") Wrapper<XiaoshuopingfenEntity> wrapper);
	

}
