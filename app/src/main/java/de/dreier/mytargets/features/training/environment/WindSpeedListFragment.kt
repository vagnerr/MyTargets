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

package de.dreier.mytargets.features.training.environment

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import de.dreier.mytargets.base.fragments.SelectPureListItemFragmentBase
import de.dreier.mytargets.base.navigation.NavigationController.Companion.ITEM
import de.dreier.mytargets.shared.models.WindSpeed

class WindSpeedListFragment : SelectPureListItemFragmentBase<WindSpeed>(compareBy(WindSpeed::id)) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        adapter!!.setList(WindSpeed.getList(context!!).toMutableList())
        val windSpeed = arguments!!.getParcelable<WindSpeed>(ITEM)
        selectItem(binding.recyclerView, windSpeed!!)
        return binding.root
    }

    override fun getName(item: WindSpeed) = item.name

    override fun getDrawable(item: WindSpeed) = ContextCompat.getDrawable(context!!, item.drawable)!!
}
