package secao19_ex02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter file full path: ");
		String sourcePath = sc.nextLine();
		
		Map<String,Integer> votos = new HashMap<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(sourcePath))){
			
			
			String line = br.readLine();
			
			while(line != null) {
				
				String[] fields = line.split(",");
				String name = fields[0];
				int qntVot = Integer.parseInt(fields[1]);
				
				if(votos.containsKey(name)) {
					int contVotos = votos.get(name);
					votos.put(name,(qntVot + contVotos));
				} else {
					votos.put(name,qntVot);
				}
				
				line = br.readLine();
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("Alex Blue: ");
		System.out.println(votos.get("Alex Blue"));
		
		System.out.print("Maria Green: ");
		System.out.println(votos.get("Maria Green"));
		
		System.out.print("Bob Brown: ");
		System.out.println(votos.get("Bob Brown"));
		
		
		sc.close();

	}

}
