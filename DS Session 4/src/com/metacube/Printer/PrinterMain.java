package com.metacube.Printer;

import java.util.Scanner;

/**
 * Main Class for processing all the jobs with their priorities
 *
 */
public class PrinterMain {
	/**
	 * main method
	 */
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter the number of jobs: ");
    	int jobNumber = getIntegerInput(scan);
        MyHeap heap = new MyHeap(jobNumber);
        String operation[] = new String[] { "Add New Job", "Print Job", "Exit" };
        int pr;
        char ch = 0;
        do {
            int counter = 0;
            for (String opt : operation) {
                System.out.println(++counter + "." + opt);
            }
            int choice = getChoice(scan, counter);
            switch (choice) {
            case 1:
                System.out.println("Enter job name");
                String str = scan.next();
                System.out.print("Enter Priority Of " + str + "=");
                try {
                    pr = scan.nextInt();
                    heap.insert(str, pr);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Enter priority in integer only");
                    main(args);
                }
                break;
            case 2:
                Job printJob = heap.remove();
                if (printJob != null)
                        System.out.println(printJob.getName() + " of priority " + printJob.getPriority() + " is printed");
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Enter correct choice");
                main(args);
            }
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
    
    /**
     * get the integer input from the user
     * @param scan
     * @return
     */
    private static int getIntegerInput(Scanner scan) {
		// TODO Auto-generated method stub
    	boolean flag = true;
		int number=-1;
		
		do {
			try{
				number = scan.nextInt();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				System.out.println("Please enter valid input");
				flag = false;
			}
		}while(!flag || number<=0);
		return number;
		
	}

	/**
	 * Takes users choice and return it
	 * @param scan
	 * @param range
	 * @return
	 */
    private static int getChoice(Scanner scan, int range) {
        int choice = 0;
        try {
            do {
                choice = Integer.parseInt(scan.next());
            } while (choice <= 0 || choice > range);
        } catch (Exception e) {
            System.out.println("Invalid choice");
            getChoice(scan, range);
        }
        return choice;
    }
}
