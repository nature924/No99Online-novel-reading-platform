package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhanneixinwenEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhanneixinwenVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhanneixinwenView;


/**
 * 站内新闻
 *
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
public interface ZhanneixinwenService extends IService<ZhanneixinwenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhanneixinwenVO> selectListVO(Wrapper<ZhanneixinwenEntity> wrapper);
   	
   	ZhanneixinwenVO selectVO(@Param("ew") Wrapper<ZhanneixinwenEntity> wrapper);
   	
   	List<ZhanneixinwenView> selectListView(Wrapper<ZhanneixinwenEntity> wrapper);
   	
   	ZhanneixinwenView selectView(@Param("ew") Wrapper<ZhanneixinwenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhanneixinwenEntity> wrapper);
   	

}

