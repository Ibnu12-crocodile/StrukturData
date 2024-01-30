package kursusfix;

import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Arrays;


public class KursusFix {
   

    public static void main(String[] args) {
        
        record Kursus(String namakursus, String namaMentor, String jumlahMateri){}
        record Jadwal(String Opsi, String hari, String sesi, String jam){}
        record Paket(String jenis, String Masa, int Harga){}
        record Kupon(String kode, String namakupon,  int potonganharga){}
        record Pendaftaran(String nama,String email, String namakursus, String Opsi, String Masa, int antrian ){}
        record Pembayaran(String email,String[] kode){}
        record Tagihan (int Harga, int potonganharga){}
    
        
        Scanner input = new Scanner(System.in);
        
        
        
        Kursus[] listkursus = new Kursus[4];
        listkursus[0] = new Kursus("WEB DEVELOPER","Fajar S.Kom", "20");
        listkursus[1] = new Kursus("UI UX DESIGN ","Megaasih S.Kom", "22");
        listkursus[2] = new Kursus("MOBILE APPS ","PuantriRahayu S.Kom", "26");
        listkursus[3] = new Kursus("DATA ANALYST","AL Farizi S.Pd.I ", "29");
        
        Jadwal[] listjadwal = new Jadwal[4];
        listjadwal[0] = new Jadwal("1", "Kamis", "Pagi", "08.00 - 10.00");
        listjadwal[1] = new Jadwal("2", "Kamis", "Malam", "20.00 - 22.00");
        listjadwal[2] = new Jadwal("3", "Minggu", "Pagi", "08.00 - 10.00");
        listjadwal[3] = new Jadwal("4", "Minggu", "Malam", "20.00 - 22.00");
        
        Paket[] listpaket = new Paket[4];
        listpaket [0] = new Paket("A","1 BULAN", 100000);
        listpaket [1] = new Paket("B","3 BULAN", 300000);
        listpaket [2] = new Paket("C","5 BULAN", 600000);
        listpaket [3] = new Paket("D","1 TAHUN", 1000000);
        
        Kupon[] listkupon = new Kupon[3];
        listkupon [0] = new Kupon("123","Emas", 75000);
        listkupon [1] = new Kupon("231","Perak", 50000);
        listkupon [2] = new Kupon("321","Perunggu",25000);
        System.out.println("==============   WELCOME TO BOOTCAMP IT     ===================");
        System.out.println("===============================================================");
        System.out.println("                  LIST PELAJARAN KURSUS                        ");
        System.out.println("===============================================================");
        
        for(Kursus Pelajaran : listkursus){
            System.out.println("Pelajaran: " + Pelajaran.namakursus + ", Mentor: " + Pelajaran.namaMentor 
                            + ", Jumlah materi: " + Pelajaran.jumlahMateri);
         }
        System.out.println("===============================================================");
        System.out.println("                  LIST JADWAL KURSUS                           ");
        System.out.println("===============================================================");
        
        for(Jadwal jadwal : listjadwal){
            System.out.println("Opsi: " + jadwal.Opsi + ", Hari: " + jadwal.hari + ", Sesi : " 
                                + jadwal.sesi + ", Jam: " + jadwal.jam);    
        }
        System.out.println("===============================================================");
        System.out.println("                  LIST PAKET KURSUS                            ");
        System.out.println("===============================================================");
        
        for(Paket paket : listpaket){
            System.out.println("Kategori: " + paket.jenis+", Paket: " + paket.Masa + ", Harga: " + paket.Harga );   
        }
        System.out.println("");
         Stack<Kupon> kuponstack = new Stack<>();
        for(int i = 0; i < listkupon.length; i++){
            kuponstack.push(listkupon[i]);
               
        
        }
        System.out.println("");
         System.out.print("Masukan jumlah orang yang mendaftar: ");
        int numPeople = input.nextInt();
        input.nextLine(); // Membersihkan newline
        PriorityQueue<Pendaftaran> peopleQueue = new PriorityQueue<>(Comparator.comparingInt(Pendaftaran::antrian));
        for (int i = 0; i < numPeople; i++) {
            
            System.out.println("");
            System.out.print("Masukkan nama orang ke-" + (i + 1) + ": ");
            String nama = input.nextLine();

            System.out.print("Masukkan Email orang ke-" + (i + 1) + ": ");
            String noHp = input.nextLine();
            
            System.out.print("Masukkan kursus orang ke-" + (i + 1) + ": ");
            String namakursus = input.nextLine();
            
            System.out.print("Masukkan opsi jadwal orang ke-" + (i + 1) + ": ");
            String Opsi = input.nextLine();
            
            System.out.print("Masukkan Kategori paket orang ke-" + (i + 1) + ": ");
            String Masa = input.nextLine();
            
            System.out.print("Masukkan antrian orang ke-" + (i + 1) + ": ");
            int antrian  = input.nextInt();
            
            input.nextLine(); // Membersihkan newline
            
           
       
           peopleQueue.add(new Pendaftaran(nama, noHp, namakursus,Opsi, Masa, antrian));
           
               
            
        System.out.println("___________________________________________________________");
            System.out.println("");
        System.out.println("Peserta: ");
        for (Pendaftaran person : peopleQueue) {
            System.out.println("Nama: " + person.nama() + ", Nomor Hp: " + person.email() );
         
            for (Kursus kursus : listkursus)
                 if (kursus.namakursus.equalsIgnoreCase(person.namakursus())) {
                     
                    System.out.println("Kursus: " + kursus.namakursus + ", Nama Mentor: " + kursus.namaMentor + ", jumlahMateri: " + kursus.jumlahMateri);
                    
            for (Jadwal jadwal : listjadwal)
                if (jadwal.Opsi.equalsIgnoreCase(person.Opsi())) {
                    
                    System.out.println("Opsi: " + jadwal.Opsi + ", Hari: " + jadwal.hari + ", Sesi: " + jadwal.sesi + ", Jam: " + jadwal.jam);
            
            for (Paket paket : listpaket)
                if (paket.Masa.equalsIgnoreCase(person.Masa())) {
                   
                    System.out.println("Kategori: " + paket.jenis + ", Paket: " + paket.Masa +", Harga: " + paket.Harga);
             
           
             
             input.nextLine();
                }            
           
            
            
                         
            
                }
            }
            
                    
            
            
            
        }
        
        
             
           
            
             
             
                
          
         
                    
           
                    
             
                    
                    
            
            
                }
           }
    
            
            
            
            

                    
                    
                    
                } 
                
               
                
                
            
           
                
                
            
         
         
            
        
        

