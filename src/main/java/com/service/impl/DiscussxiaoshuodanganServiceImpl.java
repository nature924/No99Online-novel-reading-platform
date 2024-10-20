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


import com.dao.DiscussxiaoshuodanganDao;
import com.entity.DiscussxiaoshuodanganEntity;
import com.service.DiscussxiaoshuodanganService;
import com.entity.vo.DiscussxiaoshuodanganVO;
import com.entity.view.DiscussxiaoshuodanganView;

@Service("discussxiaoshuodanganService")
public class DiscussxiaoshuodanganServiceImpl extends ServiceImpl<DiscussxiaoshuodanganDao, DiscussxiaoshuodanganEntity> implements DiscussxiaoshuodanganService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxiaoshuodanganEntity> page = this.selectPage(
                new Query<DiscussxiaoshuodanganEntity>(params).getPage(),
                new EntityWrapper<DiscussxiaoshuodanganEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxiaoshuodanganEntity> wrapper) {
		  Page<DiscussxiaoshuodanganView> page =new Query<DiscussxiaoshuodanganView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussxiaoshuodanganVO> selectListVO(Wrapper<DiscussxiaoshuodanganEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussxiaoshuodanganVO selectVO(Wrapper<DiscussxiaoshuodanganEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussxiaoshuodanganView> selectListView(Wrapper<DiscussxiaoshuodanganEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxiaoshuodanganView selectView(Wrapper<DiscussxiaoshuodanganEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
