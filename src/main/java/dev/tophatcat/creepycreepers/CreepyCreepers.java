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
package dev.tophatcat.creepycreepers;

import dev.tophatcat.creepycreepers.client.CreeperRenderingRegistry;
import dev.tophatcat.creepycreepers.init.CreeperSpawnHandler;
import dev.tophatcat.creepycreepers.init.CreepyConfig;
import dev.tophatcat.creepycreepers.init.CreepyRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(CreepyCreepers.MOD_ID)
public class CreepyCreepers {

    public static final String MOD_ID = "creepycreepers";

    //TODO Restore missing creeper animations.
    //TODO Find out why spawning is not working and fixit.

    public CreepyCreepers() {
        IEventBus mod = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(ModConfig.Type.SERVER, CreepyConfig.SERVER_CONFIG_SPEC);

        CreepyRegistry.ENTITIES.register(mod);
        CreepyRegistry.SOUNDS.register(mod);
        mod.addListener(CreepyRegistry::registerSpawnPlacements);
        mod.addListener(CreeperSpawnHandler::addBiomeSpawns);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            mod.addListener(CreeperRenderingRegistry::registerEntityModels);
        }
    }
}
