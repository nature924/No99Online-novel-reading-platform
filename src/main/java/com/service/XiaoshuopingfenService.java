package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiaoshuopingfenEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiaoshuopingfenVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoshuopingfenView;


/**
 * 小说评分
 *
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
public interface XiaoshuopingfenService extends IService<XiaoshuopingfenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoshuopingfenVO> selectListVO(Wrapper<XiaoshuopingfenEntity> wrapper);
   	
   	XiaoshuopingfenVO selectVO(@Param("ew") Wrapper<XiaoshuopingfenEntity> wrapper);
   	
   	List<XiaoshuopingfenView> selectListView(Wrapper<XiaoshuopingfenEntity> wrapper);
   	
   	XiaoshuopingfenView selectView(@Param("ew") Wrapper<XiaoshuopingfenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoshuopingfenEntity> wrapper);
   	

}

