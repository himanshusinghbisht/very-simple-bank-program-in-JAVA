import java.util.*;
import java.io.*;

class Account
{

static BufferedReader i = new BufferedReader(new InputStreamReader(System.in));
static Scanner j = new Scanner(System.in);
double bal;
int acc_no;

Account()
{
bal = (int)(Math.random() * 40000 + 10000);

}
String name,acc_type;
static String passwd= "admin";

static void printf(String line)
{

System.out.print(line);

}
void get_data()
throws IOException{
printf("Enter your name    ");
name = i.readLine();

printf("\nenter account number    ");
acc_no = j.nextInt();
 printf("choose the account type\n");
 printf(" 1 > savings \n 2 > fast cash \n 3 > credit \n");
 int ch;
 ch = j.nextInt();
 switch(ch)
 {
 case 1:
 acc_type = "savings";
 break;
 case 2:
 acc_type = "fast cash";
 break;
 case 3:
 acc_type = "credit";
 break;
 default:
 printf("invalid choice \n\n");
 
 }

}

void display()
{

printf(" \n\n\n NAME           : " + name.toUpperCase() + " \n " + "ACCOUNT NUMBER : " + acc_no + " \n ACCOUNT TYPE   : " + acc_type.toUpperCase() + " \n BALANCE        : " + bal + " \n\n\n"); 
}


void withdraw()
throws IOException{
int amount;
printf("\nenter the amount to withdraw\n\n");
amount = j.nextInt();
if(bal>amount)
{
bal-=amount;
}
else
{
printf("\nBalance is too low \n\n\n");
}
}

void deposit()
throws IOException{
int amount;
printf("\nenter the amount to be deposited\n");
amount = j.nextInt();
bal+=amount;


}


}

class Runner
{
static BufferedReader i = new BufferedReader(new InputStreamReader(System.in));
static Scanner j = new Scanner(System.in);

static void printf(String line)
{
System.out.println(line);
}
public static void main(String arg[])
throws IOException{
boolean choice = true;
int ch;
int id=0;
String passwd;
int n;
int x=0,count;
Account[] obj = new Account[100];
do
{
Runtime.getRuntime().exec("clear");
printf("press 1 to create account ");
printf("press 2 to view account info ");
printf("press 3 to withdraw ");
printf("press 4 to  deposit ");
printf("press 5 to view all accounts info *admin only*");
printf("press 6 to exit");
printf("enter your choice");
ch = j.nextInt();
switch(ch)
{
case 1:
obj[id] = new Account();
obj[id].get_data();
id++;
break;
case 2:

printf("enter the account number\n ");
n = j.nextInt();
x=0;
while(x<id)
{
if( obj[x].acc_no == n)
{
obj[x].display();
break;

}
x++;
}
break;
case 3:

printf("enter the account number");
n = j.nextInt();
x=0;
while(x<id)
{
if( obj[x].acc_no == n)
{
obj[x].withdraw();
break;

}
x++;
}
break;
case 4:
printf("enter the account number");
n = j.nextInt();
x=0;
while(x<id)
{
if( obj[x].acc_no == n)
{
obj[x].deposit();
break;

}
x++;
}
break;
case 5:
System.out.print("password: ");
passwd= i.readLine();
Runtime.getRuntime().exec("clear");
if(passwd.equals(Account.passwd))
{
count=0;
while(count<id)
{
obj[count].display();
count++;
}
}
else
{
printf("Authentication failure \n");
}
break;
case 6:
System.exit(0);

default:
printf("invalid choice \n\n");

}


}while(choice);

}

}
