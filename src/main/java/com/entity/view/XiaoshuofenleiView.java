package com.entity.view;

import com.entity.XiaoshuofenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 小说分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
@TableName("xiaoshuofenlei")
public class XiaoshuofenleiView  extends XiaoshuofenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiaoshuofenleiView(){
	}
 
 	public XiaoshuofenleiView(XiaoshuofenleiEntity xiaoshuofenleiEntity){
 	try {
			BeanUtils.copyProperties(this, xiaoshuofenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
