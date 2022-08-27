package dev.tophatcat.creepycreepers.init;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;
import java.util.Collections;

public class CreeperSpawnHandler {

    private static Collection<Biome> biomes;
    private static Biome.SpawnListEntry spawnListEntry;

    public static void addBiomeSpawns(FMLCommonSetupEvent event) {
        if (spawnListEntry != null) {
            biomes.stream().map(biome -> biome.getMobs(EntityClassification.MONSTER)).forEach(list
                -> list.remove(spawnListEntry));
            biomes = Collections.emptyList();
        }

        if (CreepyConfig.CONFIG.weightMultiplierGhostly.get() > 0) {
            biomes = ForgeRegistries.BIOMES.getValues();

            spawnListEntry = new Biome.SpawnListEntry(
                CreepyRegistry.GHOSTLY_CREEPER.get(),
                CreepyConfig.CONFIG.weightMultiplierGhostly.get(),
                CreepyConfig.CONFIG.minSpawnGroupGhostly.get(),
                CreepyConfig.CONFIG.maxSpawnGroupGhostly.get());

            spawnListEntry = new Biome.SpawnListEntry(
                CreepyRegistry.AUSTRALIAN_CREEPER.get(),
                CreepyConfig.CONFIG.weightMultiplierAustralian.get(),
                CreepyConfig.CONFIG.minSpawnGroupAustralian.get(),
                CreepyConfig.CONFIG.maxSpawnGroupAustralian.get());

            biomes.stream().map(biome -> biome.getMobs(EntityClassification.MONSTER)).forEach(list ->
                list.add(spawnListEntry));
        }
    }
}
