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
  Untuk harga pelajaran kursus kami menyediakan beberapa kategori paket yang berdasarkan kategori paket, Masa paket, dan Harga paket. Paket yang kami sediakan adalah sebagai berikut:<br>
<br>
<ol>
<li>Kategori A = Masa 1 bulan, Harga 100.000</li>
<li>Kategori B = Masa 3 bulan, Harga 300.000</li>
<li>Kategori C = Masa 7 bulan, Harga 600.000</li>
<li>Kategori D = Masa 1 tahun, Harga 900.000</li>
</ol>
<br>
  Dan di kursus ini juga kami menyediakan kupon untuk para peserta sehingga peserta yang memiliki kupon dan mendapat potongan harga disini kami menyediakan 3 kupon, kupon ini bisa peserta gunakan ketika peserta memasukan kode kupon dalam pendataan peserta, dan berikut adalah kupon yang kami sediakan<br>
<br>
Kupon Garuda = Kode(098), potongan harga (75000)<br>
Kupon Merpati = Kode(123), potongan harga (50000)<br>
Kupon Ayam = Kode(345), potongan harga (25000)<br>
<br>
    Untuk peserta kita sudah data terlebih dahulu sebanyak 6 peserta yang berdasarkan nama, asal, status, nomor telepon, dan gelombang. Peserta yang sudah kami data nantinya akan kami lakukan pendataan selanjutnya untuk pemilihan kursus berdasarkan urutan yang diambil dari gelombang pendaftaran peserta<br>
<br>
  Selanjutnya masuk ke program pendataan untuk menentukan pelajaran kursus, jadwal kursus, paket kursus, pemakaian kupon, dan transaksi.<br>
Pendataan akan dimulai berdasarkan gelombang, jadi peserta yang mendaftar di gelombang pertama maka ia memiliki hak terlebih dahulu untuk pendataan kursus, setelah peserta memasukan pelajaran, jadwal, dan paket kursus maka peserta akan ditawarkan untuk menggunakan kupon, jika peserta ingin menggunakan kupon maka peserta harus memasukan kode kupon peserta yang didapat dari BOOTCAMP dan jika peserta tidak menggunakan kupon maka peserta tidak akan mendapatkan potongan harga dan lanjut ke pembayaran.
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
