package com.dao;

import com.entity.ZhanneixinwenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhanneixinwenVO;
import com.entity.view.ZhanneixinwenView;


/**
 * 站内新闻
 * 
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
public interface ZhanneixinwenDao extends BaseMapper<ZhanneixinwenEntity> {
	
	List<ZhanneixinwenVO> selectListVO(@Param("ew") Wrapper<ZhanneixinwenEntity> wrapper);
	
	ZhanneixinwenVO selectVO(@Param("ew") Wrapper<ZhanneixinwenEntity> wrapper);
	
	List<ZhanneixinwenView> selectListView(@Param("ew") Wrapper<ZhanneixinwenEntity> wrapper);

	List<ZhanneixinwenView> selectListView(Pagination page,@Param("ew") Wrapper<ZhanneixinwenEntity> wrapper);
	
	ZhanneixinwenView selectView(@Param("ew") Wrapper<ZhanneixinwenEntity> wrapper);
	

}
