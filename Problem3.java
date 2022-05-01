import java.util.Scanner;
class Problem3{
	static int abs(int x){
		if(x>0)
			return x;
		else
			return (-1)*x;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases=s.nextInt(),r[]=new int[cases],c[]=new int[cases],arr[][][]=new int [cases][][],min=0;
		for (int k=0;k<cases ;k++ ) {
			r[k]=s.nextInt();
			c[k]=s.nextInt();
			arr[k]=new int[r[k]][c[k]];
			for (int i=0;i<r[k] ;i++ ) {
				for (int j=0;j<c[k] ;j++ ) {
					arr[k][i][j]=s.nextInt();
				}
			}
		}
		for (int i=0;i<cases ;i++ ) {
			for (int j=0;j<r[i]-1;j++ ) {
				for(int l=0;l<c[i];l++){
					for (int k=l+1;k<c[i] ;k++ ) {
						if(arr[i][j][l]>arr[i][j][k]){
							int temp=arr[i][j][l];
							arr[i][j][l]=arr[i][j][k];
							arr[i][j][k]=temp;

						}
					}
				}
			}
			for (int j=0;j<r[i] ;j++ ) {
				for (int k=0;k<c[i] ;k++ ) {
					System.out.print(arr[i][j][k]+" ");
				}
				System.out.println("");
			}
			min=arr[i][0][c[i]-1];
			for(int l=0;l<c[i];l++){
					for (int k=l+1;k<c[i] ;k++ ) {
						if(arr[i][r[i]-1][l]<arr[i][r[i]-1][k]){
							int temp=arr[i][r[i]-1][l];
							arr[i][r[i]-1][l]=arr[i][r[i]-1][k];
							arr[i][r[i]-1][k]=temp;

						}
					}
			}
			for (int j=1;j<r[i] ;j++ ) {
				min+=abs(arr[i][j-1][c[i]-1]-arr[i][j][0]);
				for (int k=0;k<c[i]-1 ;k++ )
					min+=abs(arr[i][j][k]-arr[i][j][k+1]);
			}
			System.out.println(min);
		}

	}
}