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

import com.entity.XiaoshuopingfenEntity;
import com.entity.view.XiaoshuopingfenView;

import com.service.XiaoshuopingfenService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 小说评分
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
@RestController
@RequestMapping("/xiaoshuopingfen")
public class XiaoshuopingfenController {
    @Autowired
    private XiaoshuopingfenService xiaoshuopingfenService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiaoshuopingfenEntity xiaoshuopingfen,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huiyuan")) {
			xiaoshuopingfen.setHuiyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiaoshuopingfenEntity> ew = new EntityWrapper<XiaoshuopingfenEntity>();

		PageUtils page = xiaoshuopingfenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoshuopingfen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiaoshuopingfenEntity xiaoshuopingfen, 
		HttpServletRequest request){
        EntityWrapper<XiaoshuopingfenEntity> ew = new EntityWrapper<XiaoshuopingfenEntity>();

		PageUtils page = xiaoshuopingfenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoshuopingfen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaoshuopingfenEntity xiaoshuopingfen){
       	EntityWrapper<XiaoshuopingfenEntity> ew = new EntityWrapper<XiaoshuopingfenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaoshuopingfen, "xiaoshuopingfen")); 
        return R.ok().put("data", xiaoshuopingfenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaoshuopingfenEntity xiaoshuopingfen){
        EntityWrapper< XiaoshuopingfenEntity> ew = new EntityWrapper< XiaoshuopingfenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaoshuopingfen, "xiaoshuopingfen")); 
		XiaoshuopingfenView xiaoshuopingfenView =  xiaoshuopingfenService.selectView(ew);
		return R.ok("查询小说评分成功").put("data", xiaoshuopingfenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaoshuopingfenEntity xiaoshuopingfen = xiaoshuopingfenService.selectById(id);
        return R.ok().put("data", xiaoshuopingfen);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaoshuopingfenEntity xiaoshuopingfen = xiaoshuopingfenService.selectById(id);
        return R.ok().put("data", xiaoshuopingfen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiaoshuopingfenEntity xiaoshuopingfen, HttpServletRequest request){
    	xiaoshuopingfen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaoshuopingfen);
        xiaoshuopingfenService.insert(xiaoshuopingfen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiaoshuopingfenEntity xiaoshuopingfen, HttpServletRequest request){
    	xiaoshuopingfen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaoshuopingfen);
        xiaoshuopingfenService.insert(xiaoshuopingfen);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiaoshuopingfenEntity xiaoshuopingfen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiaoshuopingfen);
        xiaoshuopingfenService.updateById(xiaoshuopingfen);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiaoshuopingfenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
