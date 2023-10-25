/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BelajarArray;

/**
 *
 * @author AJENG
 */
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main (String[] args){
        //Deklarasi Scanner
        Scanner masukan = new Scanner(System.in);
        
        //Deklarasi variabel
        String[][] item= {
            {"Makanan" ,"Bebek Goreng", "30000"},
            {"Makanan" ,"Ikan Bakar", "65000"},
            {"Makanan", "Gurame Asap", "30000" },
            {"Makanan", "Penyet Tempe", "7000"},
            {"Makanan", "Lele Goreng", "10000"},
            {"Minuman", "Lemonade" , "15000" },
            {"Minuman", "Iced Tea" , "10000" },
            {"Minuman", "Iced Cola" , "8000" },
            {"Minuman", "Air Mineral" , "5000" },
            {"Minuman", "Iced Coffee" , "15000" }
        };
        
        String [] order = new String [4];
        int[] quantity = new int [4];
        double[] prices = new double[4]; 
        double totalPrice = 0;
        double discount = 0.1;
        double taxRate = 0.1;
        int i = 0;
        int serviceCost = 20000;
        double service;
        double afterTaxPrice;
        double discountedPrice;
        double totalPriceTax;
        
        //Menampilkan menu
        System.out.println("===========================Warung Murah===========================");

            //perulangan untuk menampilkan item menu
            System.out.println("--------------Foods--------------");
            for(int x = 0; x < item.length/2; x++){
               System.out.println((x+1) + "  " +item[x][1] + "          " + item[x][2]);
            }
            System.out.println("");
            System.out.println("--------------Beverages--------------");
            for(int x = (item.length/2); x < item.length; x++){
                System.out.println((x+1) + "  " + item[x][1] + "          "+ item[x][2]);
            }
            System.out.println("");
            
            //Menampilkan inputan dan kondisional untuk pesanan
            System.out.println("--------------Place Your Order Here--------------");
            System.out.println("*)Hanya bisa memesan maksimal 4 item di setiap pesanan");
            
            while(i < 4){
                System.out.println("Choose an item(Please input 'q' to complete your order): ");
                System.out.println("(Please input item's name to order)");
                String pilihan = masukan.nextLine();
                
                //Untuk menyelesaikan pesanan
                if (pilihan.equals("q")){
                    break;
                }
                System.out.println("Please input item's quantity/ies: ");
                String kuantitas = masukan.nextLine();
                
                //Untuk memvalidasi pilihan dan memasukkan ke Array order
                for(int x = 0; x < item.length; x++){
                    if(pilihan.equals(item[x][1])){
                        //mengkonversi tipe data string ke double lalu ditempatkan pada array prices
                        String y = item[x][2];
                        prices[i] = Double.parseDouble(y);
                        order[i] = item[x][1];
                        quantity[i] = Integer.parseInt(kuantitas);
                    } 
                }
                //Untuk menghitung total biaya pesanan
                double perItemPrice = prices[i] * quantity[i];
                totalPrice += perItemPrice;
                
                //increment (menambah variabel i sebanyak 1 angka)
                i++;
            } 
            System.out.println("============================================================");
            System.out.println("");
            System.out.println("");
         
        //Menampilkan struk pembayaran
        System.out.println("============================================================");
        System.out.println("                        Struk Pembayaran                    ");
        System.out.println("============================================================");
        //menampilkan setiap item yang dipesan
        for(int x = 0; x < order.length; x++){
            System.out.print((x+1) + "  " + order[x] +"   "+ prices[x] + "   "+ quantity[x] + "  Rp. "+(prices[x]*quantity[x]));
            System.out.println("");
        } 
        System.out.println("---------------------------------------------------");
        
        //kondisional untuk menentukan apakah total pesanan dan penentuan diskon dan penawaran
                if (totalPrice >= 50000 && totalPrice < 100000){
                    System.out.println("Selamat anda mendapat penawaran buy 1 get 1 free untuk item minuman Iced Tea");
                    System.out.println("Apakah anda tertarik dengan penawaran ini? (true/false)");
                    boolean opsi = masukan.nextBoolean();
                    if (opsi == true){
                        //Menambah jumlah array.
                        order = new String [5];
                        quantity = new int [5];
                        String y = item[6][2];
                        prices = new double[5];
                        
                        //memasukkan item baru ke array
                        order[4] = item[6][1];
                        quantity[4] = 2;
                        prices[4] = Double.parseDouble(y);
                        
                        //menambahkan harga teh ke totalPrice
                        totalPrice += prices[4];
                        
                        //menambahkan tax dan service pada totalPrice
                        afterTaxPrice = totalPrice * taxRate;
                        totalPriceTax = totalPrice + afterTaxPrice;
                        service = totalPriceTax + serviceCost;
                        
                        //print total
                        System.out.println("Buy 1 get 1 free (Iced Tea)  " + prices[4] + "         " + totalPrice);
                        System.out.println("Tax rate (10%)               " + afterTaxPrice + "         " + totalPriceTax);
                        System.out.println("Service cost                 " + serviceCost + "         " + service);
                        System.out.println("-----------------------------------------------------------------");
                        System.out.println("Total yang harus dibayar     " + service);
                        System.out.println("");
                        System.out.println("");
                        System.out.println("Thank you, Please come again!!!");
                        System.out.println("=================================================================");
                    } else{
                        //print total jika kondisi false
                            afterTaxPrice = totalPrice * taxRate;
                            totalPriceTax = totalPrice + afterTaxPrice;
                            service = totalPriceTax + serviceCost;
                        
                            System.out.println("Tax rate (10%)               " + afterTaxPrice + "         " + totalPriceTax);
                            System.out.println("Service cost                 " + serviceCost + "         " + service);
                            System.out.println("-----------------------------------------------------------------");
                            System.out.println("Total yang harus dibayar     " + service);
                            System.out.println("");
                            System.out.println("");
                            System.out.println("Thank you, Please come again!!!");
                            System.out.println("=================================================================");
                    }
                     
                }else if(totalPrice >= 100000){
                    //perhitungan diskon
                    discountedPrice = totalPrice * discount;
                    totalPrice -= discountedPrice;
                    
                    //menambahkan tax dan service pada totalPrice
                    afterTaxPrice = totalPrice * taxRate;
                    totalPriceTax = totalPrice + afterTaxPrice;
                    service = totalPriceTax + serviceCost;
                    
                    //print total
                    System.out.println("Discount (10%)                   " + discountedPrice + "         " + totalPrice);
                    System.out.println("Tax rate (10%)               " + afterTaxPrice + "         " + totalPriceTax);
                    System.out.println("Service cost                 " + serviceCost + "         " + service);
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("Total yang harus dibayar     " + service);
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Thank you, Please come again!!!");
                    System.out.println("=================================================================");
                } else if(totalPrice <= 0){
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("Pesanan Gagal");
                }else {
                    //menambahkan tax dan service pada totalPrice
                    afterTaxPrice = totalPrice * taxRate;
                    totalPriceTax = totalPrice + afterTaxPrice;
                    service = totalPriceTax + serviceCost;
                    
                    //print total
                    System.out.println("Tax rate (10%)               " + afterTaxPrice + "         " + totalPriceTax);
                    System.out.println("Service cost                 " + serviceCost + "         " + service);
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("Total yang harus dibayar     " + service);
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Thank you, Please come again!!!");
                    System.out.println("=================================================================");
                }
    }
                    
}
    
            
                
                

            
        
            
            
            
            
     
