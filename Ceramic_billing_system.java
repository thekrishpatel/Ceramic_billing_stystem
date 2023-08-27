import java.util.*;
import java.util.jar.Attributes.Name;

class nirali_collection extends Stock {
    int token_number;

    void call() {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 1000;) {
            System.out
                    .println(
                            "1.Genrate bill \n2.total_collaction \n3.Stock check\n4.Change stock \n5.Client information \n6.Update client information \n7.Add new client \n8.Add stock \n9.Exit \nSelelct the service : ");
            String select = sc.nextLine();
            if (select.equalsIgnoreCase("Genrate bill") == true || select.equalsIgnoreCase("1") == true) {
                genrate_bill();
            }
            if (select.equalsIgnoreCase("total collection") == true || select.equalsIgnoreCase("2") == true) {
                total_collection();
            }
            if (select.equalsIgnoreCase("Stock check") == true || select.equalsIgnoreCase("3") == true) {
                stock_check();
            }
            if (select.equalsIgnoreCase("Change stock") == true || select.equalsIgnoreCase("4") == true) {
                change_stock();
            }
            if (select.equalsIgnoreCase("Client information") == true || select.equalsIgnoreCase("5") == true) {
                search_client();
            }
            if (select.equalsIgnoreCase("Update client information") == true || select.equalsIgnoreCase("6") == true) {
                update_data();
            }
            if (select.equalsIgnoreCase("Add client") == true || select.equalsIgnoreCase("7") == true) {
                add_client();
            }
            if (select.equalsIgnoreCase("Add stock") == true || select.equalsIgnoreCase("8") == true) {
                add_stock();
            }
            if (select.equalsIgnoreCase("Exit") == true || select.equalsIgnoreCase("9") == true) {
                i = 1000;
            }
        }
    }

    void genrate_bill() {
        int temp_count1 = 0;
        int temp_count2 = 0;
        int x = 0;
        client_data sd = new client_data();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter client name : ");
        String name = sc.nextLine();
        for (int i = 0; i <= count_client; i++) {
            if (Name[i].equalsIgnoreCase(name)) {
                temp_count1 = 1;
                System.out.println("Enter the design number or name : ");
                String temp_designname = sc.nextLine();
                for (int j = 0; j <= design_count; j++) {
                    if (temp_designname.equals(design_name[j])) {
                        temp_count2++;
                        System.out.println("Available stock is : " + stock_design[j]);
                        System.out.println("Enter the total boxes : ");
                        long temp_box = sc.nextLong();
                        sc.nextLine();
                        if (temp_box < stock_design[j]) {
                            super.stock_design[j] -= temp_box;
                            System.out.println(
                                    "----------------------------------------------------------------------------------------------------------");
                            System.out.println("                                                 Nirali ceramic"
                                    + "                        Date : 23/02/2023");
                            System.out.println(
                                    "----------------------------------------------------------------------------------------------------------");
                            sd.Client_info(name);
                            System.out.println("Name of the design is :                         " + design_name[j]);
                            System.out.println();
                            System.out.println("Total number of boxes is :                      " + temp_box);
                            System.out.println();
                            System.out.println("MRP of the product per box is :                 " + mrp[j]);
                            System.out.println();
                            System.out.println("Total amount is :                               " + mrp[j] * temp_box);
                            amount[i] = amount[i] + (mrp[j] * temp_box);
                            System.out.println(
                                    "----------------------------------------------------------------------------------------------------------");
                            return;
                        } else {
                            System.out.println(design_name[j] + " is not available in stock");
                        }
                        break;
                    } else {
                        System.out.println("Stock data not found.");
                        j = 1000;
                    }
                }
            }
        }
        if (temp_count1 == 0) {
            System.out.println("Client Data not found");
        }
        sc.close();
    }
}

class Stock extends client_data {
    String comany_name[] = new String[10];
    String design_name[] = new String[500];
    long stock_design[] = new long[500];
    long mrp[] = new long[500];
    int design_count = 14;
    int stock;

    Stock() {
        comany_name[0] = "Godwin ceramic";
        comany_name[1] = "Itile ceramic";
        comany_name[2] = "TAG ceramic";

        // godwin
        design_name[0] = "metrix";
        stock_design[0] = 500;
        mrp[0] = 420;
        design_name[1] = "wooden";
        stock_design[1] = 500;
        mrp[1] = 420;
        design_name[2] = "chex";
        stock_design[2] = 500;
        mrp[2] = 420;
        design_name[3] = "white marble";
        stock_design[3] = 500;
        mrp[3] = 420;
        design_name[4] = "white matt";
        stock_design[4] = 500;
        mrp[4] = 420;
        // itile
        design_name[5] = "123";
        stock_design[5] = 500;
        mrp[5] = 320;
        design_name[6] = "234";
        stock_design[6] = 500;
        mrp[6] = 320;
        design_name[7] = "345";
        stock_design[7] = 500;
        mrp[7] = 320;
        design_name[8] = "456";
        stock_design[8] = 500;
        mrp[8] = 320;
        design_name[9] = "678";
        stock_design[9] = 500;
        mrp[9] = 320;
        // tag
        design_name[10] = "24123";
        stock_design[10] = 500;
        mrp[10] = 440;
        design_name[11] = "24234";
        stock_design[11] = 500;
        mrp[11] = 440;
        design_name[12] = "24345";
        stock_design[12] = 500;
        mrp[12] = 440;
        design_name[13] = "24456";
        stock_design[13] = 500;
        mrp[13] = 440;
        design_name[14] = "24567";
        stock_design[14] = 500;
        mrp[14] = 440;
    }

