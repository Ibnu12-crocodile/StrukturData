package kursus5;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class KURSUS5 {

    record peserta(String nama, String status, String Gmail, String asal, int Gelombang) {}

    record kursus(String namakursus, String mentor, int materi) {}

    record jadwal(String opsi, String hari, String sesi, String Jam) {}

    record paket(String kategori, String Masapaket, int harga) {}

    record kupon(String kode, String namakupon, int potonganharga) {}

    record pesertadata(String nama, String namakursus, String opsi, String kode) {}
    
    record TransaksiDetail(String namaPeserta, String namakursus, String opsiJadwal, String kategoriPaket, int harga, int bayar, int kembalian) {}
    
  



   
      private static int paketHarga(paket[] listpaket, String kategori) {
        for (paket paket : listpaket) {
            if (paket.kategori.equalsIgnoreCase(kategori)) {
                return paket.harga() ;
            }
        }
        return 0; // Return 0 jika kategori paket tidak ditemukan
    }
    

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

        ArrayList<peserta> listpeserta = new ArrayList<>();
        listpeserta.add(new peserta("Alif", "Pengangguran", "alif1@gmail.com", "Bandung", 1));
        listpeserta.add(new peserta("Asep", "Freelaancer", "asepso@gmail.com", "Jogja", 4));
        listpeserta.add(new peserta("Gresia", "Pelajar", "Gresiachan@gmail.com", "Denpasar", 3));
        listpeserta.add(new peserta("Nana", "Ibu Rumah Tangga", "Nanana12@gmail.com", "Padalarang", 2));
       
                

        kursus[] listkursus = {
            new kursus("Data Analyst", "Uncle Muthu", 10),
            new kursus("Hacker", "Bjorka", 18),
            new kursus("UI/UX", "Messi", 17),
            new kursus("Web developer", "Sule", 17)
        };

        jadwal[] listjadwal = {
            new jadwal("1", "Kamis", "Pagi", "07.30 - 09.00"),
            new jadwal("2", "Kamis", "Malam", "19.30 - 21.00"),
            new jadwal("3", "Minggu", "Pagi", "07.30 - 09.00"),
            new jadwal("4", "Minggu", "Malam", "19.30 - 21.00")
        };

        paket[] listpaket = {
            new paket("A", "1 BULAN", 100000),
            new paket("B", "3 BULAN", 300000),
            new paket("C", "7 BULAN", 600000),
            new paket("D", "1 TAHUN", 900000)
        };

        kupon[] listkupon = {
            new kupon("125", "Ayam", 25000),
            new kupon("349", "Bebek", 50000),
            new kupon("123", "Elang", 75000),
            new kupon("345", "Garuda", 90000),
            
        };

        Stack<kupon> kuponstack = new Stack<>();
        for (kupon kupon1 : listkupon) {
            kuponstack.push(kupon1);
        }

        PriorityQueue<peserta> Antrianpeserta = new PriorityQueue<>(Comparator.comparingInt(peserta::Gelombang));
        
        for (peserta listpeserta1 : listpeserta) {
            Antrianpeserta.add(listpeserta1);
        }
        boolean ulangmenu = true;
        do{
        
            
        System.out.println("==============   WELCOME TO BOOTCAMP IT     ===================");
        System.out.println("                Silahkan Pilih Menu Pilihan                    ");
        System.out.println("===============================================================");
        System.out.println(" 1. Informasi Kursus                                           ");
        System.out.println(" 2. Informasi Peserta                                          ");
        System.out.println(" 3. Pendaftaran peserta baru                                   ");
        System.out.println(" 4. Pendataan dan Pembayaran Peserta                           ");
        System.out.println(" 5. Bantuan                                                    ");
        System.out.println("===============================================================");
        
        System.out.print("=>> ");
                    int MenuAwal = input.nextInt();
                    input.nextLine();
        switch (MenuAwal) {

        case 1:
        System.out.println("==============   WELCOME TO BOOTCAMP IT     ===================");
        System.out.println("===============================================================");
        System.out.println("                  LIST PELAJARAN KURSUS                        ");
        System.out.println("===============================================================");

        for (kursus Pelajaran : listkursus) {
            System.out.println("Pelajaran: " + Pelajaran.namakursus() + ", Mentor: " + Pelajaran.mentor()
                    + ", Jumlah materi: " + Pelajaran.materi());
        }

        System.out.println("===============================================================");
        System.out.println("                  LIST JADWAL KURSUS                           ");
        System.out.println("===============================================================");

        for (jadwal jadwal : listjadwal) {
            System.out.println("Opsi: " + jadwal.opsi() + ", Hari: " + jadwal.hari() + ", Sesi : " + jadwal.sesi() + ", Jam: "
                    + jadwal.Jam());
        }

        System.out.println("===============================================================");
        System.out.println("                  LIST PAKET KURSUS                           ");
        System.out.println("===============================================================");

        for (paket paket : listpaket) {
            System.out.println("Kategori: " + paket.kategori() + ", Paket: " + paket.Masapaket() + ", Harga: " + paket.harga());
        }
          System.out.println("Kembali ke menu utama? (Y/T)");
                            System.out.print("=>> ");
                            String GuestUlang1 = input.next().toUpperCase();
                            ulangmenu = GuestUlang1.equals("Y");
                            break;
        case 2:
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
            
            System.out.println("PENDAFTARAN PESERTA BARU");
            System.out.println("=========================");
            System.out.print("Masukan Nama Anda: ");
            String nama = input.next();
            System.out.print("Apa Status Anda Sekarang: ");
            String status = input.next();
            System.out.print("Masukan Gmail Anda: ");
            String Gmail = input.next();
            System.out.print("Masukan Asal Anda: ");
            String Asal = input.next();
            System.out.print("Masukan Urutan Antrian: ");
            int Gelombang = input.nextInt();
            
             System.out.println("=======================================");
                                System.out.println("Nama : " + nama);
                                System.out.println("Status : " + status);
                                System.out.println("Nomor Kontak : " + Gmail);
                                System.out.println("Asal : " + Asal);
                                System.out.println("Antrian : " + Gelombang);
                                System.out.println("=======================================");
                                
                                listpeserta.add(new peserta(nama, status, Asal, Gmail, Gelombang));
                                System.out.println("=====================================");
                                System.out.println("|   Peserta baru telah ditambahkan   |");
                                System.out.println("=====================================");
                                
                          System.out.println("Kembali ke menu utama? (Y/T)");
                          System.out.print("=>> ");
                          String pilihkembali3 = input.next().toUpperCase();
                          ulangmenu = pilihkembali3.equals("Y");
                          break; 
        
        
        case 4:
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
                        System.out.println("--------------------------------");
                    }
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
                                            System.out.println("--------------------------------");
                                        }
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
                        System.out.println("--------------------------------");
                    }
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
                                            System.out.println("--------------------------------");
                                        }
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
        
       default: // Jika salah masukkan angka
                            System.out.println("Angka yang anda masukkan tidak sesuai.");

                            System.out.println("Kembali ke menu utama? (Y/T)");
                            System.out.print("=>> ");
                            String pilihkembali6 = input.next().toUpperCase();
                            ulangmenu = pilihkembali6.equals("Y");
                            break;} 
        }while(ulangmenu);
        } 
} 

 





                
            
        
         
                        
                  

      
       



              
    

                
            
             
        
    

