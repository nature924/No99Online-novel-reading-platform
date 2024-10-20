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


import com.dao.ChapterxiaoshuodanganDao;
import com.entity.ChapterxiaoshuodanganEntity;
import com.service.ChapterxiaoshuodanganService;
import com.entity.vo.ChapterxiaoshuodanganVO;
import com.entity.view.ChapterxiaoshuodanganView;

@Service("chapterxiaoshuodanganService")
public class ChapterxiaoshuodanganServiceImpl extends ServiceImpl<ChapterxiaoshuodanganDao, ChapterxiaoshuodanganEntity> implements ChapterxiaoshuodanganService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChapterxiaoshuodanganEntity> page = this.selectPage(
                new Query<ChapterxiaoshuodanganEntity>(params).getPage(),
                new EntityWrapper<ChapterxiaoshuodanganEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChapterxiaoshuodanganEntity> wrapper) {
		  Page<ChapterxiaoshuodanganView> page =new Query<ChapterxiaoshuodanganView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChapterxiaoshuodanganVO> selectListVO(Wrapper<ChapterxiaoshuodanganEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChapterxiaoshuodanganVO selectVO(Wrapper<ChapterxiaoshuodanganEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChapterxiaoshuodanganView> selectListView(Wrapper<ChapterxiaoshuodanganEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChapterxiaoshuodanganView selectView(Wrapper<ChapterxiaoshuodanganEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