    void stock_check() {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        int temp = 0;
        System.out.println("Enter the design number : ");
        String temp_designnumber = sc.nextLine();
        for (int i = 0; i <= design_count; i++) {
            if (design_name[i].equalsIgnoreCase(temp_designnumber)) {
                System.out.println("Available stock is : " + stock_design[i]);
                temp = 1;
            }
        }
        if (temp == 0) {
            System.out.println("Data not found.");
        }
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
    }

    void change_stock() {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        int temp = 0;
        System.out.println("Enter the design number : ");
        String temp_designnumber = sc.nextLine();
        for (int i = 0; i <= design_count; i++) {
            if (design_name[i].equalsIgnoreCase(temp_designnumber)) {
                System.out.print("Enter the new Stock : ");
                stock_design[i] = sc.nextLong();
                temp = 1;
            }
        }
        if (temp == 0) {
            System.out.println("Data not found.");
        }
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
    }

    void add_stock() {
        System.out.println("Enter new design name : ");
        design_name[++design_count] = sc.nextLine();
        System.out.println("Enter total stock of design : ");
        stock_design[design_count] = sc.nextLong();
        System.out.println("Enter the mrp of the stock : ");
        mrp[design_count] = sc.nextLong();
    }
}

class client_data {
    Scanner sc = new Scanner(System.in);
    int count_client = 4;
    int temp_count = 0;
    String Name[] = new String[21];
    String Adress[] = new String[21];
    String Mo_no[] = new String[21];
    long amount[] = new long[21];

    client_data() {

        Name[0] = "Chamunda ceramic";
        Mo_no[0] = "+91 1111111111";
        Adress[0] = "Hiravadi";
        Name[1] = "Laxminarayan ceramic";
        Mo_no[1] = "+91 222222222";
        Adress[1] = "Hiravadi";
        Name[2] = "Matrudhara ceramic";
        Mo_no[2] = "+91 333333333";
        Adress[2] = "Rabari colony";
        Name[3] = "Sajavat ceramic";
        Mo_no[3] = "+91 4444444444";
        Adress[3] = "Rabari colony";
        Name[4] = "Umang ceramic";
        Mo_no[4] = "+91 5555555555";
        Adress[4] = "Rajendrapark";
    }

    void Client_info(String name) {
        for (int i = 0; i <= count_client; i++) {
            if (Name[i].equalsIgnoreCase(name)) {
                System.out.println("Name of the client is :                         " + Name[i]);
                System.out.println();
                System.out.println("Adress of the client is :                       " + Adress[i]);
                System.out.println();
                System.out.println("Mobile number of the client is :                " + Mo_no[i]);
                System.out.println();
                System.out.println("Id of the client is :                           " + i + 1);
                System.out.println();
                temp_count = 1;
            }
        }
        if (temp_count == 0) {
            System.out.println("Data not found");
        }
    }

    void search_client() {
        System.out.println("Enter the name of the client");
        String name = sc.nextLine();
        for (int i = 0; i <= count_client; i++) {
            if (Name[i].equalsIgnoreCase(name)) {
                System.out.println(
                        "----------------------------------------------------------------------------------------------------------");
                System.out.println("Name of the client is :                         " + Name[i]);
                System.out.println();
                System.out.println("Adress of the client is :                       " + Adress[i]);
                System.out.println();
                System.out.println("Mobile number of the client is :                " + Mo_no[i]);
                System.out.println();
                System.out.println("Id of the client is :                           " + i + 1);
                System.out.println();
                System.out.println("Remain amount of the client is :                " + amount[i]);
                System.out.println();
                temp_count = 1;
                System.out.println(
                        "----------------------------------------------------------------------------------------------------------");
            }
        }
        if (temp_count == 0) {
            System.out.println("Data not found");
        }
    }

    void update_data() {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Enter the name of the client you want to update : ");
        String temp_name = sc.nextLine();
        for (int i = 0; i <= count_client; i++) {
            if (Name[i].equalsIgnoreCase(temp_name)) {
                System.out.println(
                        "1.Name \n2.Adress \n3.Mobile number \n4.Total Amount \nWhich information do you want to update : ");
                String temp_service = sc.nextLine();
                if (temp_service.equalsIgnoreCase("Name") == true || temp_service.equalsIgnoreCase("1") == true) {
                    Name[i] = sc.nextLine();
                }
                if (temp_service.equalsIgnoreCase("Adress") == true || temp_service.equalsIgnoreCase("2") == true) {
                    Adress[i] = sc.nextLine();
                }
                if (temp_service.equalsIgnoreCase("Mobile number") == true
                        || temp_service.equalsIgnoreCase("3") == true) {
                    Mo_no[i] = sc.nextLine();
                }
                if (temp_service.equalsIgnoreCase("Total Amount") == true
                        || temp_service.equalsIgnoreCase("4") == true) {
                    amount[i] = sc.nextLong();
                }
                temp_count = 1;
            }
        }
        if (temp_count == 0) {
            System.out.println("Data not found");
        }
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
    }

    void add_client() {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Enter the name of the new Client : ");
        Name[++count_client] = sc.nextLine();
        System.out.println("Enter the Adress of the new Client : ");
        Adress[++count_client] = sc.nextLine();
        System.out.println("Enter the Mobile number of the new Client : ");
        Mo_no[++count_client] = sc.nextLine();
        System.out.println("Enter the Amount of the new Client : ");
        amount[++count_client] = sc.nextLong();
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
    }

    void total_collection() {
        System.out.println("Enter the name of the client");
        String temp_name = sc.nextLine();
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        for (int i = 0; i <= count_client; i++) {
            if (Name[i].equalsIgnoreCase(temp_name)) {
                System.out.println("Total collection remain of the " + Name[i] + " is : " + amount[i]);
            }
        }
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
    }
}

class Main {
    public static void main(String[] args) {
        nirali_collection nc = new nirali_collection();
        nc.call();
    }
}