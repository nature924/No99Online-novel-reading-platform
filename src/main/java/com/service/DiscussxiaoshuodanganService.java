package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussxiaoshuodanganEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussxiaoshuodanganVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussxiaoshuodanganView;


/**
 * 小说档案评论表
 *
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
public interface DiscussxiaoshuodanganService extends IService<DiscussxiaoshuodanganEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxiaoshuodanganVO> selectListVO(Wrapper<DiscussxiaoshuodanganEntity> wrapper);
   	
   	DiscussxiaoshuodanganVO selectVO(@Param("ew") Wrapper<DiscussxiaoshuodanganEntity> wrapper);
   	
   	List<DiscussxiaoshuodanganView> selectListView(Wrapper<DiscussxiaoshuodanganEntity> wrapper);
   	
   	DiscussxiaoshuodanganView selectView(@Param("ew") Wrapper<DiscussxiaoshuodanganEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxiaoshuodanganEntity> wrapper);
   	

}

