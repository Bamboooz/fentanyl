package net.bamboooz.fentanyl.loot.custom;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.bamboooz.fentanyl.loot.ModLootConditions;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.JsonSerializer;
import net.minecraft.village.VillagerProfession;

public class VillagerProfessionLootCondition implements LootCondition {
    private final VillagerProfession profession;

    public VillagerProfessionLootCondition(VillagerProfession profession) {
        this.profession = profession;
    }

    @Override
    public LootConditionType getType() {
        return ModLootConditions.VILLAGER_PROFESSION;
    }

    @Override
    public boolean test(LootContext lootContext) {
        if (lootContext.get(LootContextParameters.THIS_ENTITY) instanceof VillagerEntity villager) {
            return villager.getVillagerData().getProfession() == profession;
        }

        return false;
    }

    public static LootCondition.Builder builder(VillagerProfession profession) {
        return () -> new VillagerProfessionLootCondition(profession);
    }

    public static class Serializer implements JsonSerializer<VillagerProfessionLootCondition> {
        @Override
        public void toJson(JsonObject json, VillagerProfessionLootCondition object, JsonSerializationContext context) {
            json.addProperty("profession", Registries.VILLAGER_PROFESSION.getId(object.profession).toString());
        }

        @Override
        public VillagerProfessionLootCondition fromJson(JsonObject json, JsonDeserializationContext context) {
            Identifier id = new Identifier(JsonHelper.getString(json, "profession"));
            VillagerProfession profession = Registries.VILLAGER_PROFESSION.get(id);

            return new VillagerProfessionLootCondition(profession);
        }
    }
}
