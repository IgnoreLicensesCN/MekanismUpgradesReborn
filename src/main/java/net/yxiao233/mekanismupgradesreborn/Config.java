package net.yxiao233.mekanismupgradesreborn;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = MekanismUpgradesReborn.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.IntValue TIME_MULTIPLIER = BUILDER.comment("Base factor for machine running time with upgrades[default:1]").defineInRange("time_multiplier",1,1,Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue ELECTRICITY_MULTIPLIER = BUILDER.comment("Base factor for machine power consumption with upgrades[default:1]").defineInRange("electricity_multiplier",1,1,Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue CAPACITY_MULTIPLIER = BUILDER.comment("Base factor for machine capacity with upgrades[default:1]").defineInRange("capacity_multiplier",1,1,Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue MAX_UPGRADE = BUILDER.comment("Maximum speed/energy upgrades a machine can accept[default:16]").defineInRange("max_upgrade",16,1,64);
    private static final ForgeConfigSpec.BooleanValue USE_MEK_DEFAULT_ENERGY_AND_SPEED_FORMULA = BUILDER.comment("Use mekanism's default upgrade formula to avoid upgrade 'invalid' when 8 < speedUpgrades < energyUpgrades [default:false]").define("use_mek_default_formula",false);
    static final ForgeConfigSpec SPEC = BUILDER.build();
    public static int timeMultiplier;
    public static int electricityMultiplier;
    public static int capacityMultiplier;
    public static int maxUpgrade;
    public static boolean useMekDefaultUpgradeFormula;
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event){
        timeMultiplier = TIME_MULTIPLIER.get();
        electricityMultiplier = ELECTRICITY_MULTIPLIER.get();
        capacityMultiplier = CAPACITY_MULTIPLIER.get();
        maxUpgrade = MAX_UPGRADE.get();
        useMekDefaultUpgradeFormula = USE_MEK_DEFAULT_ENERGY_AND_SPEED_FORMULA.get();
    }
}
