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


import com.dao.ZhanneixinwenDao;
import com.entity.ZhanneixinwenEntity;
import com.service.ZhanneixinwenService;
import com.entity.vo.ZhanneixinwenVO;
import com.entity.view.ZhanneixinwenView;

@Service("zhanneixinwenService")
public class ZhanneixinwenServiceImpl extends ServiceImpl<ZhanneixinwenDao, ZhanneixinwenEntity> implements ZhanneixinwenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhanneixinwenEntity> page = this.selectPage(
                new Query<ZhanneixinwenEntity>(params).getPage(),
                new EntityWrapper<ZhanneixinwenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhanneixinwenEntity> wrapper) {
		  Page<ZhanneixinwenView> page =new Query<ZhanneixinwenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhanneixinwenVO> selectListVO(Wrapper<ZhanneixinwenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhanneixinwenVO selectVO(Wrapper<ZhanneixinwenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhanneixinwenView> selectListView(Wrapper<ZhanneixinwenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhanneixinwenView selectView(Wrapper<ZhanneixinwenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
