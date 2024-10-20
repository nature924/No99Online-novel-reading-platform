package com.entity.view;

import com.entity.ZhanneixinwenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 站内新闻
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
@TableName("zhanneixinwen")
public class ZhanneixinwenView  extends ZhanneixinwenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhanneixinwenView(){
	}
 
 	public ZhanneixinwenView(ZhanneixinwenEntity zhanneixinwenEntity){
 	try {
			BeanUtils.copyProperties(this, zhanneixinwenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
