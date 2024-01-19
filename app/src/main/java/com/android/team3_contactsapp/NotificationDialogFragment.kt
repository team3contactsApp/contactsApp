package com.android.team3_contactsapp

import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.text.Transliterator.Position
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.fragment.app.DialogFragment
import com.android.team3_contactsapp.Data.myJoinedgroup
import com.android.team3_contactsapp.MypageFragment
import com.android.team3_contactsapp.databinding.NotificationDialogBinding
import com.android.team3_contactsapp.MypageFragment as MypageFragment1


@Suppress("DEPRECATION")
class NotificationDialogFragment(private val mypageFragment: MypageFragment ) : DialogFragment() {
    private var _binding: NotificationDialogBinding? = null
    private val binding get() = _binding!!
    private val handler = Handler()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = NotificationDialogBinding.inflate(inflater, container, false)

        val customView = binding.root

        val builder = AlertDialog.Builder(requireActivity())


        // 커스텀 뷰 설정
        builder.setView(customView)


        binding.btn5minute.setOnClickListener {
            handler.postDelayed({ reservationNotification("") }, 5000)
            mypageFragment.updateAlaramList("")
            dismiss()
        }
        binding.btn10minute.setOnClickListener {
            handler.postDelayed({ reservationNotification("10초예약") }, 10000)
            dismiss()
        }
        binding.btn30minute.setOnClickListener {
            handler.postDelayed({ reservationNotification("30초 예약") }, 30000)
            dismiss()
        }
        binding.btn60minute.setOnClickListener {
            handler.postDelayed({ reservationNotification("1분 예약") }, 60000)
            dismiss()
        }



        return customView
    }

    private fun reservationNotification(reservationTime: String) {
        val notificationManager =
            binding.root.context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val intent = Intent(binding.root.context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            binding.root.context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "one-channel"
            val channelName = "My Channel One"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }
        val notification = NotificationCompat.Builder(binding.root.context, "one-channel")
            .setContentTitle("모임에 참여 할 준비 되셨나요?")
            .setContentText("설정한 ${reservationTime}시간이 지났습니다. 모임에 늦지 않게 서두르세요!!")
            .setSmallIcon(R.drawable.person)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build()


        notificationManager.notify(1, notification)
    }
}

