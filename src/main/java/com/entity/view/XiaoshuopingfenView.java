package com.entity.view;

import com.entity.XiaoshuopingfenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 小说评分
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
@TableName("xiaoshuopingfen")
public class XiaoshuopingfenView  extends XiaoshuopingfenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiaoshuopingfenView(){
	}
 
 	public XiaoshuopingfenView(XiaoshuopingfenEntity xiaoshuopingfenEntity){
 	try {
			BeanUtils.copyProperties(this, xiaoshuopingfenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
