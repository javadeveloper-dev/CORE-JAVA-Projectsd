package com.org;
import java.text.DecimalFormat;
import java.util.*;
public class FractionalKnapSack {

	public static void main(String[] args) {
		System.out.print("Enter the Total Number of Objects\n");  // Total No of Objects 
		Scanner read_input=new Scanner(System.in);
		int total_no_of_objects=read_input.nextInt();
		
		int i,j,k;
		float profit[]=new float[total_no_of_objects];
		System.out.println("Enter the Profits of Objects");         // Total No. of Profit
		for(i=0;i<total_no_of_objects;i++)
		{
			profit[i]=read_input.nextInt();
		}
		float weight[]=new float[total_no_of_objects];
		System.out.println("Enter the Weight of Objects");        // Total No. of Weight
		for(i=0;i<total_no_of_objects;i++)
		{
			weight[i]=read_input.nextInt();
		}
		
		float profit_by_weight_ratio[]=new float[total_no_of_objects];
		
		for(i=0;i<profit_by_weight_ratio.length;i++)
		{
			profit_by_weight_ratio[i]=profit[i]/weight[i];
		}
//		System.out.println("Enter the Capacity of Sack ");
//		int capacity_of_sack=read_input.nextInt();
		
		System.out.println("Profit By Weight(P/W) ratio ");   // Profit By Weight Ratio
		for(i=0;i<profit_by_weight_ratio.length;i++)
		{
			System.out.print(profit_by_weight_ratio[i]+" ");
		}
		
//		System.out.println("Enter the Capacity of Bag ");
//		int capacity_of_bag=read_input.nextInt();
//		
//		for(i=0;i<profit_by_weight_ratio.length;i++)
//		{
//			System.out.print(profit_by_weight_ratio[i]+" ");
//		}
		
		float temporary_variable=0;
		for(i=0;i<profit_by_weight_ratio.length;i++)
		{
			for(j=i+1;j<profit_by_weight_ratio.length;j++)
			{
				if(profit_by_weight_ratio[i]<profit_by_weight_ratio[j]) //|| weight[i]<weight[j]
				{
					temporary_variable=profit_by_weight_ratio[i];
					profit_by_weight_ratio[i]=profit_by_weight_ratio[j];
					profit_by_weight_ratio[j]=temporary_variable;
					
					temporary_variable=weight[i];
					weight[i]=weight[j];                     // Swapping for Weight in Descending Order
					weight[j]=temporary_variable;
					
					temporary_variable=profit[i];
					profit[i]=profit[j];                      // Swapping for Profit in Descending Order
					profit[j]=temporary_variable;
					
					
				}
			}
		}
		
		System.out.println("\nProfit By Weight(P/W) ratio  in Descending Order ");   // Profit By Weight Ratio in descending Order
		for(i=0;i<profit_by_weight_ratio.length;i++)
		{
			System.out.print(profit_by_weight_ratio[i]+" ");
			 
		}
		
		System.out.println("\nAssociated Weights are "); // Associated Weights(Descending Order)
		for(i=0;i<weight.length;i++)
		{
			System.out.print(weight[i]+" ");
		}
		
		System.out.println("\nAssociated Profit are "); // Associated Profit are (Descending Order)
		for(i=0;i<profit.length;i++)
		{
			System.out.print(profit[i]+" ");
		}
		
		
		System.out.println("\nEnter the Capacity of Bag ");  // Capacity of Bag
		float capacity_of_bag=read_input.nextInt();
		
		float copy_capacity_of_bag=capacity_of_bag;
//		
//		float[] items_filled_in_bag=new float[weight.length];
//		
		float counter[]=new float[weight.length];
//		float total_profit=0.0f;
//		float total_weight=0.0f;
//		float subtracted_weight=0.0f;
		for(i=0;i<total_no_of_objects;i++)
		{
			System.out.println(weight[i]);
			
			if(copy_capacity_of_bag>weight[i])
			{
				copy_capacity_of_bag=copy_capacity_of_bag-weight[i];
				counter[i]++;
			}
			else if(copy_capacity_of_bag<weight[i] && copy_capacity_of_bag!=0.0f)
			{
                 counter[i]=copy_capacity_of_bag/weight[i];	
                 break;
			}
			else
			{
				counter[i]=0.0f;
			}
				
		}
          for(i=0;i<counter.length;i++)
          {
        	  System.out.print(counter[i]+" ");
          }
          float max_profit=0.0f;
          for(i=0;i<total_no_of_objects;i++)
          {
        	  max_profit+=(counter[i]*profit[i]);
      	 }
          System.out.println("\nMaximum Profit is "+max_profit);
          }
          

}
