package LanQiao;
//问题描述
//        　　在数列 a[1], a[2], ..., a[n] 中，如果对于下标 i, j, k 满足 0<i<j<k<n+1 且 a[i]<a[j]<a[k]，则称 a[i], a[j], a[k] 为一组递增三元组，a[j]为递增三元组的中心。
//        　　给定一个数列，请问数列中有多少个元素可能是递增三元组的中心。
//        输入格式
//        　　输入的第一行包含一个整数 n。
//        　　第二行包含 n 个整数 a[1], a[2], ..., a[n]，相邻的整数间用空格分隔，表示给定的数列。
//        输出格式
//        　　输出一行包含一个整数，表示答案。
//        样例输入
//        5
//        1 2 5 3 5
//        样例输出
//        2
//        样例说明
//        　　a[2] 和 a[4] 可能是三元组的中心。
//        评测用例规模与约定
//        　　对于 50% 的评测用例，2 <= n <= 100，0 <= 数列中的数 <= 1000。
//        　　对于所有评测用例，2 <= n <= 1000，0 <= 数列中的数 <= 10000。
public class E {
//    #include <iostream>
//    //2019年12月8日 13:55:00
//    using namespace std;
//    int a[1002];
//    bool check(int l,int i ,int r)
//    {
//        return a[l]<a[i]?(a[i]<a[r]?true:false):false;
//    }
//    int main()
//    {
//        int n,i,j,k,count=0;
//        cin>>n;
//        for (i= 1; i <= n; i++)
//            cin>>a[i];
//        for(i=1;i<=n-2;i++)//排除头尾 1 ~ n-1
//        {
//            for(j=i+1;j<=n-1;j++)
//            {
//                for(k=j+1;k<=n;k++)
//                {
//                    //cout<<i<<j<<k<<endl;
//                    if(check(i,j,k)){
//                        //cout<<a[l]<<a[i]<<a[r]<<endl;
//                        count++;
//                        a[j]=0;//去重
//                    }
//
//                }
//            }
////    	int l=i,r=i;
////    	while(l-1!=0&&r+1!=n+1)
////		{
////			l--;
////			r++;
////			cout<<l<<i<<r<<endl;
////			if(check(l,i,r)){
////				//cout<<a[l]<<a[i]<<a[r]<<endl;
////				count++;
////			}
////		}
//        }
//
//        cout<<count<<endl;
//        return 0;
//    }
}
