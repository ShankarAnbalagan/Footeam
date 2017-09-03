package com.example.android.footeamsv1;

/**
 * Created by Shankar on 02-09-2017.
 */

public class Sorter extends RandomRange {
    int random_order[]=new int[20];
    int random_order_a[]=new int[10];
    int random_order_b[]=new int[10];
    public void sorterFunction(int n)
    {

        int num=0,i,j,flag=0;
        for(i=0;i<n;i++){
            num=randnum(0,n-1);
            do{
                flag=0;
                for(j=0;j<i;j++)
                {
                    if(random_order[j]!=num)
                        flag++;
                    else{
                        num=randnum(0,(n-1));
                        break;
                    }
                }
            }while(flag!=(i));
            random_order[i]=num;
        }

        for(i=0;i<n;i++)
        {
            if(i<(n/2))
                random_order_a[i]=random_order[i];
            else
                random_order_b[i-(n/2)]=random_order[i];
        }

    }
}
