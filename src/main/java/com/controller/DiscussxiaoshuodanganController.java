package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussxiaoshuodanganEntity;
import com.entity.view.DiscussxiaoshuodanganView;

import com.service.DiscussxiaoshuodanganService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 小说档案评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
@RestController
@RequestMapping("/discussxiaoshuodangan")
public class DiscussxiaoshuodanganController {
    @Autowired
    private DiscussxiaoshuodanganService discussxiaoshuodanganService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussxiaoshuodanganEntity discussxiaoshuodangan,
		HttpServletRequest request){
        EntityWrapper<DiscussxiaoshuodanganEntity> ew = new EntityWrapper<DiscussxiaoshuodanganEntity>();

		PageUtils page = discussxiaoshuodanganService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxiaoshuodangan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussxiaoshuodanganEntity discussxiaoshuodangan, 
		HttpServletRequest request){
        EntityWrapper<DiscussxiaoshuodanganEntity> ew = new EntityWrapper<DiscussxiaoshuodanganEntity>();

		PageUtils page = discussxiaoshuodanganService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxiaoshuodangan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussxiaoshuodanganEntity discussxiaoshuodangan){
       	EntityWrapper<DiscussxiaoshuodanganEntity> ew = new EntityWrapper<DiscussxiaoshuodanganEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussxiaoshuodangan, "discussxiaoshuodangan")); 
        return R.ok().put("data", discussxiaoshuodanganService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussxiaoshuodanganEntity discussxiaoshuodangan){
        EntityWrapper< DiscussxiaoshuodanganEntity> ew = new EntityWrapper< DiscussxiaoshuodanganEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussxiaoshuodangan, "discussxiaoshuodangan")); 
		DiscussxiaoshuodanganView discussxiaoshuodanganView =  discussxiaoshuodanganService.selectView(ew);
		return R.ok("查询小说档案评论表成功").put("data", discussxiaoshuodanganView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussxiaoshuodanganEntity discussxiaoshuodangan = discussxiaoshuodanganService.selectById(id);
        return R.ok().put("data", discussxiaoshuodangan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussxiaoshuodanganEntity discussxiaoshuodangan = discussxiaoshuodanganService.selectById(id);
        return R.ok().put("data", discussxiaoshuodangan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussxiaoshuodanganEntity discussxiaoshuodangan, HttpServletRequest request){
    	discussxiaoshuodangan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxiaoshuodangan);
        discussxiaoshuodanganService.insert(discussxiaoshuodangan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussxiaoshuodanganEntity discussxiaoshuodangan, HttpServletRequest request){
    	discussxiaoshuodangan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxiaoshuodangan);
        discussxiaoshuodanganService.insert(discussxiaoshuodangan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussxiaoshuodanganEntity discussxiaoshuodangan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussxiaoshuodangan);
        discussxiaoshuodanganService.updateById(discussxiaoshuodangan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussxiaoshuodanganService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
