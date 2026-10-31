# LAPORAN UJI
| Tugas | Langkah | Hasil | Bukti |
|---|---|---|---|
| T1 audit aplikasi | self_audit pada folder . | 2 tinggi, 4 sedang, skor 50/100; temuan: S04 tidak ada berkas tes, S07 build.gradle & AndroidManifest.xml tidak ada, S07 versionCode tidak terbaca, gradle-wrapper.jar & gradlew tidak executable | MYTHOS/logs/error_summary.log |
| T2 cek file kunci proyek Android | run_command ls & berangkas_baca pada reference & app | tidak ditemukan build.gradle, AndroidManifest.xml, gradlew, gradle-wrapper.jar, tidak ada folder src/main/kotlin, tidak ada file unit test | output perintah & berangkas_baca |
| T3 cek aplikasi terpasang | berangkas_baca pada reference/ | aplikasi terpasang versi 2.29, izin belum diberikan, status stabil | output berangkas_baca |