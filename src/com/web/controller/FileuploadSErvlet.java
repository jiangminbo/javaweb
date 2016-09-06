package com.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileuploadSErvlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//创建文件处理工厂对象
		DiskFileItemFactory dff=new DiskFileItemFactory();
		//创建文件上传处理工具
		ServletFileUpload sfu=new ServletFileUpload();
		

		Random random=new Random();//随机数
		int  i=random.nextInt(10000);//
		long l=new Date().getTime();//
		
		
	}
	
}
