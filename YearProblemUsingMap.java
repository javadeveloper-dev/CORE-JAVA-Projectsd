import java.util.*;


public class YearProblemUsingMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the no. of inputs  ");
		Scanner readInput = new Scanner(System.in);
		int no_of_inputs = readInput.nextInt();
		int i, j, k;
		int test_case_count = 1;
		int birth_year[] = new int[no_of_inputs];
		int death_year[] = new int[no_of_inputs];
		int bd_year[] = new int[no_of_inputs * 2];
		int size;
		int max_year = 0;
		Map<Integer, Integer> year_count = new LinkedHashMap<>();
		
		while (test_case_count < no_of_inputs) {
			for (i = 0; i < no_of_inputs; i++) {
				birth_year[i] = readInput.nextInt();

				death_year[i] = readInput.nextInt();

				bd_year[i] = birth_year[i];
				bd_year[i + no_of_inputs] = death_year[i];
				test_case_count++;
			}
		}

		System.out.println("\nBirth Year and Death Year along with Count ");
		for (i = 0; i < bd_year.length; i++) {
			int count = 0;
			for (j = 0; j < birth_year.length; j++) {
				if (bd_year[i] >= birth_year[j] && bd_year[i] <= death_year[j]) {
					count = count + 1;
					year_count.put(bd_year[i],count );
				}
			}
		}
		
		int max_Count=year_count.get(bd_year[0]);
		for(i=1;i<bd_year.length;i++)
		{
			if(year_count.get(bd_year[i])>=max_Count)
			{
				max_Count=year_count.get(bd_year[i]);
				max_year=bd_year[i];
			}
			
		}
		System.out.println("Latest Year is "+max_year+" and Count is "+max_Count);
		}
}

