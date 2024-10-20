package com.dao;

import com.entity.ChapterxiaoshuodanganEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChapterxiaoshuodanganVO;
import com.entity.view.ChapterxiaoshuodanganView;


/**
 * 小说档案章节表
 * 
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
public interface ChapterxiaoshuodanganDao extends BaseMapper<ChapterxiaoshuodanganEntity> {
	
	List<ChapterxiaoshuodanganVO> selectListVO(@Param("ew") Wrapper<ChapterxiaoshuodanganEntity> wrapper);
	
	ChapterxiaoshuodanganVO selectVO(@Param("ew") Wrapper<ChapterxiaoshuodanganEntity> wrapper);
	
	List<ChapterxiaoshuodanganView> selectListView(@Param("ew") Wrapper<ChapterxiaoshuodanganEntity> wrapper);

	List<ChapterxiaoshuodanganView> selectListView(Pagination page,@Param("ew") Wrapper<ChapterxiaoshuodanganEntity> wrapper);
	
	ChapterxiaoshuodanganView selectView(@Param("ew") Wrapper<ChapterxiaoshuodanganEntity> wrapper);
	

}
