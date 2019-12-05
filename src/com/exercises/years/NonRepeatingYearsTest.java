package com.exercises.years;

import java.util.ArrayList;
import java.util.List;

public class NonRepeatingYearsTest {
	/*Write a program to count the number of years in an inclusive range of years that have no repeated digits.
	For example, 2012 has a repeated digit (2) while 2013 does not. 
	Given the range [1980, 1987], your program would return 7 (1980, 1982, 1983, 1984, 1985, 1986, 1987).*/
	
	class NonRepeatingYears implements ImplementationsInterface{
	
		@Override
		public List<Integer> count (int rmin, int rmax){
			
			List<Integer> numbers = new ArrayList<>();
			for(int i=rmin; i<=rmax; i++){
				if (!hasDuplicateDigits(String.valueOf(i))){
					numbers.add(i);
				}
			}
			
			return numbers;
		}
	} // end class NonRepeatingYears
	
	public NonRepeatingYears getNonRepeatingYearsInstance() {
		return new NonRepeatingYears();
	}
				
	// NOTA COMPLESSITA' TEMPO: algoritmo ha complessità O(|m|) per il primo ciclo for e O(9) = 9*O(1) = O(1) per il secondo ciclo for
	//  -> |m| =  lunghezza del numero intesa come il numero di cifre e e 
	// quindi algoritmo ha coplessita' temporale = O(|m|) ovvero lineare nel numero di cifre che compongono il numero
	//
	// NOTA COMPLESSITA' SPAZIO: algoritmo ha complessità O(|10|) = 10*O(1) = O(1) per quando rigurda l'array dei contatori
	// quindi algoritmo ha coplessita' spaziale = O(1) ovvero costante.
	private boolean hasDuplicateDigits(String number){
		
		// assumo che non ci siano duplicati nel numero che passo come argomento
		boolean duplicates = false;
		
		// dichiaro ed instanzio un oggetto array di interu con 9 entry inizializzate tutte con valore 0
		int count[] = new int[10];
		
		// fintanto che non ho scandito tutte le cifre del numero
		for(int i=0; i<number.length(); i++){   
			// estraggo la cifra i-esima
			char currenDigit = number.charAt(i);
			
			// incremento il relativo contatore per quella cifra
			switch(currenDigit)
			{
				case '0':{ count[0]++; break; }
				case '1':{ count[1]++; break; }
				case '2':{ count[2]++; break; }
				case '3':{ count[3]++; break; }
				case '4':{ count[4]++; break; }
				case '5':{ count[5]++; break; }
				case '6':{ count[6]++; break; }
				case '7':{ count[7]++; break; }
				case '8':{ count[8]++; break; }
				case '9':{ count[9]++; break; }
				default:{break;}
			}
		}
		
		for(int i=0; i<count.length; i++){
			if(count[i] > 1){ 
				duplicates = true;
				break;
			}
		}
		
		return duplicates;
	}
	
	
	public static void main (String[] args) throws Exception {
//		int range_min = 2000 ;
//		int range_max = 2010 ;
//		int range_min = 1980 ;
//		int range_max = 1985 ;
//		int range_min = 980 ;
//		int range_max = 985 ;
		int range_min = 1900 ;
		int range_max = 2000 ;
		NonRepeatingYearsTest nonRepeatingYearsTest = new NonRepeatingYearsTest();
		NonRepeatingYears nonRepeatingYears = nonRepeatingYearsTest.getNonRepeatingYearsInstance();
		List<Integer> years = nonRepeatingYears.count(range_min, range_max);
		System.out.println("From " + range_min + " to " + range_max + " there are " + years.size() + " of years with no repeated digits");
		System.out.println(years);
	}
}
