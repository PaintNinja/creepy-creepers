/*
 * Creepy Creepers - https://github.com/tophatcats-mods/creepy-creepers
 * Copyright (C) 2016-2022 <KiriCattus>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * Specifically version 2.1 of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.creepycreepers.init;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;

public class CreeperSpawnHandler {

    private static Biome.SpawnListEntry ghostlyCreeper;
    private static Biome.SpawnListEntry australianCreeper;

    public static void addBiomeSpawns(ModConfig.ModConfigEvent event) {
        if (CreepyConfig.CONFIG.weightMultiplierGhostly.get() > 0) {
            Collection<Biome >biomes = ForgeRegistries.BIOMES.getValues();

            ghostlyCreeper = new Biome.SpawnListEntry(
                CreepyRegistry.GHOSTLY_CREEPER.get(),
                CreepyConfig.CONFIG.weightMultiplierGhostly.get(),
                CreepyConfig.CONFIG.minSpawnGroupGhostly.get(),
                CreepyConfig.CONFIG.maxSpawnGroupGhostly.get());

            australianCreeper = new Biome.SpawnListEntry(
                CreepyRegistry.AUSTRALIAN_CREEPER.get(),
                CreepyConfig.CONFIG.weightMultiplierAustralian.get(),
                CreepyConfig.CONFIG.minSpawnGroupAustralian.get(),
                CreepyConfig.CONFIG.maxSpawnGroupAustralian.get());

            biomes.stream().map(biome -> biome.getMobs(EntityClassification.MONSTER)).forEach(list ->
                list.add(ghostlyCreeper));
            biomes.stream().map(biome -> biome.getMobs(EntityClassification.MONSTER)).forEach(list ->
                list.add(australianCreeper));
        }
    }
}
