/*
 * Copyright (c) 2016, 2017, 2018 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.fabric.impl.item;

import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.fabricmc.fabric.api.item.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemProvider;
import net.minecraft.tag.Tag;

import java.util.Map;

// TODO: Clamp values to 32767 (+ add hook for mods which extend the limit to disable the check?)
public class FuelRegistryImpl implements FuelRegistry {
	public static final FuelRegistryImpl INSTANCE = new FuelRegistryImpl();
	private final Object2IntMap<ItemProvider> itemCookTimes = new Object2IntLinkedOpenHashMap<>();
	private final Object2IntMap<Tag<Item>> tagCookTimes = new Object2IntLinkedOpenHashMap<>();

	private FuelRegistryImpl() {

	}

	@Override
	public void add(ItemProvider item, int cookTime) {
		itemCookTimes.put(item, cookTime);
	}

	@Override
	public void add(Tag<Item> tag, int cookTime) {
		tagCookTimes.put(tag, cookTime);
	}

	public void apply(Map<Item, Integer> map) {
		for (ItemProvider item : itemCookTimes.keySet()) {
			int time = itemCookTimes.getInt(item);
			if (time <= 0) {
				map.remove(item.getItem());
			} else {
				map.put(item.getItem(), time);
			}
		}

		for (Tag<Item> tag : tagCookTimes.keySet()) {
			int time = tagCookTimes.getInt(tag);
			if (time <= 0) {
				for (Item i : tag.values()) {
					map.remove(i);
				}
			} else {
				for (Item i : tag.values()) {
					map.put(i, time);
				}
			}
		}
	}
}