package dev.tophatcat.creepycreepers.init;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class CreepyConfig {

    public static final ForgeConfigSpec SERVER_CONFIG_SPEC;
    public static final CreepyCreeperConfig CONFIG;

    static {
        final Pair<CreepyCreeperConfig, ForgeConfigSpec> configSpecPair
            = new ForgeConfigSpec.Builder().configure(CreepyCreeperConfig::new);
        SERVER_CONFIG_SPEC = configSpecPair.getRight();
        CONFIG = configSpecPair.getLeft();
    }

    public static class CreepyCreeperConfig {
        //Ghostly Creeper configuration.
        public final ForgeConfigSpec.IntValue weightMultiplierGhostly;
        public final ForgeConfigSpec.IntValue maxYLevelSpawnGhostly;
        public final ForgeConfigSpec.IntValue minSpawnGroupGhostly;
        public final ForgeConfigSpec.IntValue maxSpawnGroupGhostly;
        //Australian Creeper Configuration.
        public final ForgeConfigSpec.IntValue weightMultiplierAustralian;
        public final ForgeConfigSpec.IntValue maxYLevelSpawnAustralian;
        public final ForgeConfigSpec.IntValue minSpawnGroupAustralian;
        public final ForgeConfigSpec.IntValue maxSpawnGroupAustralian;

        public CreepyCreeperConfig(ForgeConfigSpec.Builder builder) {
            builder.push("Ghostly Creeper");
            builder.comment("Set how much of a chance Ghostly Creepers have to spawn in the world and the min/max "
                + "group size. (Set Spawn Weight to 0 to prevent them spawning)");
            weightMultiplierGhostly = builder.defineInRange("Spawn Weight",
                50, 0, 500);
            maxYLevelSpawnGhostly = builder.defineInRange("Max Y Spawn Level",
                128, -64, 320);
            minSpawnGroupGhostly = builder.defineInRange("Minimum Group Spawn Count",
                1, 1, 64);
            maxSpawnGroupGhostly = builder.defineInRange("Maximum Group Spawn Count",
                3, 1, 64);
            builder.pop();

            builder.push("Australian Creeper");
            builder.comment("Set how much of a chance Australian Creepers have to spawn in the world and the min/max "
                + "group size. (Set Spawn Weight to 0 to prevent them spawning)");
            weightMultiplierAustralian = builder.defineInRange("Spawn Weight",
                50, 0, 500);
            maxYLevelSpawnAustralian = builder.defineInRange("Max Y Spawn Level",
                128, -64, 320);
            minSpawnGroupAustralian = builder.defineInRange("Minimum Group Spawn Count",
                1, 1, 64);
            maxSpawnGroupAustralian = builder.defineInRange("Maximum Group Spawn Count",
                3, 1, 64);
            builder.pop();
        }
    }
}
