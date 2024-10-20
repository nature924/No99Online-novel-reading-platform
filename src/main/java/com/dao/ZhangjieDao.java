package com.dao;

import com.entity.ZhangjieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhangjieVO;
import com.entity.view.ZhangjieView;


/**
 * 章节
 * 
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
public interface ZhangjieDao extends BaseMapper<ZhangjieEntity> {
	
	List<ZhangjieVO> selectListVO(@Param("ew") Wrapper<ZhangjieEntity> wrapper);
	
	ZhangjieVO selectVO(@Param("ew") Wrapper<ZhangjieEntity> wrapper);
	
	List<ZhangjieView> selectListView(@Param("ew") Wrapper<ZhangjieEntity> wrapper);

	List<ZhangjieView> selectListView(Pagination page,@Param("ew") Wrapper<ZhangjieEntity> wrapper);
	
	ZhangjieView selectView(@Param("ew") Wrapper<ZhangjieEntity> wrapper);
	

}
