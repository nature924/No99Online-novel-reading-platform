package com.dao;

import com.entity.XiaoshuodanganEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiaoshuodanganVO;
import com.entity.view.XiaoshuodanganView;


/**
 * 小说档案
 * 
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
public interface XiaoshuodanganDao extends BaseMapper<XiaoshuodanganEntity> {
	
	List<XiaoshuodanganVO> selectListVO(@Param("ew") Wrapper<XiaoshuodanganEntity> wrapper);
	
	XiaoshuodanganVO selectVO(@Param("ew") Wrapper<XiaoshuodanganEntity> wrapper);
	
	List<XiaoshuodanganView> selectListView(@Param("ew") Wrapper<XiaoshuodanganEntity> wrapper);

	List<XiaoshuodanganView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoshuodanganEntity> wrapper);
	
	XiaoshuodanganView selectView(@Param("ew") Wrapper<XiaoshuodanganEntity> wrapper);
	

}
