package com.entity.view;

import com.entity.XiaoshuodanganEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 小说档案
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
@TableName("xiaoshuodangan")
public class XiaoshuodanganView  extends XiaoshuodanganEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiaoshuodanganView(){
	}
 
 	public XiaoshuodanganView(XiaoshuodanganEntity xiaoshuodanganEntity){
 	try {
			BeanUtils.copyProperties(this, xiaoshuodanganEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
