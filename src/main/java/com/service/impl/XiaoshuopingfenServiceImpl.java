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


import com.dao.XiaoshuopingfenDao;
import com.entity.XiaoshuopingfenEntity;
import com.service.XiaoshuopingfenService;
import com.entity.vo.XiaoshuopingfenVO;
import com.entity.view.XiaoshuopingfenView;

@Service("xiaoshuopingfenService")
public class XiaoshuopingfenServiceImpl extends ServiceImpl<XiaoshuopingfenDao, XiaoshuopingfenEntity> implements XiaoshuopingfenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoshuopingfenEntity> page = this.selectPage(
                new Query<XiaoshuopingfenEntity>(params).getPage(),
                new EntityWrapper<XiaoshuopingfenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoshuopingfenEntity> wrapper) {
		  Page<XiaoshuopingfenView> page =new Query<XiaoshuopingfenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiaoshuopingfenVO> selectListVO(Wrapper<XiaoshuopingfenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiaoshuopingfenVO selectVO(Wrapper<XiaoshuopingfenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiaoshuopingfenView> selectListView(Wrapper<XiaoshuopingfenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoshuopingfenView selectView(Wrapper<XiaoshuopingfenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
