class OverloadingIssues{

	public void display(int a, double b){
		System.out.println("Method A");
	}

	public void display(int a, double b, double c){
		System.out.println("Method B");
	}

	public void display(int a, float b){
		System.out.println("Method C");
	}

	public void display(double a, double b){
		System.out.println("Method D");
	}

	public void display(int a, int b){
		System.out.println("Method E");
	}

	public static void main(String args[]){
		OverloadingIssues obj = new OverloadingIssues();

		obj.display(100, 20.67f);   // calls method C due to the f
		obj.display(100, 20.67);    // calls method A
		obj.display(1, 1);          // calls method E
		// comment methods out to observe which ones are called
	}
}