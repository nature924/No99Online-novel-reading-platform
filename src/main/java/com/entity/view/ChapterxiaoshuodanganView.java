package com.entity.view;

import com.entity.ChapterxiaoshuodanganEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 小说档案章节表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-14 12:39:43
 */
@TableName("chapterxiaoshuodangan")
public class ChapterxiaoshuodanganView  extends ChapterxiaoshuodanganEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChapterxiaoshuodanganView(){
	}
 
 	public ChapterxiaoshuodanganView(ChapterxiaoshuodanganEntity chapterxiaoshuodanganEntity){
 	try {
			BeanUtils.copyProperties(this, chapterxiaoshuodanganEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
