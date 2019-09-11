package com.example.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.repository.WordRepository;

@Service
public class WordService {
	
	@Autowired
	WordRepository wordRepository;
	
	public void uploadFileService(MultipartFile file) throws IOException {
		File newFile=new File(System.getProperty("java.io.tmpdir")+"/"+file.getOriginalFilename());
		file.transferTo(newFile);
		try(BufferedReader br=new BufferedReader(new FileReader(newFile))) {
			
			while(br.read()!=-1 ) {
				
				String str=br.readLine();
				String []arr =null;
				
				if(str!=null) {
					 arr = str.split(" ");
				}
				
				if(arr!=null) {
				for(int i=0;i<arr.length;i++) {
					wordRepository.addWordToMap(arr[i]);
				}
			}
			
			}
			 
		      	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isWordPresentService(String word) {
		// TODO Auto-generated method stub
		return wordRepository.isWordPresent(word);
	}
	
	

}
