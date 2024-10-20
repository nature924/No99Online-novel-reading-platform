package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChapterxiaoshuodanganEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChapterxiaoshuodanganVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChapterxiaoshuodanganView;


/**
 * 小说档案章节表
 *
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
public interface ChapterxiaoshuodanganService extends IService<ChapterxiaoshuodanganEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChapterxiaoshuodanganVO> selectListVO(Wrapper<ChapterxiaoshuodanganEntity> wrapper);
   	
   	ChapterxiaoshuodanganVO selectVO(@Param("ew") Wrapper<ChapterxiaoshuodanganEntity> wrapper);
   	
   	List<ChapterxiaoshuodanganView> selectListView(Wrapper<ChapterxiaoshuodanganEntity> wrapper);
   	
   	ChapterxiaoshuodanganView selectView(@Param("ew") Wrapper<ChapterxiaoshuodanganEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChapterxiaoshuodanganEntity> wrapper);
   	

}

