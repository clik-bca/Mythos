package com.mythos.cardeditor

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import java.io.FileOutputStream

class MainActivity : Activity() {
    private lateinit var canvas: Canvas
    private lateinit var bitmap: Bitmap
    private lateinit var paint: Paint
    private var posX = 50f
    private var posY = 50f
    private var textSize = 24f
    private var bgColor = Color.WHITE
    private var txtColor = Color.BLACK

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Layout dasar
        val root = RelativeLayout(this)
        setContentView(root)

        // Area gambar (Canvas)
        val iv = ImageView(this)
        iv.setWillNotDraw(false)
        val ivParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        root.addView(iv, ivParams)

        // Inisialisasi bitmap
        val width = resources.displayMetrics.widthPx
        val height = resources.displayMetrics.heightPx
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        canvas = Canvas(bitmap)
        canvas.drawColor(bgColor)

        // Kontrol overlay
        val ctrl = RelativeLayout(this)
        ctrl.setBackgroundColor(Color.argb(180, 0, 0, 0))
        val ctrlParams = RelativeLayout.LayoutParams(
            dpToPx(300), dpToPx(350))
        ctrlParams.addRule(RelativeLayout.ALIGN_PARENT_START)
        ctrlParams.addRule(RelativeLayout.ALIGN_PARENT_TOP)
        ctrl.layoutParams = ctrlParams
        root.addView(ctrl)

        // Judul
        val title = TextView(this)
        title.text = "Editor Kartu"
        title.setTextColor(Color.WHITE)
        val titleParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        titleParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE)
        title.layoutParams = titleParams
        ctrl.addView(title)

        // Nama
        val lblNama = TextView(this)
        lblNama.text = "Nama:"
        lblNama.setTextColor(Color.WHITE)
        val lblNamaParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lblNamaParams.topMargin = dpToPx(40)
        lblNama.layoutParams = lblNamaParams
        ctrl.addView(lblNama)

        val etNama = EditText(this)
        etNama.setText("BOS Name")
        etNama.setHintTextColor(Color.WHITE)
        etNama.setTextColor(Color.WHITE)
        val etNamaParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        etNamaParams.topMargin = dpToPx(35)
        etNamaParams.leftMargin = dpToPx(40)
        etNama.layoutParams = etNamaParams
        ctrl.addView(etNama)

        // Nomor
        val lblNo = TextView(this)
        lblNo.text = "Nomor:"
        lblNo.setTextColor(Color.WHITE)
        val lblNoParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lblNoParams.topMargin = dpToPx(90)
        lblNo.layoutParams = lblNoParams
        ctrl.addView(lblNo)

        val etNo = EditText(this)
        etNo.setText("12345/XYZ")
        etNo.setHintTextColor(Color.WHITE)
        etNo.setTextColor(Color.WHITE)
        val etNoParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        etNoParams.topMargin = dpToPx(85)
        etNoParams.leftMargin = dpToPx(40)
        etNo.layoutParams = etNoParams
        ctrl.addView(etNo)

        // Alamat
        val lblAlmt = TextView(this)
        lblAlmt.text = "Alamat:"
        lblAlmt.setTextColor(Color.WHITE)
        val lblAlmtParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lblAlmtParams.topMargin = dpToPx(140)
        lblAlmt.layoutParams = lblAlmtParams
        ctrl.addView(lblAlmt)

        val etAlmt = EditText(this)
        etAlmt.setText("Jl. Contoh No. 1")
        etAlmt.setHintTextColor(Color.WHITE)
        etAlmt.setTextColor(Color.WHITE)
        val etAlmtParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        etAlmtParams.topMargin = dpToPx(135)
        etAlmtParams.leftMargin = dpToPx(40)
        etAlmt.layoutParams = etAlmtParams
        ctrl.addView(etAlmt)

        // Keterangan
        val lblKet = TextView(this)
        lblKet.text = "Keterangan:"
        lblKet.setTextColor(Color.WHITE)
        val lblKetParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lblKetParams.topMargin = dpToPx(190)
        lblKet.layoutParams = lblKetParams
        ctrl.addView(lblKet)

        val etKet = EditText(this)
        etKet.setText("Contoh kartu")
        etKet.setHintTextColor(Color.WHITE)
        etKet.setTextColor(Color.WHITE)
        val etKetParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        etKetParams.topMargin = dpToPx(185)
        etKetParams.leftMargin = dpToPx(40)
        etKet.layoutParams = etKetParams
        ctrl.addView(etKet)

        // Seekbar ukuran font
        val sb = SeekBar(this)
        sb.max = 72
        sb.progress = (textSize / 2).toInt()
        sb.setOnSeekBarChangeListener(object : android.widget.SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: android.widget.SeekBar?, progress: Int, fromUser: Boolean) {
                textSize = progress.toFloat()
            }
            override fun onStartTrackingTouch(seekBar: android.widget.SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: android.widget.SeekBar?) {}
        })
        val sbParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        sbParams.topMargin = dpToPx(250)
        sbParams.leftMargin = dpToPx(20)
        sb.layoutParams = sbParams
        ctrl.addView(sb)

        // Tombol Unduh PNG
        val btnUnduh = Button(this)
        btnUnduh.text = "Unduh PNG"
        btnUnduh.setOnClickListener {
            // Tulis teks ke bitmap
            paint = Paint()
            paint.textSize = textSize
            paint.color = txtColor
            paint.isAntiAlias = true
            canvas.drawText("Nama: ${etNama.text.toString()}", posX, posY, paint)
            canvas.drawText("Nomor: ${etNo.text.toString()}", posX, posY + 40f, paint)
            canvas.drawText("Alamat: ${etAlmt.text.toString()}", posX, posY + 80f, paint)
            canvas.drawText("Keterangan: ${etKet.text.toString()}", posX, posY + 120f, paint)

            // Simpan ke file
            val fname = "${System.currentTimeMillis()}_kartu.png"
            try {
                val fos = FileOutputStream(fname)
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
                fos.close()
                Toast.makeText(this, "Disimpan: $fname", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Log.e("MainActivity", "Gagal simpan", e)
                Toast.makeText(this, "Gagal simpan", Toast.LENGTH_SHORT).show()
            }
        }
        val btnUnduhParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        btnUnduhParams.topMargin = dpToPx(300)
        btnUnduhParams.leftMargin = dpToPx(20)
        btnUnduh.layoutParams = btnUnduhParams
        ctrl.addView(btnUnduh)

        // Tombol Reset
        val btnReset = Button(this)
        btnReset.text = "Reset"
        btnReset.setOnClickListener {
            canvas.drawColor(bgColor, android.graphics.PorterDuff.Mode.CLEAR)
            etNama.setText("")
            etNo.setText("")
            etAlmt.setText("")
            etKet.setText("")
        }
        val btnResetParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        btnResetParams.topMargin = dpToPx(340)
        btnResetParams.leftMargin = dpToPx(20)
        btnReset.layoutParams = btnResetParams
        ctrl.addView(btnReset)
    }

    private fun dpToPx(dp: Float): Int = (dp * resources.displayMetrics.density).toInt()

    override fun onDestroy() {
        super.onDestroy()
        if (!bitmap.isRecycled) bitmap.recycle()
    }
}