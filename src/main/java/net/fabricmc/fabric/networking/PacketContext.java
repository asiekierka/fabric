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

package net.fabricmc.fabric.networking;

import net.fabricmc.api.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ThreadTaskQueue;

/**
 * Interface defining a context used during packet processing. Allows access
 * to additional information, such as the source/target of the player, or
 * the correct task queue to enqueue synchronization-requiring code on.
 */
public interface PacketContext {
	Side getSide();
	EntityPlayer getPlayer();
	ThreadTaskQueue getTaskQueue();
}
