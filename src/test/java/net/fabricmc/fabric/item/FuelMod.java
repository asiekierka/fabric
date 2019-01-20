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

package net.fabricmc.fabric.item;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.ItemPropertyRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;

public class FuelMod implements ModInitializer {
	@Override
	public void onInitialize() {
		ItemPropertyRegistry.INSTANCE.add(Items.APPLE, 200);
		ItemPropertyRegistry.INSTANCE.remove(Blocks.OAK_PLANKS);
	}
}