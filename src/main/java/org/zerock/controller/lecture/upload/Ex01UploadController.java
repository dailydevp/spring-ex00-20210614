package org.zerock.controller.lecture.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/upload")
@Log4j
public class Ex01UploadController {
	/*
	 https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/home.html
	 */
	
	@RequestMapping("/sub01")
	public void method01(String fname, @RequestParam("ufile") MultipartFile file) {
		log.info(fname);
		log.info(file.getOriginalFilename());
		
		String name = "/Users/jooniehyunie/Desktop/study/java/temp/"+ file.getOriginalFilename();
		
		try(
		
		InputStream is = file.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		
		FileOutputStream fos = new FileOutputStream(name);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
				) {
			int len = 1024;
			byte[] b = new byte[len];
			
			int cnt = 0;
			while ((cnt = bis.read(b, 0, len)) != -1) {
				bos.write(b,0, cnt);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}
	
	@PostMapping("/sub02")
	public void method02(MultipartFile file) {
		log.info(file.getOriginalFilename());
		String localFilePath = "/Users/jooniehyunie/Desktop/study/java/temp/" + file.getOriginalFilename();
		
		File localFile = new File(localFilePath);
		
		try {
			file.transferTo(localFile);			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
