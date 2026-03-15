# 🎵 Sistem Manajemen Playlist Musik - Tugas Kelompok ke-1

**Mata Kuliah:** Data Structures and Algorithm Analysis (COSC6025)  
**Topik:** Introduction to OOP & Data Structures  
**Tanggal:** [15 Maret 2026]


## 👥 Identitas Kelompok 5

| Nama Lengkap | NIM |
|--------------|-----|
| Darren Jehonathan | 290271410 |
| Joshua Christian Supit | 2902706736 |
| Gabriel Sigalingging | 2902724442 |
| Renata Mutiara Nirwana | 2902733131 |
| Evelyn Kimora Tjiu | 2902692466 |

---

## 📌 Deskripsi Program

Program ini adalah sistem manajemen playlist musik sederhana yang mengimplementasikan **Object-Oriented Programming (OOP)** dengan konsep:

- **Enkapsulasi** – atribut class `Lagu` dibuat private dan diakses melalui getter/setter.
- **Inheritance** – class `Admin` dan `Member` mewarisi class `User`.
- **Polymorphism** – method `tampilkanAkses()` di-override di setiap subclass.

Fitur yang tersedia:

- ✅ Menambahkan lagu baru (Admin)
- ✅ Melihat daftar lagu (Member)
- ✅ Mencari lagu berdasarkan judul (Member)
- ✅ Menghitung rata-rata durasi lagu (Member)

Data lagu disimpan dalam **array** dengan kapasitas maksimal 10 lagu.

---

## 🧱 Struktur Class


Lagu.java               # Model lagu (judul, artis, durasi)
Playlist.java           # Array playlist + method kelola lagu
User.java               # Parent class (username + tampilkanAkses)
Admin.java              # Child class (bisa tambah lagu)
Member.java             # Child class (bisa lihat, cari, rata-rata)
PlaylistOOP.java        # Main class (menjalankan program)

---

## 🚀 Cara Menjalankan Program

1. Pastikan Anda memiliki **Java JDK** terinstal.
2. Clone repository ini atau download semua file `.java`.
3. Buka terminal di folder tempat file disimpan.
4. Jalankan perintah berikut:

```bash
javac PlaylistOOP.java
java PlaylistOOP
```

---

## 📸 Screenshot Hasil Eksekusi

![alt](
<img width="738" height="540" alt="Screenshot 2026-03-15 175117" src="https://github.com/user-attachments/assets/9d19cb2e-94ff-44ed-8e07-d3d011785fe7" />)

---


## 📝 Penjelasan Konsep OOP

### 1. Inheritance 

Inheritance adalah mekanisme di mana sebuah class dapat mewarisi atribut dan method dari class lain. Dalam sistem ini:

- **`User`** berperan sebagai **parent class** yang memiliki atribut `username` dan method `tampilkanAkses()` serta `getUsername()`.
- **`Admin`** dan **`Member`** adalah **child class** yang mewarisi `User` menggunakan kata kunci `extends`.

Contoh dalam kode:
```java
class Admin extends User { ... }
class Member extends User { ... }
```

Dengan inheritance, `Admin` dan `Member` otomatis memiliki atribut `username` tanpa perlu mendefinisikan ulang. Mereka juga dapat menambahkan method khusus sesuai peran:

- `Admin` memiliki method `tambahLagu()` untuk menambahkan lagu ke playlist.
- `Member` memiliki method `lihatPlaylist()`, `cariLagu()`, dan `hitungRataDurasi()` untuk berinteraksi dengan playlist.

Ini menghindari duplikasi kode dan membuat struktur lebih terorganisir serta mudah dikembangkan.

### 2. Polymorphism (Polimorfisme)

Polymorphism memungkinkan sebuah method memiliki perilaku berbeda tergantung pada objek yang memanggilnya. Dalam sistem ini, polymorphism diterapkan melalui **method overriding** pada method `tampilkanAkses()`.

- Di class `User`, method `tampilkanAkses()` menampilkan pesan umum.
- Di class `Admin`, method di-*override* untuk menampilkan bahwa admin dapat menambah lagu.
- Di class `Member`, method di-*override* untuk menampilkan bahwa member dapat melihat dan mencari lagu.

Ketika objek `Admin` atau `Member` memanggil method yang sama, program secara otomatis menjalankan versi yang sesuai dengan jenis objeknya. Ini menunjukkan perilaku yang berbeda (polimorfisme) dalam satu antarmuka.

---

## 💡 Kesimpulan

- **Inheritance** digunakan untuk membangun hierarki class antara `User`, `Admin`, dan `Member`, sehingga child class mewarisi atribut dan method parent class, mengurangi duplikasi kode.
- **Polymorphism** diterapkan melalui overriding method `tampilkanAkses()`, sehingga setiap jenis user memiliki perilaku akses yang berbeda sesuai perannya dalam sistem playlist.

Dengan kedua konsep ini, program menjadi lebih terstruktur, mudah dipelihara, dan siap dikembangkan di masa depan.

---

**© Kelompok 5 – Data Structures and Algorithm Analysis**

