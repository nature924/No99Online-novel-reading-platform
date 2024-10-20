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


import com.dao.XiaoshuodanganDao;
import com.entity.XiaoshuodanganEntity;
import com.service.XiaoshuodanganService;
import com.entity.vo.XiaoshuodanganVO;
import com.entity.view.XiaoshuodanganView;

@Service("xiaoshuodanganService")
public class XiaoshuodanganServiceImpl extends ServiceImpl<XiaoshuodanganDao, XiaoshuodanganEntity> implements XiaoshuodanganService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoshuodanganEntity> page = this.selectPage(
                new Query<XiaoshuodanganEntity>(params).getPage(),
                new EntityWrapper<XiaoshuodanganEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoshuodanganEntity> wrapper) {
		  Page<XiaoshuodanganView> page =new Query<XiaoshuodanganView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiaoshuodanganVO> selectListVO(Wrapper<XiaoshuodanganEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiaoshuodanganVO selectVO(Wrapper<XiaoshuodanganEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiaoshuodanganView> selectListView(Wrapper<XiaoshuodanganEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoshuodanganView selectView(Wrapper<XiaoshuodanganEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
