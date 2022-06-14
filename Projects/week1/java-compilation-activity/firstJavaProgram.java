class firstJavaProgram {
    public static void main(String[] args) {
        Random number = new Random(); 
	int rand = number.nextInt(1000);
	if(args.length ==1){
		System.out.println(rand);
	}else if(args.length== 2){
		int repeat = args[0];
		for(int i = 0; i<repeat; i++){
		System.out.println(args[1]);
		}
	}else 
		System.out.println("Not sure what to do with that");
    }
}
