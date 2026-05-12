
public class FactorialMain {
	public static void main(String[] args) {
		for(int i=1; i <= 10; i++) {
			System.out.printf("Factorial of %d: ", i);
			for(int j=1; j <= i; j++) {
				if(j!=1)
					System.out.print('*');
				System.out.print(j);
			}
			System.out.printf("=%d%n",factorial(i));
		}
	}
	
	private static long factorial(final int n) {
		if(n==1)
			return 1;
		else
			return n*factorial(n-1);
	}
}