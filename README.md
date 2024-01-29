# Final Proyek Struktur Data
<ul>
  <li>Mata Kuliah: Struktur Data</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Kelompok

<ul>
  <li>Kelompok: 1 </li>
  <li>Proyek: Sistem Kursus</li>
  <li>Anggota:</li>
  <ul>
    <li>Ketua: <a href="https://github.com/Ibnu12-crocodile">Ibnu Rasyid Assidiq</a></li>
    <li>Anggota 1: <a href="">Rachel Simanjuntak</a></li>
    <li>Anggota 2: <a href="">Luthfi Febrian</a></li>
  </ul>
</ul>

## Judul Proyek
<p>Sistem Kursus.</p>

## Penjelasan Proyek
<p>
Sistem kursus yang kami buat diberi nama <b>BOOTCAMP IT</b> yang dimana bootcamp ini berisi pelajaran pelajaran
yang berkaitan dengan teknologi atau dunia computer, di BOOTCAMP IT ini kami menyediakan banyak pelajaran yaitu :<br>
<br>
<ol>
<li>Hacker<br>
<li>Web Developer</li>
<li>UI/UX Design</li>
<li>Data Analyst</li>
<ol>
<br>
Selain itu juga kami membuat jadwal pelajaran kursus yang terpisah dari pelajaran, hal ini dibuat karena kami ingin adanya fleksibilitas waktu, yang dimana para peserta tidak terpaut oleh waktu yang ditentukan dan bebas memilih pelajaran sesuai waktu yang diinginkan, Untuk jadwal yang kami sediakan berdasarkan Opsi, Hari, Sesi, dan Jam. Jadwal yang kami sediakan adalah:<br>
<br>
<table border ="1">
  <tr>
    <th>Opsi</th>
    <th>Hari</th>
    <th>Sesi</th>
    <th>Jam</th>
  </tr>
  <tr>
    <td>1</td>
    <td>Kamis</td>
    <td>Pagi</td>
    <td>07.30 - 09.00</td>
  </tr>
   <tr>
    <td>2</td>
    <td>Kamis</td>
    <td>Malam</td>
    <td>19.30 - 21.00</td>
  </tr>
   <tr>
    <td>3</td>
    <td>Minggu</td>
    <td>Pagi</td>
    <td>07.30 - 09.00</td>
  </tr>
   <tr>
    <td>4</td>
    <td>Minggu</td>
    <td>Malam</td>
    <td>19.30 - 21.00</td>
  </tr>
</table>
<br>
<p>Untuk harga pelajaran kursus kami menyediakan beberapa kategori paket yang berdasarkan kategori paket, Masa paket, dan Harga paket. Paket yang kami sediakan adalah sebagai berikut:</p>
<br>
<table border ="1">
  <tr>
    <th>Kategori</th>
    <th>Masa</th>
    <th>Harga</th>
  </tr>
  <tr>
    <td>A</td>
    <td>1 Bulan</td>
    <td>100.000</td>
  </tr>
   <tr>
    <td>B</td>
    <td>3 Bulan</td>
    <td>300.000</td>
  </tr>
   <tr>
    <td>C</td>
    <td>7 Bulan</td>
    <td>600.000</td>   
  </tr>
   <tr>
    <td>D</td>
    <td>1 Tahun</td>
    <td>900.000</td>
  </tr>
</table>

<br>
  <p>Dan di kursus ini juga kami menyediakan kupon untuk para peserta sehingga peserta yang memiliki kupon dan mendapat potongan harga disini kami menyediakan 4 kupon, kupon akan diberi sesuai dengan Antrian peserta, dan berikut adalah kupon yang kami sediakan</p><br>
<br>
<table border ="1">
  <tr>
    <th>Kode</th>
    <th>Nama Kupon</th>
    <th>Potongan Harga</th>
  </tr>
  <tr>
    <td>125</td>
    <td>Ayam</td>
    <td>25.000</td>
  </tr>
   <tr>
    <td>349</td>
    <td>Bebek</td>
    <td>50.000</td>
  </tr>
   <tr>
    <td>123</td>
    <td>Elang</td>
    <td>75.000</td>   
  </tr>
   <tr>
    <td>345</td>
    <td>Garuda</td>
    <td>90.000</td>
  </tr>
