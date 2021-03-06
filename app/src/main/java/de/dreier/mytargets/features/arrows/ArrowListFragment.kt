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

package de.dreier.mytargets.features.arrows

import android.os.Bundle
import de.dreier.mytargets.base.db.dao.ArrowDAO
import de.dreier.mytargets.base.fragments.LoaderUICallback
import de.dreier.mytargets.base.fragments.SelectPureListItemFragmentBase
import de.dreier.mytargets.base.navigation.NavigationController.Companion.ITEM
import de.dreier.mytargets.shared.models.db.Arrow

class ArrowListFragment : SelectPureListItemFragmentBase<Arrow>(compareBy(Arrow::name, Arrow::id)) {

    override fun onLoad(args: Bundle?): LoaderUICallback {
        val arrows = ArrowDAO.loadArrows()
        return {
            adapter!!.setList(arrows.toMutableList())
            val arrow = arguments!!.getParcelable<Arrow>(ITEM)
            selectItem(binding.recyclerView, arrow!!)
        }
    }

    override fun getName(item: Arrow) = item.name

    override fun getDrawable(item: Arrow) = item.thumbnail!!.roundDrawable
}
