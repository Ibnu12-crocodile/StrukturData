

package kursusfix1;

// Sruktur Program 

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class KursusFix1 {
// Record Untuk Menyimpan data
    record peserta(String nama, String status, String Gmail, String asal, int Gelombang) {}

    record kursus(String namakursus, String mentor, int materi) {}

    record jadwal(String opsi, String hari, String sesi, String Jam) {}

    record paket(String kategori, String Masapaket, int harga) {}

    record kupon(String kode, String namakupon, int potonganharga) {}

    record pesertadata(String nama, String namakursus, String opsi, String kode) {}
    
    record TransaksiDetail(String namaPeserta, String namakursus, String opsiJadwal, String kategoriPaket, int harga, int bayar, int kembalian) {}
    
    record pesertabaru (String nama, String status, String Gmail, String asal, int Gelombang) {}
   // Pemnaggilan paket harga 
      private static int paketHarga(paket[] listpaket, String kategori) {
        for (paket paket : listpaket) {
            if (paket.kategori.equalsIgnoreCase(kategori)) {
                return paket.harga() ;
            }
        }
        return 0; // Return 0 jika kategori paket tidak ditemukan
    }
    
// Pemanggilan paket harga untuk kupon
    private static int paketHargaSetelahDiskon(paket[] listpaket, String kategori, kupon kupon) {
        for (paket paket : listpaket) {
            if (paket.kategori.equalsIgnoreCase(kategori)) {
                return paket.harga() - kupon.potonganharga();
            }
        }
        return 0; // Return 0 jika kategori paket tidak ditemukan
    }
    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
 // Data peserta
        ArrayList<peserta> listpeserta = new ArrayList<>();
        listpeserta.add(new peserta("Alif", "Pengangguran", "alif1@gmail.com", "Bandung", 1));
        listpeserta.add(new peserta("Asep", "Freelaancer", "asepso@gmail.com", "Jogja", 4));
        listpeserta.add(new peserta("Gresia", "Pelajar", "Gresiachan@gmail.com", "Denpasar", 3));
        listpeserta.add(new peserta("Nana", "Ibu Rumah Tangga", "Nanana12@gmail.com", "Padalarang", 2));
        listpeserta.add(new peserta("Mimi", "Karyawan", "karyajaya@gmail.com", "Aceh", 5));
        listpeserta.add(new peserta("John", "Mahasiswa", "joe222@gmail.com", "Bekasi", 7));
        listpeserta.add(new peserta("Alex", "Mahasiswa", "oldlex@gmail.com", "Banjarmasin", 6));
// Data kursus
        kursus[] listkursus = {
            new kursus("Data Analyst", "Uncle Muthu", 10),
            new kursus("Hacker", "Bjorka", 18),
            new kursus("UI/UX", "Messi", 17),
            new kursus("Web developer", "Sule", 17)
        };
// Data jadwal
        jadwal[] listjadwal = {
            new jadwal("1", "Kamis", "Pagi", "07.30 - 09.00"),
            new jadwal("2", "Kamis", "Malam", "19.30 - 21.00"),
            new jadwal("3", "Minggu", "Pagi", "07.30 - 09.00"),
            new jadwal("4", "Minggu", "Malam", "19.30 - 21.00")
        };
// Data paket
        paket[] listpaket = {
            new paket("A", "1 BULAN", 100000),
            new paket("B", "3 BULAN", 300000),
            new paket("C", "7 BULAN", 600000),
            new paket("D", "1 TAHUN", 900000)
        };
//Data kupon
        kupon[] listkupon = {
            new kupon("125", "Ayam", 25000),
            new kupon("349", "Bebek", 50000),
            new kupon("123", "Elang", 75000),
            new kupon("345", "Garuda", 90000),
            
        };
// Kupon dimasukan kedalam kuponsstack
        Stack<kupon> kuponstack = new Stack<>();
        for (kupon kupon1 : listkupon) {
            kuponstack.push(kupon1);
        }
// Peserta dimasukan ke dalam Antrianpeserta
        PriorityQueue<peserta> Antrianpeserta = new PriorityQueue<>(Comparator.comparingInt(peserta::Gelombang));
        for (peserta listpeserta2 : listpeserta) {
            Antrianpeserta.add(listpeserta2);
        }
        // boleean dan do while untuk pengulangan menu
        boolean ulangmenu = true;
        do{
        
            
        System.out.println("==============   WELCOME TO BOOTCAMP IT     ===================");
        System.out.println("                Silahkan Pilih Menu Pilihan                    ");
        System.out.println("===============================================================");
        System.out.println(" 1. Informasi Kursus                                           ");
        System.out.println(" 2. Informasi Peserta                                          ");
        System.out.println(" 3. Pendataan dan Pembayaran peserta                                    ");
        System.out.println("===============================================================");
        
        System.out.print("=>> ");
                    int MenuAwal = input.nextInt();
                    input.nextLine();
        switch (MenuAwal) {

     case 1:
    // program untuk menampilkan informasi kursus
         System.out.println("");
    System.out.println("==============   WELCOME TO BOOTCAMP IT     ===================");
    System.out.println("");
    System.out.println("========================================================");
    System.out.println("|                 LIST PELAJARAN KURSUS                |");
    System.out.println("========================================================");
    System.out.println("| No. | Pelajaran       | Mentor       | Jumlah Materi |");
    System.out.println("========================================================");
    for (int i = 0; i < listkursus.length; i++) {
        kursus kursus = listkursus[i];
        System.out.printf("| %-3d | %-15s | %-12s | %-13d |\n", i+1, kursus.namakursus(), kursus.mentor(), kursus.materi());
    }
    System.out.println("========================================================");
    System.out.println("");
    System.out.println("===============================================");
    System.out.println("|               JADWAL KURSUS                 |");
    System.out.println("===============================================");
    System.out.println("| No. | Opsi | Hari   | Sesi  | Jam           |");
    System.out.println("===============================================");
    for (int i = 0; i < listjadwal.length; i++) {
        jadwal jadwal = listjadwal[i];
        System.out.printf("| %-3d | %-4s | %-6s | %-5s | %-10s |\n", i+1, jadwal.opsi(), jadwal.hari(), jadwal.sesi(), jadwal.Jam());
    }
    System.out.println("===============================================");
    System.out.println("");
    System.out.println("============================================");
    System.out.println("|            LIST PAKET KURSUS             |");
    System.out.println("============================================");
    System.out.println("| No. | Kategori | Masa Paket | Harga      |");
    System.out.println("============================================");
    for (int i = 0; i < listpaket.length; i++) {
        paket paket = listpaket[i];
        System.out.printf("| %-3d | %-8s | %-10s | %-10d |\n", i+1, paket.kategori(), paket.Masapaket(), paket.harga());
    }
    System.out.println("=============================================");
    System.out.println("Kembali ke menu utama? (Y/T)");
    System.out.print("=>> ");
    String GuestUlang1 = input.next().toUpperCase();
    ulangmenu = GuestUlang1.equals("Y");
    break;


        case 2:
                // program untuk menampilkan peserta
                               System.out.println("==================================================================================");
                               System.out.println("                               LIST PESERTA                                       ");
                               System.out.println("==================================================================================");
                                 for (peserta Peserta : listpeserta) {
                                     System.out.println( "Nama: " + Peserta.nama());
                                     System.out.println("Asal: " + Peserta.asal());
                                     System.out.println("Status: " + Peserta.status());
                                     System.out.println("Gmail: " + Peserta.Gmail());
                                     System.out.println("Antrian: " + Peserta.Gelombang());
                                     System.out.println("");
                                }
                                System.out.println("==================================================================================================================================");
                                System.out.println("Kembali ke menu utama? (Y/T)");
                                System.out.print("=>> ");
                                String pilihkembali2 = input.next().toUpperCase();
                                ulangmenu = pilihkembali2.equals("Y");
                                break;   
        
       
        
            
         
        case 3:
                // program untuk pendataan dan pembayaran

        // List Untuk mencetak transaksi
        List<TransaksiDetail> riwayatTransaksiKupon = new ArrayList<>();
        while (!Antrianpeserta.isEmpty()) { 
            peserta pesertacek = Antrianpeserta.poll();
            System.out.println("");
            System.out.println("Nama: " + pesertacek.nama() + ", Status: " + pesertacek.status() + ", Asal: "
                                          + pesertacek.asal());
            System.out.println("Pilih kursus(Y/T)");
            System.out.print("=> ");
            String pilih = input.nextLine();
            
            if ("Y".equals(pilih)) {
                System.out.print("Masukan Nama Pelajaran Kursus Yang Anda Pilih: ");
                String namakursus1 = input.nextLine();
                System.out.print("Masukan Opsi Jadwal Kursus Yang Anda Pilih: ");
                String Opsi1 = input.nextLine();
                System.out.print("Masukan Kategori Paket Kursus Yang Anda Pilih: ");
                String kategori1 = input.nextLine();

                for (kursus kursus : listkursus)
                    if (kursus.namakursus().equalsIgnoreCase(namakursus1)) {
                        System.out.println("");
                        System.out.println("Kursus: " + kursus.namakursus() + ", Nama Mentor: " + kursus.mentor()
                                + ", jumlahMateri: " + kursus.materi());
                    }
                for (jadwal jadwal : listjadwal)
                    if (jadwal.opsi().equalsIgnoreCase(Opsi1)) {
                        System.out.println("Opsi: " + jadwal.opsi() + ", Hari: " + jadwal.hari() + ", Sesi: " + jadwal.sesi()
                                + ", Jam: " + jadwal.Jam());
                    }
                for (paket paket : listpaket)
                    if (paket.kategori().equalsIgnoreCase(kategori1)) {
                        System.out.println(
                                "Kategori: " + paket.kategori() + ", Paket: " + paket.Masapaket() + ", Harga: " + paket.harga());
                    }
          if(kuponstack.isEmpty()) {
            System.out.println("==========================");
            System.out.println("| MAAF KUPON TELAH HABIS |");
            System.out.println("==========================");
              int hargaPaketTanpaKupon = paketHarga(listpaket, kategori1);
                System.out.println("--------------------------------");
                System.out.println("Harga Paket setelah Potongan Harga Kupon: " + hargaPaketTanpaKupon);
                
              
                System.out.println("");
                System.out.print("Masukkan Jumlah Pembayaran Anda: ");
                int bayar = input.nextInt();
                input.nextLine();  // membersihkan newline character

                if (bayar >= hargaPaketTanpaKupon) {
                    // Kurangi jumlah yang harus dibayar dari pembayaran yang diterima
                    int kembalian = bayar - hargaPaketTanpaKupon;
                    System.out.println("");
                    System.out.println("Pembayaran berhasil. Terima kasih!");
                    System.out.println("Kembalian Anda: " + kembalian);
                    System.out.println("--------------------------------");

                    // Menambahkan transaksi ke riwayat dengan kupon
                    TransaksiDetail transaksiDetail = new TransaksiDetail(
                            pesertacek.nama(),
                            namakursus1,
                            Opsi1,
                            kategori1,
                            hargaPaketTanpaKupon,
                            bayar,
                            kembalian
                    );
                    riwayatTransaksiKupon.add(transaksiDetail);

                    // Mencetak riwayat transaksi dengan kupon
                    System.out.println("============================================");
                    System.out.println("|         Riwayat Transaksi Anda           |");
                    System.out.println("============================================");
                    for (TransaksiDetail transaksi : riwayatTransaksiKupon) {
                        System.out.println("Nama Peserta: " + transaksi.namaPeserta());
                        System.out.println("Nama Kursus: " + transaksi.namakursus());
                        System.out.println("Opsi Jadwal: " + transaksi.opsiJadwal());
                        System.out.println("Kategori Paket: " + transaksi.kategoriPaket());
                        System.out.println("Harga Paket: " + transaksi.harga());
                        System.out.println("Jumlah Pembayaran: " + transaksi.bayar());
                        System.out.println("Kembalian: " + transaksi.kembalian());
                         System.out.println("---------------------------------------------");
                    }
                    riwayatTransaksiKupon.removeAll(riwayatTransaksiKupon);
                } else {
                    boolean pembayaranCukup = false;

                            while (!pembayaranCukup) {
                                System.out.println("");
                                System.out.println("Pembayaran kurang. Apakah Anda ingin melakukan pembayaran lagi? (Y/T)");
                                System.out.print("=> ");
                                String pilihanPembayaranLagi = input.nextLine();

                                if ("Y".equalsIgnoreCase(pilihanPembayaranLagi)) {
                                    System.out.print("Masukkan Jumlah Pembayaran Anda: ");
                                    int bayarLagi = input.nextInt();
                                    input.nextLine();  // membersihkan newline character

                                    if (bayarLagi >= hargaPaketTanpaKupon) {
                                        // Kurangi jumlah yang harus dibayar dari pembayaran yang diterima
                                        int kembalianLagi = bayarLagi - hargaPaketTanpaKupon;
                                        System.out.println("");
                                        System.out.println("Pembayaran berhasil. Terima kasih!");
                                        System.out.println("Kembalian Anda: " + kembalianLagi);
                                        System.out.println("--------------------------------");

                                        // Menandai bahwa pembayaran sudah cukup
                                        pembayaranCukup = true;

                                        // Menambahkan transaksi ke riwayat dengan kupon
                                        TransaksiDetail transaksiDetailLagi = new TransaksiDetail(
                                                pesertacek.nama(),
                                                namakursus1,
                                                Opsi1,
                                                kategori1,
                                                hargaPaketTanpaKupon,
                                                bayarLagi,
                                                kembalianLagi
                                        );
                                          riwayatTransaksiKupon.add(transaksiDetailLagi);
                                        // Mencetak riwayat transaksi dengan kupon
                                        System.out.println("============================================");
                                        System.out.println("|         Riwayat Transaksi Anda           |");
                                        System.out.println("============================================");
                                        for (TransaksiDetail transaksi : riwayatTransaksiKupon) {
                                            System.out.println("Nama Peserta: " + transaksi.namaPeserta());
                                            System.out.println("Nama Kursus: " + transaksi.namakursus());
                                            System.out.println("Opsi Jadwal: " + transaksi.opsiJadwal());
                                            System.out.println("Kategori Paket: " + transaksi.kategoriPaket());
                                            System.out.println("Harga Paket: " + transaksi.harga());
                                            System.out.println("Jumlah Pembayaran: " + transaksi.bayar());
                                            System.out.println("Kembalian: " + transaksi.kembalian());
                                             System.out.println("---------------------------------------------");
                                        }
                                          riwayatTransaksiKupon.removeAll(riwayatTransaksiKupon);
                                    } else {
                                        // Informasikan pengguna bahwa pembayaran masih kurang
                                        System.out.println("");
                                        System.out.println("Pembayaran kurang. Silakan lakukan pembayaran sesuai dengan total harga.");
                                        System.out.println("--------------------------------");
                                    }
                                } else if ("T".equalsIgnoreCase(pilihanPembayaranLagi)) {
                                    // Jika pengguna tidak ingin mencoba lagi, keluar dari loop
                                    break;
                                } else {
                                    // Jika input tidak valid, minta input kembali
                                    System.out.println("Input tidak valid. Masukkan Y untuk ya atau T untuk tidak.");
                                }
                            }

                } 
            
        } else {
                kupon kupon1 = kuponstack.pop();
                System.out.println("");
                System.out.println("==================================");
                System.out.println("| SELAMAT ANDA MENDAPATKAN KUPON |");
                System.out.println("==================================");
                System.out.println("");
                System.out.println("Kode: " + kupon1.kode());
                System.out.println("Nama Kupon: " + kupon1.namakupon());
                System.out.println("Potongan Harga: " + kupon1.potonganharga());
                
          
                // Hitung harga paket setelah potongan harga kupon
                int hargaSetelahDiskon = paketHargaSetelahDiskon(listpaket, kategori1, kupon1);
                System.out.println("--------------------------------");
                System.out.println("Harga Paket setelah Potongan Harga Kupon: " + hargaSetelahDiskon);
                
              
                System.out.println("");
                System.out.print("Masukkan Jumlah Pembayaran Anda: ");
                int bayar = input.nextInt();
                input.nextLine();  // membersihkan newline character

                if (bayar >= hargaSetelahDiskon) {
                    // Kurangi jumlah yang harus dibayar dari pembayaran yang diterima
                    int kembalian = bayar - hargaSetelahDiskon;
                    System.out.println("");
                    System.out.println("Pembayaran berhasil. Terima kasih!");
                    System.out.println("Kembalian Anda: " + kembalian);
                    System.out.println("--------------------------------");

                    // Menambahkan transaksi ke riwayat dengan kupon
                    TransaksiDetail transaksiDetail = new TransaksiDetail(
                            pesertacek.nama(),
                            namakursus1,
                            Opsi1,
                            kategori1,
                            hargaSetelahDiskon,
                            bayar,
                            kembalian
                    );
                    riwayatTransaksiKupon.add(transaksiDetail);

                    // Mencetak riwayat transaksi dengan kupon
                    System.out.println("============================================");
                    System.out.println("|         Riwayat Transaksi Anda           |");
                    System.out.println("============================================");
                    for (TransaksiDetail transaksi : riwayatTransaksiKupon) {
                        System.out.println("Nama Peserta: " + transaksi.namaPeserta());
                        System.out.println("Nama Kursus: " + transaksi.namakursus());
                        System.out.println("Opsi Jadwal: " + transaksi.opsiJadwal());
                        System.out.println("Kategori Paket: " + transaksi.kategoriPaket());
                        System.out.println("Harga Paket: " + transaksi.harga());
                        System.out.println("Jumlah Pembayaran: " + transaksi.bayar());
                        System.out.println("Kembalian: " + transaksi.kembalian());
                    System.out.println("---------------------------------------------");
                    }
                      riwayatTransaksiKupon.removeAll(riwayatTransaksiKupon);
                } else {
                    boolean pembayaranCukup = false;

                            while (!pembayaranCukup) {
                                System.out.println("");
                                System.out.println("Pembayaran kurang. Apakah Anda ingin melakukan pembayaran lagi? (Y/T)");
                                System.out.print("=> ");
                                String pilihanPembayaranLagi = input.nextLine();

                                if ("Y".equalsIgnoreCase(pilihanPembayaranLagi)) {
                                    System.out.print("Masukkan Jumlah Pembayaran Anda: ");
                                    int bayarLagi = input.nextInt();
                                    input.nextLine();  // membersihkan newline character

                                    if (bayarLagi >= hargaSetelahDiskon) {
                                        // Kurangi jumlah yang harus dibayar dari pembayaran yang diterima
                                        int kembalianLagi = bayarLagi - hargaSetelahDiskon;
                                        System.out.println("");
                                        System.out.println("Pembayaran berhasil. Terima kasih!");
                                        System.out.println("Kembalian Anda: " + kembalianLagi);
                                        System.out.println("--------------------------------");

                                        // Menandai bahwa pembayaran sudah cukup
                                        pembayaranCukup = true;

                                        // Menambahkan transaksi ke riwayat dengan kupon
                                        TransaksiDetail transaksiDetailLagi = new TransaksiDetail(
                                                pesertacek.nama(),
                                                namakursus1,
                                                Opsi1,
                                                kategori1,
                                                hargaSetelahDiskon,
                                                bayarLagi,
                                                kembalianLagi
                                        );
                                         riwayatTransaksiKupon.add(transaksiDetailLagi);
                                        // Mencetak riwayat transaksi dengan kupon
                                        System.out.println("============================================");
                                        System.out.println("|         Riwayat Transaksi Anda           |");
                                        System.out.println("============================================");
                                        for (TransaksiDetail transaksi : riwayatTransaksiKupon) {
                                            System.out.println("Nama Peserta: " + transaksi.namaPeserta());
                                            System.out.println("Nama Kursus: " + transaksi.namakursus());
                                            System.out.println("Opsi Jadwal: " + transaksi.opsiJadwal());
                                            System.out.println("Kategori Paket: " + transaksi.kategoriPaket());
                                            System.out.println("Harga Paket: " + transaksi.harga());
                                            System.out.println("Jumlah Pembayaran: " + transaksi.bayar());
                                            System.out.println("Kembalian: " + transaksi.kembalian());
                                            System.out.println("-----------------------------------------");
                                        }
                                          riwayatTransaksiKupon.removeAll(riwayatTransaksiKupon);
                                    } else {
                                        // Informasikan pengguna bahwa pembayaran masih kurang
                                        System.out.println("");
                                        System.out.println("Pembayaran kurang. Silakan lakukan pembayaran sesuai dengan total harga.");
                                        System.out.println("--------------------------------");
                                    }
                                } else if ("T".equalsIgnoreCase(pilihanPembayaranLagi)) {
                                    // Jika pengguna tidak ingin mencoba lagi, keluar dari loop
                                    break;
                                } else {
                                    // Jika input tidak valid, minta input kembali
                                    System.out.println("Input tidak valid. Masukkan Y untuk ya atau T untuk tidak.");
                                }
                            }

                } 
                
            } 
        }
        }
                            System.out.println("");
                            System.out.println("Kembali ke menu utama? (Y/T)");
                            System.out.print("=>> ");
                            String pilihkembali7 = input.next().toUpperCase();
                            ulangmenu = pilihkembali7.equals("Y");
                            break;
                            
        default :
            System.out.println("");
                            System.out.println("Pilihan Anda salah");
                            System.out.println("Kembali ke menu awal(Y/T)");
                            System.out.print("=>> ");
                            String pilihkembali08 = input.next().toUpperCase();
                            ulangmenu = pilihkembali08.equals("Y");
                            break;
                            
        }
                            
         
        
       
        
        
        
        
         
        }while(ulangmenu);
        }
    
    
} 

 





                
            
        
         
                        
                  

      
       



              
    

                
            
             
        
    
