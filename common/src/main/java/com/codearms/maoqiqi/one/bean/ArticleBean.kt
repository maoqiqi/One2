package com.codearms.maoqiqi.one.bean

import android.os.Parcel
import android.os.Parcelable

class ArticleBean(
    val id: Int = 0,
    // 收藏文章列表独有
    val originId: Int = 0,
    val type: Int = 0,
    val title: String = "",
    val userId: Int = 0,
    val author: String = "",
    val chapterId: Int = 0,
    val chapterName: String = "",
    val superChapterId: Int = 0,
    val superChapterName: String = "",
    val realSuperChapterId: Int = 0,
    val link: String = "",
    val apkLink: String = "",
    val projectLink: String = "",
    val tags: List<TagBean> = arrayListOf(),
    val zan: Int = 0,
    val visible: Int = 0,
    val desc: String = "",
    val descMd: String = "",
    val envelopePic: String = "",
    val publishTime: Long = 0,
    val niceDate: String = "",
    val niceShareDate: String = "",
    val shareDate: Long = 0,
    val shareUser: String = "",
    val origin: String = "",
    val prefix: String = "",
    val fresh: Boolean = false,
    val collect: Boolean = false,
    val courseId: Int = 0,
    val audit: Int = 0,
    val host: String = "",
    val selfVisible: Int = 0
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.createTypedArrayList(TagBean) ?: arrayListOf(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readLong(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readLong(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readInt()
    )

    class TagBean(val name: String = "", val url: String = "") : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString().toString(),
            parcel.readString().toString()
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
            parcel.writeString(url)
        }

        override fun describeContents(): Int = 0

        companion object CREATOR : Parcelable.Creator<TagBean> {
            override fun createFromParcel(parcel: Parcel): TagBean = TagBean(parcel)

            override fun newArray(size: Int): Array<TagBean?> = arrayOfNulls(size)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(originId)
        parcel.writeInt(type)
        parcel.writeString(title)
        parcel.writeInt(userId)
        parcel.writeString(author)
        parcel.writeInt(chapterId)
        parcel.writeString(chapterName)
        parcel.writeInt(superChapterId)
        parcel.writeString(superChapterName)
        parcel.writeInt(realSuperChapterId)
        parcel.writeString(link)
        parcel.writeString(apkLink)
        parcel.writeString(projectLink)
        parcel.writeTypedList(tags)
        parcel.writeInt(zan)
        parcel.writeInt(visible)
        parcel.writeString(desc)
        parcel.writeString(descMd)
        parcel.writeString(envelopePic)
        parcel.writeLong(publishTime)
        parcel.writeString(niceDate)
        parcel.writeString(niceShareDate)
        parcel.writeLong(shareDate)
        parcel.writeString(shareUser)
        parcel.writeString(origin)
        parcel.writeString(prefix)
        parcel.writeByte(if (fresh) 1 else 0)
        parcel.writeByte(if (collect) 1 else 0)
        parcel.writeInt(courseId)
        parcel.writeInt(audit)
        parcel.writeString(host)
        parcel.writeInt(selfVisible)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ArticleBean> {
        override fun createFromParcel(parcel: Parcel): ArticleBean = ArticleBean(parcel)

        override fun newArray(size: Int): Array<ArticleBean?> = arrayOfNulls(size)
    }
}