package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {


	public static List<String> readCSV(String path){

		List<String> words = new ArrayList<String>();
		File file = new File(path);
		try {
			String line = null;
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			while((line = br.readLine()) != null)
			{

				words.add(line);         
			}


			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words;
	}
	
}
