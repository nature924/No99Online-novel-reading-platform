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


import com.dao.ZhangjieDao;
import com.entity.ZhangjieEntity;
import com.service.ZhangjieService;
import com.entity.vo.ZhangjieVO;
import com.entity.view.ZhangjieView;

@Service("zhangjieService")
public class ZhangjieServiceImpl extends ServiceImpl<ZhangjieDao, ZhangjieEntity> implements ZhangjieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhangjieEntity> page = this.selectPage(
                new Query<ZhangjieEntity>(params).getPage(),
                new EntityWrapper<ZhangjieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhangjieEntity> wrapper) {
		  Page<ZhangjieView> page =new Query<ZhangjieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhangjieVO> selectListVO(Wrapper<ZhangjieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhangjieVO selectVO(Wrapper<ZhangjieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhangjieView> selectListView(Wrapper<ZhangjieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhangjieView selectView(Wrapper<ZhangjieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
