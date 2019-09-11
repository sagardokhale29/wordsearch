package com.example.demo.repository;
import java.util.HashMap;
import org.springframework.stereotype.Repository;

@Repository
public class WordRepository {

HashMap<String,Integer> wordMap=new HashMap<>();
	
public void addWordToMap(String word) {

	if(wordMap.containsKey(word)) {
		wordMap.put(word,wordMap.get(word)+1);
	}else {
		wordMap.put(word,1);
		
		StringBuffer sb=new StringBuffer("Sagar");
		String str=new String("Sagar");
	}
}

public boolean isWordPresent(String word) {
		if (wordMap.containsKey(word))
			return true;
		else
			return false;
}


}
