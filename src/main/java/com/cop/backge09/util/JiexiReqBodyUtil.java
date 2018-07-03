package com.cop.backge09.util;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;

public class JiexiReqBodyUtil<T> {
	/**
	 * 解析HttpServletRequest中的body数据
	 * @param request
	 * @param clazz
	 * @return
	 */
	public T JiexiBody(HttpServletRequest request, Class<T> clazz){
		try {
			BufferedReader br = request.getReader();

			String str, body = "";
			while((str = br.readLine()) != null){
				body += str;
			}
			T t = JSON.parseObject(body, clazz);
			
			return t;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public T JiexiJson(String json, Class<T> clazz){
		try {
			if (json == null || json.equals("")) {
				return null;
			}
			
			T t = JSON.parseObject(json, clazz);
			
			return t;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
