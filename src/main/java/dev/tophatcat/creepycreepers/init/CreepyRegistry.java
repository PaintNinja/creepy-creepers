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

import dev.tophatcat.creepycreepers.CreepyCreepers;
import dev.tophatcat.creepycreepers.entities.AustralianCreeperEntity;
import dev.tophatcat.creepycreepers.entities.GhostlyCreeperEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CreepyRegistry {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(
        ForgeRegistries.SOUND_EVENTS, CreepyCreepers.MOD_ID);

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
        ForgeRegistries.ENTITIES, CreepyCreepers.MOD_ID);

    public static final RegistryObject<EntityType<GhostlyCreeperEntity>> GHOSTLY_CREEPER = ENTITIES.register(
        "ghostly_creeper", () -> EntityType.Builder.of(GhostlyCreeperEntity::new, EntityClassification.MONSTER)
            .sized(0.6F, 1.7F)
            .setTrackingRange(80)
            .setUpdateInterval(1)
            .setShouldReceiveVelocityUpdates(true)
            .build(new ResourceLocation(CreepyCreepers.MOD_ID, "ghostly_creeper").toString())
    );

    public static final RegistryObject<EntityType<AustralianCreeperEntity>> AUSTRALIAN_CREEPER = ENTITIES.register(
        "australian_creeper", () -> EntityType.Builder.of(AustralianCreeperEntity::new,
                EntityClassification.MONSTER)
            .sized(0.6F, 1.7F)
            .setTrackingRange(80)
            .setUpdateInterval(1)
            .setShouldReceiveVelocityUpdates(true)
            .build(new ResourceLocation(CreepyCreepers.MOD_ID, "australian_creeper").toString())
    );

    public static final RegistryObject<SoundEvent> GHOSTLY_CREEPER_SOUND = SOUNDS.register(
        "ghostly_creeper_scream", () -> new SoundEvent(
            new ResourceLocation(CreepyCreepers.MOD_ID, "ghostly_creeper_scream")));
    public static final RegistryObject<SoundEvent> AUSTRALIAN_CREEPER_SOUND = SOUNDS.register(
        "australian_creeper", () -> new SoundEvent(
            new ResourceLocation(CreepyCreepers.MOD_ID, "australian_creeper")));

    public static void registerSpawnPlacements(FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            EntitySpawnPlacementRegistry.register(GHOSTLY_CREEPER.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                MobEntity::checkMobSpawnRules);
            EntitySpawnPlacementRegistry.register(AUSTRALIAN_CREEPER.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                MobEntity::checkMobSpawnRules);
        });
    }
}
