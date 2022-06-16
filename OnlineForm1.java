import java.util.*;
class OnlineForm1{
 	public static BasicDetails ReservationForm(){
 	    Scanner in=new Scanner(System.in);
 		System.out.println("----------------------------------------------------------------------------------------------------");
 		System.out.println("			<<<<<<<<<<<<<<<Welcome To ReservationForm>>>>>>>>>>>>>>>>>>");
 		System.out.println("----------------------------------------------------------------------------------------------------");
 		
		BasicDetails bd=new BasicDetails();
 		System.out.println("Please Fill Basic Details:>>>>");
		System.out.print("Enter Your Name:");
		bd.name=in.next();
        System.out.print("Enter Your Phone Number:");
		bd.Phonenumber=in.next();
		System.out.println("			Enter Your EmailId:");
		bd.EmailId=in.next();
		System.out.print("Enter Your Age:");
		bd.age=in.nextInt();
		while(true){
			System.out.print("Gender:1.Male 2.Female\nSelect Gender:");
			Integer n=in.nextInt();
			if(n==1){
				bd.Gender="MALE";
				break;
			}
			else if(n==2){
				bd.Gender="FEMALE";
				break;
			}
			else{
				System.out.println("Please Enter Valid Option");
			}
		}
		
		Hashtable<Integer,String> trains=new Hashtable<Integer,String>();
		trains.put(1,"Shabari Express");
		trains.put(2,"Chennai Express");
		trains.put(3,"Krishna Express");
		trains.put(4,"Godavari Express");
		trains.put(5,"Pune Express");
		while(true){
			System.out.print("Enter Train Number:");
			bd.trainnumber=in.nextInt();
			if(bd.trainnumber<=5 && bd.trainnumber>=1){
			break;}
			System.out.println("Please Enter Valid Train Number");
		}
		System.out.println("Your Train name is:"+trains.get(bd.trainnumber));
		bd.Train=trains.get(bd.trainnumber);
		System.out.print("Available Classes:1.EC 2.1AC 3.2AC 4.3AC 5.FC 6.CC 7.SL 8.2S\nSelect Your Class:");
	
		bd.classs=in.nextInt();
		System.out.print("Date Of Journey:");
		
		bd.dateOfJourney=in.next();
		System.out.print("From:");
		
		bd.from=in.next();
		System.out.print("To:");
		
		bd.to=in.next();
		
 		System.out.println("\nPlease PRESS ENTER to Insert the data into your journey Details");
		
		return bd;
 	}
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		ArrayList<String> loginids=new ArrayList<>();								//Avaliable logins list Data
		Hashtable<String,Integer> d=new Hashtable<String,Integer>();				//password && login data
		Hashtable<String,BasicDetails> dd=new Hashtable<String,BasicDetails>();		//user Details..
		while(true){
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("            <<<<<<<<<<<<<<<<<WELCOME TO LOGIN FORM>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("                       1.Create Account\n                       2.Login\nSelect Option to login:");
			Integer n=in.nextInt();

			if(n==2){
				while(true){
					System.out.println("Enter a valid Login id:");
					String loginid=in.next();
					if(loginids.contains(loginid)){
						System.out.println("Enter a valid Login Password:");
						Integer password=in.nextInt();
						if(d.get(loginid)==password){
							//UserInterface>>reservationform,cancilationform
							System.out.println("-----------------------------------------------------------------------------------");
							System.out.println("            <<<<<<<<<<<<<WELCOME TO USERINTERFACE FORM>>>>>>>>>>>>>>>>>");
							System.out.println("-----------------------------------------------------------------------------------");
							System.out.println("             1.Reservation Form\n             2.Cancellation Form");
							System.out.print("Enter User Choice:");
							Integer c=in.nextInt();
							if(c==1){
								dd.put(loginid+""+password,ReservationForm());
								
							}
							else if(c==2){												//CancellationForm
								try{
									BasicDetails a=new BasicDetails();
									a=dd.get(loginid+""+password);
									System.out.println("-----------------------------------------------------------------------------------");
									System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<Your Journey Trip Details:>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
									System.out.println("-----------------------------------------------------------------------------------");
									System.out.println("Passenger Your Name:"+a.name);
									System.out.println("Passenger Your Phone Number:"+a.Phonenumber);
									System.out.println("Passenger Age:"+a.age);
									System.out.println("Passenger Gender:"+a.Gender);
									System.out.println("Passenger Train Number:"+a.trainnumber);
									System.out.println("Slotted Classes:"+a.classs);
									System.out.println("Date Of Journey:"+a.dateOfJourney);
									System.out.println("From:"+a.from);
									System.out.println("To:"+a.to);
									System.out.println("-----------------------------------------------------------------------------------");
									System.out.println("Do You want to Remove the data\n		        1.Yes\n			2.No");
									Integer option=in.nextInt();
									if(option==1){
										dd.remove(loginid+""+password);
										System.out.println("This Journey is Successfully cancelled from the list Of Your Trips");
									}
									else{
										System.out.println("Cancellation Failed");
									}
								}
								catch(Exception e){
									System.out.println("You Do Not Have Any Active Trips");
								}
							}
                            break;
						}
						else{
							System.out.println("Please Enter Correct Password"); 
							break;
						}
					}
					else{
						System.out.println("UserId is no available.Please Enter Valid Id or Create Account");
				 		break;
					}
					
				}
                //break;//in real time no break is used
			}
			else if(n==1){
				System.out.println("UserId:");
				String id=in.next();
				System.out.println("Password:");
				Integer pass=in.nextInt();
				loginids.add(id);
				d.put(id,pass);
				System.out.println("Your Account Has Been Created Successfully");
				
			}
			else{
				System.out.println("Please Enter Valid Option"); 
			}
		}
	}
}
class BasicDetails{
 	public String name,EmailId,Phonenumber,Gender,dateOfJourney,from,to;
	public Integer trainnumber,age,classs;
	public Object Train;
 	public static void main(String[] args){
		BasicDetails bd=new BasicDetails();
 	}
}