</table>

<br>
    <p>Untuk peserta kita sudah data terlebih dahulu sebanyak 7 peserta yang berdasarkan nama, asal, status, Gmail, dan gelombang. Peserta yang sudah kami data nantinya akan kami masukan ke dalam Antrian Peserta, dan berikut adalah data peserta yang mendaftar</p>
    <br>
  <p>di awal program kita menampilkan ucapan selamat datang dan pilihan menu untuk peserta, dan untuk opsi pemilihan menu sesuai dengan angka yang berada di menu ,disini kami menyediakan 3 menu yaitu:
    <ol>
      <li>Informasi Peserta<br>
      <p>Pada menu ini peserta akan diberitahu informasi Kursus yang meliputi
      <ul>
        <li>List Pelajaran Kursus</li>
        <li>List Jadwal Kursus</li>
        <li>List Paket Kursus</li>
      </ul>
    Lalu akan ditampilkan juga untuk opsi kembali ke menu masukan Y</p>
    </li>
    </ol>
</p>
<p>
  Disini kita akan membahas sistem kupon di <b>BOOTCAMP IT</b>, ketika peserta menerima penawaran untuk menggunakan kupon maka peserta harus memasukan kode kupon  yang dimiliki, jika peserta sudah memasukan kode kupon maka kode kupon yang dimasukan dalam pendataan akan dicari atau disamakan dengan kode kupon yang tersimpan dalam kumpulan kupon, jika kode kupon yang dimasukan peserta sama dengan kode kupon yang tersimpan dalam kumpulan kupon maka kupon yang ada dalam kumpulan kupon akan ditampilkan dengan kode kupon, nama kupon, dan potongan harga yang didapat setelah itu maka secara otomatis harga paket yang sudah dipilih oleh peserta akan dikurang dengan potongan harga yang didapatkan oleh peserta pada kuponnya.<br>
  Akan tetapi jika saat kode kupon yang dimasukan salah dan tidak sama dengan kode kupon yang tersimpan dalam kumpulan kupon maka peserta tidak akan mendapatkan diskon dan melanjutkan ke transaksi, dan apabila kode kupon yang dimasukan terdahului oleh peserta sebelumnya maka kupon pun tidak bisa didapatkan dan akan langsung menuju proses transaksi jadi satu kupon yang kami sediakan hanya berlaku untuk satu peserta.
</p>
<p>
  Jikalau peserta telah melewati program kupon maka peserta akan ditampilkan harga paket akhir baik itu yang telah mendapatkan diskon dari kupon maupun yang tidak menggunakan kupon, disini peserta akan dimintai bayaran untuk tagihan paket yang dipilih, jika bayaran yang dimasukan peserta lebih dari sama dengan tagihan paket maka keterangan pendataan peserta akan dicetak langsung ke dalam riwayat, sedangkan jika bayaran yang dimasukan kurang maka akan ada pemberitahuan jika pembayaran kurang dan akan ditawarkan juga kepada peserta untuk melakukan pembayaran kembali, jika peserta ingin melakukan pembayaran kembali maka peserta akan lanjut ke transaksi akan tetapi jika peserta tidak melanjutkan pembayaran maka pendataan akan dilanjutkan ke antrian peserta berikutnya. Dan untuk riwayanya kami menapilkan nama pelajaran, jadwal pelajaran, harga akhir paket, jumlah pembayaran, dan kembalian peserta.
</p>


## Komponen Proyek
<p>Lorem ipsum sir dolor amet.</p>

## Pembagian Tim
<p><b>Rachel Simanjuntak</b> = Array Record => Peserta, Jadwal, Pelajaran, Kupon , Paket </p>
<p><b>Luthfi Febrian</b> = Stack => Kupon<br>
                   = Priorty Queue => Peserta<br>
                   = Linked list => Peserta data</p>
<p><b>Ibnu Rasyid Assidiq</b> = Kuponstack -> Pop<br>
                    = Transaksi<br>
                    = Linked List => Riwayat Transaksi</p>

## Demo Proyek
<ul>
  <li>Github: <a href="">Github</a></li>
  <li>Youtube: <a href="">Youtube</a></li>
</ul>
