package com.codearms.maoqiqi.one

import android.app.PendingIntent
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.codearms.maoqiqi.one.base.BaseActivity

class ShortcutsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shortcuts)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) {
            return
        }

        /*val shortcutManager = getSystemService(ShortcutManager::class.java)
        val shortcut = ShortcutInfo.Builder(this, "id1")
            .setShortLabel("setShortLabel")
            .setLongLabel("setLongLabel")
            .setDisabledMessage("Disabled")
            .setIcon(Icon.createWithResource(this, R.drawable.ic_tab_book_checked))
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("example://gizmos")))
            // .setRank(1)
            .build()
        // 可以替换并添加所有shortcut列表
        // shortcutManager.dynamicShortcuts = listOf(shortcut)
        // 可以添加新的 shortcut 到列表，超过最大个数会报异常；
        // shortcutManager.addDynamicShortcuts(listOf(shortcut))
        // 以更新一组 shortcuts；
        // shortcutManager.updateShortcuts(listOf(shortcut))
        // shortcutManager.removeDynamicShortcuts(listOf("id1"))
        shortcutManager.disableShortcuts(listOf("id1"))*/

        val fullScreenIntent = Intent(this, MainActivity::class.java)
        val fullScreenPendingIntent = PendingIntent.getActivity(this, 0,
            fullScreenIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val notificationBuilder =
            NotificationCompat.Builder(this, "CHANNEL_ID")
                .setSmallIcon(R.drawable.ic_back)
                .setContentTitle("Incoming call")
                .setContentText("(919) 555-1234")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_CALL)
                // Use a full-screen intent only for the highest-priority alerts where you
                // have an associated activity that you would like to launch after the user
                // interacts with the notification. Also, if your app targets Android 10
                // or higher, you need to request the USE_FULL_SCREEN_INTENT permission in
                // order for the platform to invoke this notification.
                .setFullScreenIntent(fullScreenPendingIntent, true)

        val incomingCallNotification = notificationBuilder.build()

        // startForeground(notificationId, notification)
    }
}