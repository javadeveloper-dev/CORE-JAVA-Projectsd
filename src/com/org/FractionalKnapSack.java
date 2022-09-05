package com.org;
import java.util.*;
public class FractionalKnapSack {

	public static void main(String[] args) {
		System.out.print("Enter the Total Number of Objects\n");
		Scanner readInput=new Scanner(System.in);
		int total_no_of_objects=readInput.nextInt();
		int objects[]=new int[total_no_of_objects];
		int i,j,k;
		
		System.out.println("Enter the Objects\n");
		for(i=0;i<total_no_of_objects;i++)
		{
			objects[i]=readInput.nextInt();
		}
		
		int profit[]=new int[total_no_of_objects];
		System.out.println("Enter the Profits\n");
		for(i=0;i<total_no_of_objects;i++)
		{
			profit[i]=readInput.nextInt();
		}
		int weight[]=new int[total_no_of_objects];
		System.out.println("Enter the Weight");
		for(i=0;i<total_no_of_objects;i++)
		{
			weight[i]=readInput.nextInt();
		}
		
		float profit_by_weight_ratio[]=new float[total_no_of_objects];
		for(i=0;i<profit_by_weight_ratio.length;i++)
		{
			profit_by_weight_ratio[i]=profit[i]/weight[i];
		}
		
		System.out.println("Profit By Weight(P/W) ratio ");
		for(i=0;i<profit_by_weight_ratio.length;i++)
		{
			System.out.print(","+profit_by_weight_ratio[i]);
		}
		
		
	}

}
