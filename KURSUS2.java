package com.mycompany.kursus2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class KURSUS2 {

    record peserta(String nama, String status, String nomorHp, String asal, int Gelombang) {}

    record kursus(String namakursus, String mentor, int materi) {}

    record jadwal(String opsi, String hari, String sesi, String Jam) {}

    record paket(String kategori, String Masapaket, int harga) {}

    record kupon(String kode, String namakupon, int potonganharga) {}

    record pesertadata(String nama, String namakursus, String opsi, String kode) {}
    
    record TransaksiDetail(String namaPeserta, String namakursus, String opsiJadwal, String kategoriPaket, int harga, int bayar, int kembalian) {}
    
    private static void cetakDetailTransaksiTanpaKupon(TransaksiDetail transaksi) {
    
    System.out.println("Nama Peserta: " + transaksi.namaPeserta());
    System.out.println("Nama Kursus: " + transaksi.namakursus());
    System.out.println("Opsi Jadwal: " + transaksi.opsiJadwal());
    System.out.println("Kategori Paket: " + transaksi.kategoriPaket());
    System.out.println("Harga Paket: " + transaksi.harga());
    System.out.println("Jumlah Pembayaran: " + transaksi.bayar());
    System.out.println("Kembalian: " + transaksi.kembalian());
    System.out.println("--------------------------------");
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

        peserta[] listpeserta = {
            new peserta("Alif", "Pengangguran", "082130987645", "Bandung", 1),
            new peserta("Asep", "Freelaancer", "082176897654", "Jogja", 4),
            new peserta("John", "Mahasiswa", "082198654329", "Bekasi", 2),
            new peserta("Gresia", "Pelajar", "082182739408", "Denpasar", 3),
            new peserta("Nana", "Ibu Rumah Tangga", "082127389287", "Padalarang", 2),
            new peserta("Mimi", "Karyawan", "082172839876", "Aceh", 1)
        };

        kursus[] listkursus = {
            new kursus("Tata Boga", "Uncle Muthu", 10),
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
            new kupon("098", "Garuda", 75000),
            new kupon("123", "Merpati", 50000),
            new kupon("345", "Ayam", 25000)
        };

        Stack<kupon> kuponstack = new Stack<>();
        for (kupon kupon1 : listkupon) {
            kuponstack.push(kupon1);
        }

        PriorityQueue<peserta> Antrianpeserta = new PriorityQueue<>(Comparator.comparingInt(peserta::Gelombang));
        
        for (peserta listpeserta1 : listpeserta) {
            Antrianpeserta.add(listpeserta1);
        }

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

                System.out.println("");
                System.out.println("Pilih Kupon (Y/T)");
                System.out.print("=>");
                String pilih1 = input.nextLine();
                
                if ("Y".equals(pilih1)) {
                    System.out.println("Masukkan kode kupon: ");
                    System.out.print("=>");
                    String kode = input.nextLine();
                    String[] listKode = kode.split(", ");
                    LinkedList<String> listKodeValid = new LinkedList<>();

                    for (String currentKode : listKode) {
                        boolean kuponDitemukan = false;
                        int jumlahkupon = kuponstack.size();
                        Stack<kupon> temporaryStack = new Stack<>();

                        for (int i = 0; i < jumlahkupon; i++) {
                            kupon kupon1 = kuponstack.pop();

                           if (kupon1.kode().equals(currentKode)) {
                System.out.println("   ");
                System.out.println("Kupon: " + currentKode + " Ada:");
                System.out.println("Kode: " + kupon1.kode());
                System.out.println("Nama Kupon: " + kupon1.namakupon());
                System.out.println("Potongan Harga: " + kupon1.potonganharga());

                kuponDitemukan = true;

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
                break;
            }
        }

                        while (!temporaryStack.isEmpty()) {
                            kuponstack.push(temporaryStack.pop());
                        }

                        if (!kuponDitemukan) {
                            System.out.println("");
                            System.out.println("Maaf Kupon Anda " + currentKode + " Tidak ada");
                            
                            
                             System.out.print("Masukkan Jumlah Pembayaran Anda: ");
                                    int bayar = input.nextInt();
                                    input.nextLine();  // Hapus karakter newline

                                    // Hitung total harga tanpa diskon
                                    int hargaSetelahDiskon = paketHargaSetelahDiskon(listpaket, kategori1, new kupon("", "", 0));
                               
                                    if (bayar >= hargaSetelahDiskon) {
                                        // Lanjutkan dengan pembayaran
                                        int kembalian = bayar - hargaSetelahDiskon;
                                        System.out.println("");
                                        System.out.println("Pembayaran berhasil. Terima kasih!");
                                        System.out.println("Kembalian Anda: " + kembalian);
                                        System.out.println("--------------------------------");
                                        
                                         TransaksiDetail transaksiDetailTanpaKupon = new TransaksiDetail(
                                        pesertacek.nama(),
                                        namakursus1,
                                        Opsi1,
                                        kategori1,
                                        hargaSetelahDiskon,
                                        bayar,
                                        (bayar >= hargaSetelahDiskon) ? bayar - hargaSetelahDiskon : 0
                                );

                                // Mencetak riwayat transaksi tanpa kupon
                                    // Mencetak riwayat transaksi tanpa kupon
                                                        System.out.println("===========================================");
                                                        System.out.println("|         Riwayat Transaksi Anda          |");
                                                        System.out.println("===========================================");
                                                        cetakDetailTransaksiTanpaKupon(transaksiDetailTanpaKupon);
                                                        System.out.println("===========================================");

                                    } else {
                                        // Informasikan pengguna bahwa pembayaran tidak mencukupi
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
                            } else {
                              System.out.println("");
                                    System.out.println("Maaf tidak ada diskon karena Anda tidak memilih kupon.");

                                    // Lanjutkan dengan pembayaran tanpa diskon
                                    System.out.print("Masukkan Jumlah Pembayaran Anda: ");
                                    int bayar = input.nextInt();
                                    input.nextLine();  // Hapus karakter newline

                                    // Hitung total harga tanpa diskon
                                    int hargaSetelahDiskon = paketHargaSetelahDiskon(listpaket, kategori1, new kupon("", "", 0));

                                    if (bayar >= hargaSetelahDiskon) {
                                        // Lanjutkan dengan pembayaran
                                        int kembalian = bayar - hargaSetelahDiskon;
                                        System.out.println("");
                                        System.out.println("Pembayaran berhasil. Terima kasih!");
                                        System.out.println("Kembalian Anda: " + kembalian);
                                        System.out.println("--------------------------------");

                                        // Menambahkan transaksi ke riwayat tanpa kupon
                                        TransaksiDetail transaksiDetailTanpaKupon = new TransaksiDetail(
                                                pesertacek.nama(),
                                                namakursus1,
                                                Opsi1,
                                                kategori1,
                                                hargaSetelahDiskon,
                                                bayar,
                                                (bayar >= hargaSetelahDiskon) ? bayar - hargaSetelahDiskon : 0
                                        );

                                        // Mencetak riwayat transaksi tanpa kupon
                                        System.out.println("===========================================");
                                        System.out.println("|         Riwayat Transaksi Anda          |");
                                        System.out.println("===========================================");
                                        cetakDetailTransaksiTanpaKupon(transaksiDetailTanpaKupon);
                                        System.out.println("===========================================");
                                    } else {
                                        // Informasikan pengguna bahwa pembayaran tidak mencukupi
                                        boolean pembayaranCukupTanpaKupon = false;

                                            while (!pembayaranCukupTanpaKupon) {
                                                System.out.println("");
                                                System.out.println("Pembayaran kurang. Apakah Anda ingin melakukan pembayaran lagi? (Y/T)");
                                                System.out.print("=> ");
                                                String pilihanPembayaranLagiTanpaKupon = input.nextLine();

                                                if ("Y".equalsIgnoreCase(pilihanPembayaranLagiTanpaKupon)) {
                                                    System.out.print("Masukkan Jumlah Pembayaran Anda: ");
                                                    int bayarTanpaKupon = input.nextInt();
                                                    input.nextLine();  // membersihkan newline character

                                                    if (bayarTanpaKupon >= hargaSetelahDiskon) {
                                                        // Kurangi jumlah yang harus dibayar dari pembayaran yang diterima
                                                        int kembalianTanpaKupon = bayarTanpaKupon - hargaSetelahDiskon;
                                                        System.out.println("");
                                                        System.out.println("Pembayaran berhasil. Terima kasih!");
                                                        System.out.println("Kembalian Anda: " + kembalianTanpaKupon);
                                                        System.out.println("--------------------------------");

                                                        // Menandai bahwa pembayaran sudah cukup
                                                        pembayaranCukupTanpaKupon = true;

                                                        // Menambahkan transaksi ke riwayat tanpa kupon
                                                        TransaksiDetail transaksiDetailTanpaKupon = new TransaksiDetail(
                                                                pesertacek.nama(),
                                                                namakursus1,
                                                                Opsi1,
                                                                kategori1,
                                                                hargaSetelahDiskon,
                                                                bayarTanpaKupon,
                                                                kembalianTanpaKupon
                                                        );

                                                        // Mencetak riwayat transaksi tanpa kupon
                                                        System.out.println("===========================================");
                                                        System.out.println("|         Riwayat Transaksi Anda          |");
                                                        System.out.println("===========================================");
                                                        cetakDetailTransaksiTanpaKupon(transaksiDetailTanpaKupon);
                                                        System.out.println("===========================================");
                                                    } else {
                                                        // Informasikan pengguna bahwa pembayaran masih kurang
                                                        System.out.println("");
                                                        System.out.println("Pembayaran kurang. Silakan lakukan pembayaran sesuai dengan total harga.");
                                                        System.out.println("--------------------------------");
                                                    }
                                                } else if ("T".equalsIgnoreCase(pilihanPembayaranLagiTanpaKupon)) {
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
    }
}           
        

      
       



              
    

                
            
             
        
    

