package appCode;

public class SampleCode {
	
	public int sumNumbers(int a, int b) {
		return a + b;
	}
	
	public String addStrings(String a, String b) {
		return a + " " + b;
	}
	
	public int[] getArray() {
		int[] arrayExample = {1, 2, 3};
		return arrayExample;
	}
	
	public boolean isEvenNumber(int number) {
		
		boolean result = false;
		if(number%2 == 0){
			result = true;
		}
		return result;
	}
}