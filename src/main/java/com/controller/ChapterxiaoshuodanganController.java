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

import com.entity.ChapterxiaoshuodanganEntity;
import com.entity.view.ChapterxiaoshuodanganView;

import com.service.ChapterxiaoshuodanganService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 小说档案章节表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
@RestController
@RequestMapping("/chapterxiaoshuodangan")
public class ChapterxiaoshuodanganController {
    @Autowired
    private ChapterxiaoshuodanganService chapterxiaoshuodanganService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChapterxiaoshuodanganEntity chapterxiaoshuodangan,
		HttpServletRequest request){
        EntityWrapper<ChapterxiaoshuodanganEntity> ew = new EntityWrapper<ChapterxiaoshuodanganEntity>();

		PageUtils page = chapterxiaoshuodanganService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chapterxiaoshuodangan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChapterxiaoshuodanganEntity chapterxiaoshuodangan, 
		HttpServletRequest request){
        EntityWrapper<ChapterxiaoshuodanganEntity> ew = new EntityWrapper<ChapterxiaoshuodanganEntity>();

		PageUtils page = chapterxiaoshuodanganService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chapterxiaoshuodangan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChapterxiaoshuodanganEntity chapterxiaoshuodangan){
       	EntityWrapper<ChapterxiaoshuodanganEntity> ew = new EntityWrapper<ChapterxiaoshuodanganEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chapterxiaoshuodangan, "chapterxiaoshuodangan")); 
        return R.ok().put("data", chapterxiaoshuodanganService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChapterxiaoshuodanganEntity chapterxiaoshuodangan){
        EntityWrapper< ChapterxiaoshuodanganEntity> ew = new EntityWrapper< ChapterxiaoshuodanganEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chapterxiaoshuodangan, "chapterxiaoshuodangan")); 
		ChapterxiaoshuodanganView chapterxiaoshuodanganView =  chapterxiaoshuodanganService.selectView(ew);
		return R.ok("查询小说档案章节表成功").put("data", chapterxiaoshuodanganView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChapterxiaoshuodanganEntity chapterxiaoshuodangan = chapterxiaoshuodanganService.selectById(id);
        return R.ok().put("data", chapterxiaoshuodangan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChapterxiaoshuodanganEntity chapterxiaoshuodangan = chapterxiaoshuodanganService.selectById(id);
        return R.ok().put("data", chapterxiaoshuodangan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChapterxiaoshuodanganEntity chapterxiaoshuodangan, HttpServletRequest request){
    	chapterxiaoshuodangan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chapterxiaoshuodangan);
        chapterxiaoshuodanganService.insert(chapterxiaoshuodangan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChapterxiaoshuodanganEntity chapterxiaoshuodangan, HttpServletRequest request){
    	chapterxiaoshuodangan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chapterxiaoshuodangan);
        chapterxiaoshuodanganService.insert(chapterxiaoshuodangan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChapterxiaoshuodanganEntity chapterxiaoshuodangan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chapterxiaoshuodangan);
        chapterxiaoshuodanganService.updateById(chapterxiaoshuodangan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chapterxiaoshuodanganService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
