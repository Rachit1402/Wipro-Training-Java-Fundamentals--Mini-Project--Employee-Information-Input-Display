public class InputOutput {

    public static int[] id_employee = { 1001, 1002, 1003, 1004, 1005, 1006, 1007 };
    public static String[] employee_name = { "Ashish", "Sushma", "Rahul", "Chahat", "Ranjan", "Suman", "Tanmay" };
    public static String[] date_of_joining = { "01/04/2009", "23/08/2012", "12/11/2008", "29/01/2013", "16/07/2005", "1/1/2000",
            "12/06/2006" };
    public static String[] designation_code = { "e", "c", "k", "r", "m", "e", "c" };
    public static String[] department= { "R&D", "PM", "Acct", "Front Desk", "Engg", "Manufacturing", "PM" };
    public static int[] Basic= { 20000, 30000, 10000, 12000, 50000, 23000, 29000 };
    public static int[] HRA= { 8000, 12000, 8000, 6000, 20000, 9000, 12000 };
    public static int[] IT = { 3000, 9000, 1000, 2000, 20000, 4400, 10000 };
    
    public static int DACalculation(int i) {
        String designation = designation_code[i];
        switch(designation) {
            case "e": return 20000;
            case "c": return 32000;
            case "k": return 12000;
            case "r": return 15000;
            case "m": return 40000;
        }
        return 0;
    }

    public static String getDesigCode(int id) {
        return designation_code[getIndex(id)];
    }

    public static int getIndex(int id) {
        int index = -1;
        for(int i = 0; i < id_employee.length; i++) {
            if(id == id_employee[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
    public static int getSalary(int id) {
        int index = getIndex(id);
        if(index == -1) return -1;
        return (Basic[index] + HRA[index] - IT[index] + DACalculation(index));
    }

    public String getName(int id) {
        return employee_name[getIndex(id)];
    }

    public String getDept(int id) {
        return department[getIndex(id)];
    }

    public boolean empExists(int id) {
        if(getIndex(id) != -1)
            return true;
        else
            return false;
    }

    public String getDesignation(int id) {
        String d = getDesigCode(id);
        switch(d) {
            case "e": return "Engineer";
            case "c": return "Consultant";
            case "k": return "Clerk";
            case "r": return "Receptionist";
            case "m": return "Manager";
        }
        return null;
    }
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 1) {
			System.out.println("Usage: java Employee emp_id");
		}
		else {
			int id = Integer.parseInt(args[0]);
			InputOutput emp = new InputOutput();
			if(emp.empExists(id)) {
				System.out.println("Emp No.    Emp Name    Department    Designation    Salary");
				System.out.printf("%d    ", id);
				System.out.printf("%9s    ", emp.getName(id));
				System.out.printf("%10s    ", emp.getDept(id));
				System.out.printf("%11s    ", emp.getDesignation(id));
				System.out.printf("%7d\n", emp.getSalary(id));
			}
			else {
				System.out.println("There is no employee with empid: " + id);
			}
		}
	}

}