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

package de.dreier.mytargets.shared.utils.typeconverters

import com.raizlabs.android.dbflow.converter.TypeConverter
import com.raizlabs.android.dbflow.data.Blob

import de.dreier.mytargets.shared.models.Thumbnail

class ThumbnailConverter : TypeConverter<Blob, Thumbnail>() {

    override fun getDBValue(model: Thumbnail?): Blob? {
        return if(model == null) null else Blob(model.data)
    }

    override fun getModelValue(data: Blob?): Thumbnail? {
        return if (data != null) Thumbnail(data.blob) else null
    }

}
