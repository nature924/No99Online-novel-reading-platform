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

import com.entity.XiaoshuodanganEntity;
import com.entity.view.XiaoshuodanganView;

import com.service.XiaoshuodanganService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 小说档案
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
@RestController
@RequestMapping("/xiaoshuodangan")
public class XiaoshuodanganController {
    @Autowired
    private XiaoshuodanganService xiaoshuodanganService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiaoshuodanganEntity xiaoshuodangan,
		HttpServletRequest request){
        EntityWrapper<XiaoshuodanganEntity> ew = new EntityWrapper<XiaoshuodanganEntity>();

		PageUtils page = xiaoshuodanganService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoshuodangan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiaoshuodanganEntity xiaoshuodangan, 
		HttpServletRequest request){
        EntityWrapper<XiaoshuodanganEntity> ew = new EntityWrapper<XiaoshuodanganEntity>();

		PageUtils page = xiaoshuodanganService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoshuodangan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaoshuodanganEntity xiaoshuodangan){
       	EntityWrapper<XiaoshuodanganEntity> ew = new EntityWrapper<XiaoshuodanganEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaoshuodangan, "xiaoshuodangan")); 
        return R.ok().put("data", xiaoshuodanganService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaoshuodanganEntity xiaoshuodangan){
        EntityWrapper< XiaoshuodanganEntity> ew = new EntityWrapper< XiaoshuodanganEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaoshuodangan, "xiaoshuodangan")); 
		XiaoshuodanganView xiaoshuodanganView =  xiaoshuodanganService.selectView(ew);
		return R.ok("查询小说档案成功").put("data", xiaoshuodanganView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaoshuodanganEntity xiaoshuodangan = xiaoshuodanganService.selectById(id);
		xiaoshuodangan.setClicknum(xiaoshuodangan.getClicknum()+1);
		xiaoshuodangan.setClicktime(new Date());
		xiaoshuodanganService.updateById(xiaoshuodangan);
        return R.ok().put("data", xiaoshuodangan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaoshuodanganEntity xiaoshuodangan = xiaoshuodanganService.selectById(id);
		xiaoshuodangan.setClicknum(xiaoshuodangan.getClicknum()+1);
		xiaoshuodangan.setClicktime(new Date());
		xiaoshuodanganService.updateById(xiaoshuodangan);
        return R.ok().put("data", xiaoshuodangan);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        XiaoshuodanganEntity xiaoshuodangan = xiaoshuodanganService.selectById(id);
        if(type.equals("1")) {
        	xiaoshuodangan.setThumbsupnum(xiaoshuodangan.getThumbsupnum()+1);
        } else {
        	xiaoshuodangan.setCrazilynum(xiaoshuodangan.getCrazilynum()+1);
        }
        xiaoshuodanganService.updateById(xiaoshuodangan);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiaoshuodanganEntity xiaoshuodangan, HttpServletRequest request){
    	xiaoshuodangan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaoshuodangan);
        xiaoshuodanganService.insert(xiaoshuodangan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiaoshuodanganEntity xiaoshuodangan, HttpServletRequest request){
    	xiaoshuodangan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaoshuodangan);
        xiaoshuodanganService.insert(xiaoshuodangan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiaoshuodanganEntity xiaoshuodangan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiaoshuodangan);
        xiaoshuodanganService.updateById(xiaoshuodangan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiaoshuodanganService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,XiaoshuodanganEntity xiaoshuodangan, HttpServletRequest request,String pre){
        EntityWrapper<XiaoshuodanganEntity> ew = new EntityWrapper<XiaoshuodanganEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = xiaoshuodanganService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoshuodangan), params), params));
        return R.ok().put("data", page);
    }









}
