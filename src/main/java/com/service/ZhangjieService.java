package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhangjieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhangjieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhangjieView;


/**
 * 章节
 *
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
public interface ZhangjieService extends IService<ZhangjieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhangjieVO> selectListVO(Wrapper<ZhangjieEntity> wrapper);
   	
   	ZhangjieVO selectVO(@Param("ew") Wrapper<ZhangjieEntity> wrapper);
   	
   	List<ZhangjieView> selectListView(Wrapper<ZhangjieEntity> wrapper);
   	
   	ZhangjieView selectView(@Param("ew") Wrapper<ZhangjieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhangjieEntity> wrapper);
   	

}

