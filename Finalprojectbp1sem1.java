/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package finalprojectbp1sem1;
import java.util.Scanner;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * @author putra_173
 */
public class Finalprojectbp1sem1 {
    
    public static final String bgred = "\u001B[41;37m";
    public static final String red = "\u001B[31m";
    public static final String bggreen = "\u001B[42;37m";
    public static final String green = "\u001B[32m";
    public static final String bgwhite = "\u001B[47m";
    public static final String whitered = "\u001B[47;31m";
    public static final String resetcolor = "\u001B[0m";

    static LocalDateTime currentDateTime = LocalDateTime.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    
    static Scanner scan = new Scanner(System.in);
    static final String[] item = {"Poster", "Keychains", "Nendroid", "Desk Mat",
                            "Hoodie", "Shirt", "Pin", "CD","Plush","Bracelet",
                            "Hat","Mousepad","Bag","Socks","Mug","Notebook"};
    
    static int[] harga = {9,10,21,15,35,31,6,25,10,6,8,6,20,7,8,5}; 
    static String caribarang;
    static int total = 0;
    static int uang;
    static int[] cartjumlah = new int[item.length];
    static String[] cartbarang = new String [item.length];
    
public static void tampillist(){
//    String balik;
    System.out.println(whitered+"=========================== KATALOG ========================="+resetcolor);
        for (int i = 0; i < item.length; i += 2) {
        if (i + 1 < item.length) {
            System.out.printf("%-2d. %-15s = %3d$    |    %-2d. %-15s = %3d$\n",
                    (i + 1), item[i], harga[i], (i + 2), item[i + 1], harga[i + 1]);
        } else {
            System.out.printf("%-2d. %-15s = %3d$\n", (i + 1), item[i], harga[i]);
        }
    }  
    
    boolean urutlagi = true;
    while(urutlagi==true){
        System.out.print(bgwhite+"Apakah Anda Ingin Mengurutkan Harganya?(y/n)\n= "+resetcolor);
        String pilihan = scan.next();
        if (pilihan.equalsIgnoreCase("y")){
        urut();
        urutlagi = false;
        } else if(pilihan.equalsIgnoreCase("n")){
        urutlagi = false;
        System.out.println("Understandable Have A Great Day!");
        } else {
        System.out.println("Input tidak valid. Silahkan masukkan 'y' atau 'n'.");
        }
    }
    

}

public static int beli(){
    tampillist(); 
    boolean ulang = false;
    String belilagi;
    while(ulang==false){
    System.out.print(bgwhite+"Masukan Kode Barang = "+resetcolor);
    int kodebarang =  scan.nextInt();
    
    while(kodebarang < 1 || kodebarang > 16) {
        System.out.println("\nKode Barang Tidak Valid !\n\n"+bgwhite+"Masukan Kode Barang = "+resetcolor);
        kodebarang =  scan.nextInt();
    }
    
    for(int i = kodebarang ; i < item.length; i++){
        if(kodebarang==i){
            System.out.println("Anda Memilih "+item[i-1]+" Dengan Harga "+harga[i-1]+" $");
        }
    }
    System.out.println(bgwhite+"Masukkan jumlah item = "+resetcolor);
         int jumlah = scan.nextInt();
         int subtotal = harga[kodebarang - 1] * jumlah;
         cartbarang[kodebarang - 1] = item[kodebarang - 1];
         cartjumlah[kodebarang - 1] += jumlah;
         total += subtotal;
    
    System.out.println("Total Anda Adalah = "+total+" $");
    
    boolean lagii = true;
    while(lagii == true){
        System.out.println(bgwhite+"Apakah Anda Ingin Menambah Barang?(y/n)\n= "+resetcolor);
        belilagi = scan.next();
        if(belilagi.equalsIgnoreCase("n")){
            ulang = true; 
            lagii = false;
        } else if(belilagi.equalsIgnoreCase("y")){
            lagii = false;
        } else {
            System.out.println("Input tidak valid. Silahkan masukkan 'y' atau 'n'.");
        }
    }
 }
    
    System.out.println("Total Akhir Anda Adalah = "+total+" $");
    System.out.println("");
    mainMenu();
    return total;
}

public static void cari() {
    boolean ketemu = false;
    boolean carilagi = true;
    String pilihan;
    while(carilagi==true){
    System.out.print(bgwhite+"Silahkan Cari Nama Barang Yang Anda Cari\n= "+resetcolor);
    String key = scan.next();
    for (int i = 0; i < item.length; i++) {
        if (item[i].equalsIgnoreCase(key)) {
                ketemu = true;
            System.out.println("Detail Barang:");
            System.out.println("Nama Barang: " + item[i]);
            System.out.println("Harga: " + harga[i] + " $");
            System.out.println("");
            
            boolean hadeh = false;
            while(hadeh == false){
            System.out.println("Apakah Anda Ingin Mencari Barang Lagi ?(y/n)");
            pilihan = scan.next();
            if(pilihan.equalsIgnoreCase("n")){
                carilagi = false;
                hadeh = true;
            }else if(pilihan.equalsIgnoreCase("y")){
                hadeh = true;
            } else {
                 System.out.println("Input tidak valid. Silahkan masukkan 'y' atau 'n'.");
            }
      }     
    }
 }
    
    if(!ketemu) {
        System.out.println("Barang Tidak Ditemukan!");
        boolean oalah = false;
        while(oalah==false){
            System.out.println("Apakah Anda Ingin Mencari Barang Lagi ?(y/n)");
            pilihan = scan.next();
            if(pilihan.equalsIgnoreCase("y")){
//                carilagi = false;
                  oalah = true;
            }else if(pilihan.equalsIgnoreCase("n")){
                carilagi = false;
                oalah = true;
            }else{
                System.out.println("Input tidak valid. Silahkan masukkan 'y' atau 'n'.");
            }
        }
        
    }
  }
    mainMenu();
}

public static void struk(){
    System.out.println(green+"================================================="+resetcolor);
    System.out.println(bggreen+"TERIMA KASIH SUDAH BERBELANJA DI TOKO SUPERGIANTS"+resetcolor);
    System.out.println(green+"================================================="+resetcolor);
    System.out.println("Barang Yang Anda Beli = ");
        for (int i = 0; i < cartbarang.length; i++) {
        if (cartjumlah[i] > 0) {
            System.out.println("Item " + (i+1) + ": " + cartbarang[i] + " (Jumlah: " + cartjumlah[i] + ")");
        }
    }
        System.out.println("Total Harga = "+total);
        System.out.println("Uang Yang Dibayar = "+uang+" $");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy , HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Waktu Sekarang: " + formattedDateTime);

    
}

public static int cart(){
    System.out.println("Total Anda Adalah = "+total+" $");
    int pilihann,kembalian;
    String pilihan;
    System.out.print("1. Bayar\n2. Tambah Item\n3. Back\n= ");
    pilihann = scan.nextInt();
        switch (pilihann) {
            case 1:
                if(total==0){
                    System.out.println(bgred+"TOTAL YANG HARUS DIBAYAR MASIH KOSONG!\n"+resetcolor);
                    mainMenu();
                }   
                do {
                    System.out.println(bgwhite+"Total Anda Adalah = " + total + " $"+resetcolor);
                    System.out.print("Masukan Jumlah Uang Anda = ");
                    uang = scan.nextInt();
                    
                    if (total > uang) {
                        System.out.println(bgred + "UANG ANDA KURANG SILAHKAN TAMBAH UANGNYA!!!" + resetcolor);
                        System.out.println("");
                    }
                } while (total > uang);
                struk();
                if(uang > total) {
                    kembalian = uang-total;
                    System.out.println(bgwhite+"Kembalian Anda Adalah = "+kembalian+" $"+resetcolor);

                }
                System.out.println("");
                boolean balikmenu = true;
                while(balikmenu==true){
                System.out.println("Apakah Anda Ingin Kembali Ke Menu?(y/n)");
                pilihan = scan.next();
                if(pilihan.equalsIgnoreCase("y")){
                    balikmenu = false;
                    mainMenu();
                }else if(pilihan.equalsIgnoreCase("n")){
                    balikmenu = false;
                    System.exit(0);
                }else{
                    System.out.println("Input tidak valid. Silahkan masukkan 'y' atau 'n'.");
                }
                }
                
                break;
            case 2:
                return beli();
            case 3:
                mainMenu();
                break;
            default:
                System.out.println("Pilihan Tidak Valid. Silakan Pilih Lagi.");
                cart();
        }
        
    return total;
}

public static void urut() {
    System.out.println("Berikut Adalah Urutan Harga Merchandise Kita ");
    Arrays.sort(harga);
    for (int i = 0; i < harga.length; i++) {
        System.out.print(harga[i] + " $ ");
        if (i < harga.length - 1) {
            System.out.print("| ");
        }
    }
    System.out.println("");
}

public static void mainMenu(){
    
    System.out.println(red+"==============================================="+resetcolor);
    System.out.println(whitered+"Selamat Datang Di Toko Merchandise SUPERRGIANTS"+resetcolor);
    System.out.println(red+"==============================================="+resetcolor);
    System.out.print("1. Katalog\n2. Cari Barang\n3. Beli\n4. Cart\n5. Exit");
    System.out.println("");
    System.out.print(bgwhite+"Pilihan Anda = "+resetcolor);
    int menu = scan.nextInt();
    switch (menu) {
        case 1:
            tampillist();
            break;
        case 2:
            cari();
            break;
        case 3:
            beli();
            break;
        case 4:
            cart();
            break;
        case 5:
            System.out.println(bgwhite+"Terima Kasih Telah Berkunjung Di SUPERGIANTS!"+resetcolor);
            System.exit(0);
        default:
            System.out.println("Pilihan Tidak Valid. Silakan Pilih Lagi.");
    }
    mainMenu(); 
}    

public static void main(String[] args) {
        mainMenu();
        
    }
}
