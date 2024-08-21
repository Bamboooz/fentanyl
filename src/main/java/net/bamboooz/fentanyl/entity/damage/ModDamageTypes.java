package net.bamboooz.fentanyl.entity.damage;

import net.bamboooz.fentanyl.Fentanyl;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> PRICKING_SELF = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Fentanyl.MOD_ID, "pricking_self"));
    public static final RegistryKey<DamageType> PRICKING_SOMEONE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Fentanyl.MOD_ID, "pricking_someone"));

    public static final RegistryKey<DamageType> FENTANYL_OD = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Fentanyl.MOD_ID, "fentanyl_od"));

    public static DamageSource of(World world, RegistryKey<DamageType> damageType) {
        return new DamageSource(
                world.getRegistryManager()
                        .get(RegistryKeys.DAMAGE_TYPE)
                        .entryOf(damageType));
    }

    public static DamageSource of(World world, Entity attacker, Entity victim, RegistryKey<DamageType> damageType) {
        return new DamageSource(
                world.getRegistryManager()
                        .get(RegistryKeys.DAMAGE_TYPE)
                        .entryOf(damageType), attacker, victim);
    }
}
