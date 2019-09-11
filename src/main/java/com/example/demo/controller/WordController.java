package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.WordService;

@RestController
@RequestMapping("/dictionary")
public class WordController {
	
	@Autowired
	private WordService wordService;
	
	@PostMapping
	public void uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		wordService.uploadFileService(file);
		 
	}

	@GetMapping("/getword/{input}")
	public ResponseEntity<String> isWordPresent(@PathVariable String input) {
		
		String isPresent=null;
		
		if(wordService.isWordPresentService(input)) {
			isPresent="PRESENT";
		}else {
			isPresent="ABSENT";
		}
		return  new ResponseEntity<>(isPresent,HttpStatus.OK);
		
	}
	

}
