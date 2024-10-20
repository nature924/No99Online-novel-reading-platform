package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.XiaoshuofenleiDao;
import com.entity.XiaoshuofenleiEntity;
import com.service.XiaoshuofenleiService;
import com.entity.vo.XiaoshuofenleiVO;
import com.entity.view.XiaoshuofenleiView;

@Service("xiaoshuofenleiService")
public class XiaoshuofenleiServiceImpl extends ServiceImpl<XiaoshuofenleiDao, XiaoshuofenleiEntity> implements XiaoshuofenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoshuofenleiEntity> page = this.selectPage(
                new Query<XiaoshuofenleiEntity>(params).getPage(),
                new EntityWrapper<XiaoshuofenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoshuofenleiEntity> wrapper) {
		  Page<XiaoshuofenleiView> page =new Query<XiaoshuofenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiaoshuofenleiVO> selectListVO(Wrapper<XiaoshuofenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiaoshuofenleiVO selectVO(Wrapper<XiaoshuofenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiaoshuofenleiView> selectListView(Wrapper<XiaoshuofenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoshuofenleiView selectView(Wrapper<XiaoshuofenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
