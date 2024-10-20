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

import com.entity.ZhanneixinwenEntity;
import com.entity.view.ZhanneixinwenView;

import com.service.ZhanneixinwenService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 站内新闻
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
@RestController
@RequestMapping("/zhanneixinwen")
public class ZhanneixinwenController {
    @Autowired
    private ZhanneixinwenService zhanneixinwenService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhanneixinwenEntity zhanneixinwen,
		HttpServletRequest request){
        EntityWrapper<ZhanneixinwenEntity> ew = new EntityWrapper<ZhanneixinwenEntity>();

		PageUtils page = zhanneixinwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhanneixinwen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhanneixinwenEntity zhanneixinwen, 
		HttpServletRequest request){
        EntityWrapper<ZhanneixinwenEntity> ew = new EntityWrapper<ZhanneixinwenEntity>();

		PageUtils page = zhanneixinwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhanneixinwen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhanneixinwenEntity zhanneixinwen){
       	EntityWrapper<ZhanneixinwenEntity> ew = new EntityWrapper<ZhanneixinwenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhanneixinwen, "zhanneixinwen")); 
        return R.ok().put("data", zhanneixinwenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhanneixinwenEntity zhanneixinwen){
        EntityWrapper< ZhanneixinwenEntity> ew = new EntityWrapper< ZhanneixinwenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhanneixinwen, "zhanneixinwen")); 
		ZhanneixinwenView zhanneixinwenView =  zhanneixinwenService.selectView(ew);
		return R.ok("查询站内新闻成功").put("data", zhanneixinwenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhanneixinwenEntity zhanneixinwen = zhanneixinwenService.selectById(id);
        return R.ok().put("data", zhanneixinwen);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhanneixinwenEntity zhanneixinwen = zhanneixinwenService.selectById(id);
        return R.ok().put("data", zhanneixinwen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhanneixinwenEntity zhanneixinwen, HttpServletRequest request){
    	zhanneixinwen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhanneixinwen);
        zhanneixinwenService.insert(zhanneixinwen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhanneixinwenEntity zhanneixinwen, HttpServletRequest request){
    	zhanneixinwen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhanneixinwen);
        zhanneixinwenService.insert(zhanneixinwen);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhanneixinwenEntity zhanneixinwen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhanneixinwen);
        zhanneixinwenService.updateById(zhanneixinwen);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhanneixinwenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
