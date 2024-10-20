package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiaoshuodanganEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiaoshuodanganVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoshuodanganView;


/**
 * 小说档案
 *
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
public interface XiaoshuodanganService extends IService<XiaoshuodanganEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoshuodanganVO> selectListVO(Wrapper<XiaoshuodanganEntity> wrapper);
   	
   	XiaoshuodanganVO selectVO(@Param("ew") Wrapper<XiaoshuodanganEntity> wrapper);
   	
   	List<XiaoshuodanganView> selectListView(Wrapper<XiaoshuodanganEntity> wrapper);
   	
   	XiaoshuodanganView selectView(@Param("ew") Wrapper<XiaoshuodanganEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoshuodanganEntity> wrapper);
   	

}

