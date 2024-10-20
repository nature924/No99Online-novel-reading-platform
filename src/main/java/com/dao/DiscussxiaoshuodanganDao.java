package com.dao;

import com.entity.DiscussxiaoshuodanganEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussxiaoshuodanganVO;
import com.entity.view.DiscussxiaoshuodanganView;


/**
 * 小说档案评论表
 * 
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
public interface DiscussxiaoshuodanganDao extends BaseMapper<DiscussxiaoshuodanganEntity> {
	
	List<DiscussxiaoshuodanganVO> selectListVO(@Param("ew") Wrapper<DiscussxiaoshuodanganEntity> wrapper);
	
	DiscussxiaoshuodanganVO selectVO(@Param("ew") Wrapper<DiscussxiaoshuodanganEntity> wrapper);
	
	List<DiscussxiaoshuodanganView> selectListView(@Param("ew") Wrapper<DiscussxiaoshuodanganEntity> wrapper);

	List<DiscussxiaoshuodanganView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxiaoshuodanganEntity> wrapper);
	
	DiscussxiaoshuodanganView selectView(@Param("ew") Wrapper<DiscussxiaoshuodanganEntity> wrapper);
	

}
