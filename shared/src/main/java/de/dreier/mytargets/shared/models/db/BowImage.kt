/*
 * Copyright (C) 2018 Florian Dreier
 *
 * This file is part of MyTargets.
 *
 * MyTargets is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2
 * as published by the Free Software Foundation.
 *
 * MyTargets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package de.dreier.mytargets.shared.models.db

import android.annotation.SuppressLint
import android.os.Parcelable
import com.raizlabs.android.dbflow.annotation.*
import de.dreier.mytargets.shared.AppDatabase
import de.dreier.mytargets.shared.models.Image
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
@Table(database = AppDatabase::class)
data class BowImage(
        @Column(name = "_id")
        @PrimaryKey(autoincrement = true)
        var id: Long = 0,

        @Column
        override var fileName: String = "",

        @ForeignKey(tableClass = Bow::class, references = [(ForeignKeyReference(columnName = "bow", foreignKeyColumnName = "_id"))], onDelete = ForeignKeyAction.CASCADE)
        var bowId: Long? = null
) : Image, Parcelable
