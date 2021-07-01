import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(50,70,60);
		//op - 3,1,2
		List<Integer> sorted = new ArrayList<Integer>(list);
		Collections.sort(sorted,  Collections.reverseOrder());	
		List<Integer> rank = new ArrayList<Integer>();
		
		
		for(int i = 0; i<list.size(); i++) {
			for(int j=0; j<sorted.size();j++) {
				if(list.get(i)==sorted.get(j)) {
					rank.add(j+1);
				}
			}
			
		}
		
		
		rank.forEach(System.out::println);
		
		

	}

}
