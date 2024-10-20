package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiaoshuofenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiaoshuofenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoshuofenleiView;


/**
 * 小说分类
 *
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
public interface XiaoshuofenleiService extends IService<XiaoshuofenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoshuofenleiVO> selectListVO(Wrapper<XiaoshuofenleiEntity> wrapper);
   	
   	XiaoshuofenleiVO selectVO(@Param("ew") Wrapper<XiaoshuofenleiEntity> wrapper);
   	
   	List<XiaoshuofenleiView> selectListView(Wrapper<XiaoshuofenleiEntity> wrapper);
   	
   	XiaoshuofenleiView selectView(@Param("ew") Wrapper<XiaoshuofenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoshuofenleiEntity> wrapper);
   	

}

