package com.example.SpringBasicCurdOperation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.SpringBasicCurdOperation.dao.VowelsDetails;
import com.example.SpringBasicCurdOperation.entity.Vowels;

@Service
public class VowelsService {

	@Autowired
	private VowelsDetails vowelsDetails;

	public Vowels getCountOfVowelsInString(@PathVariable("name") String name) {
		int noOfSpecialCharacters = 0;
		int noOfVowels = 0;
		Vowels vowels = null;
		Vowels vowReturn = null;
		if (name != null && !name.equals("")) {
			String toLowerCase = name.toLowerCase();
			for (int i = 0; i < toLowerCase.length(); i++) {
				char ch = toLowerCase.charAt(i);
				if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9')) {
					noOfSpecialCharacters++;
				}
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
					System.out.println("saving retieving data" + ch);
					noOfVowels++;
				}
			}
			vowels = new Vowels();
			vowels.setName(name);
			vowels.setCountOfVowels(noOfVowels);
			vowels.setCountOfSplCharacters(noOfSpecialCharacters);
			vowelsDetails.save(vowels);

			Vowels det = vowelsDetails.findByName(name);
			if (det != null) {
				System.out.println("into retieving data");
				vowReturn = new Vowels();
				vowReturn.setName(det.getName());
				System.out.println("into retieving data" + det.getName());
				vowReturn.setCountOfVowels(det.getCountOfVowels());
				vowReturn.setCountOfSplCharacters(det.getCountOfSplCharacters());
			}
		}

		return vowReturn;
	}

}
