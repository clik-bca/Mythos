# Card Editor

Aplikasi untuk mengedit dan mengunduh template kartu dalam format PNG. Fitur-fitur utamanya mencakup:

- Edit teks (nama, nomor, alamat, keterangan)
- Sesuaikan ukuran font
- Pratinjau langsung
- Unduh kartu ke penyimpanan

## Screenshot

Tangkapan layar aplikasi dapat dilihat di folder `assets/` (jika ada) atau di dokumentasi aplikasi ini.

## Tangkapan layar

Sertakan tangkapan layar yang relevan (desain UI, pratinjau kartu, file yang diunduh, dll.).

## Build Requirements

- Android Studio Arctic Fox atau yang lebih baru
- Android SDK (API 24+ compatible)
- Gradle (level dukungan plugin 8.2, set minimum Android SDK 24)

## Build from Source

```bash
cd projects/aktif/card-editor
# Jalankan script bootstrap (periode pengujian)
git pull
# Jalankan ./gradlew assembleDebug
```

## Instalasi

1. Buka `app/build/outputs/apk/debug/app-debug.apk` di perangkat atau emulator Android.
2. Izinkan instalasi aplikasi yang tidak dikenal (jika diperlukan) melalui Pengaturan > Keamanan > Instal aplikasi yang tidak dikenal (atau serupa).
3. Jalankan aplikasi dari layar awal (atau menu aplikasi).

## Penggunaan

Buka aplikasi, edit teks pada panel kontrol, sesuaikan ukuran font menggunakan seekbar, dan klik "Unduh PNG" untuk menyimpan file.

## Lisensi

© 2025 clik-bca. Distribusi di bawah lisensi proyek Mythos (atau lisensi yang sesuai).