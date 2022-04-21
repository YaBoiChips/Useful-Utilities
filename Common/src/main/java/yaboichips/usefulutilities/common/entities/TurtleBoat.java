package yaboichips.usefulutilities.common.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import yaboichips.usefulutilities.core.UUEntities;
import yaboichips.usefulutilities.mixin.access.BoatEntityAccess;
import yaboichips.usefulutilities.common.CustomBoat;

public class TurtleBoat extends Boat implements CustomBoat {

    private static final EntityDataAccessor<Integer> BOAT_TYPE = SynchedEntityData.defineId(TurtleBoat.class, EntityDataSerializers.INT);

    public TurtleBoat(Level world, double x, double y, double z) {
        this(UUEntities.TURTLE_BOAT, world);
        this.setPos(x, y, z);
        this.setDeltaMovement(Vec3.ZERO);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    public TurtleBoat(EntityType<? extends Boat> boatEntityType, Level worldType) {
        super(boatEntityType, worldType);
    }

    @Override
    public Item getDropItem() {
        return switch (this.getModBoatType()) {
            default -> Items.OAK_BOAT;
            case BIRCH_TURTLE -> Items.BIRCH_BOAT;
            case ACACIA_TURTLE -> Items.ACACIA_BOAT;
            case JUNGLE_TURTLE -> Items.JUNGLE_BOAT;
            case SPRUCE_TURTLE -> Items.SPRUCE_BOAT;
            case DARK_OAK_TURTLE -> Items.DARK_OAK_BOAT;
        };
    }

    public ModType getTypeFromVanilla(Type type){
        return switch (type) {
            default -> ModType.OAK_TURTLE;
            case BIRCH -> ModType.BIRCH_TURTLE;
            case ACACIA -> ModType.ACACIA_TURTLE;
            case JUNGLE -> ModType.JUNGLE_TURTLE;
            case SPRUCE -> ModType.SPRUCE_TURTLE;
            case DARK_OAK -> ModType.DARK_OAK_TURTLE;
        };
    }

    @Override
    public void tick() {
        super.tick();
        ((BoatEntityAccess)this).floatBoat();
    }

    @Override
    public void controlBoat() {
        if (this.isVehicle()) {
            BoatEntityAccess boat = ((BoatEntityAccess)this);
            float f = 0.0F;
            if (boat.getInputLeft()) {
                boat.setDeltaRotation(boat.getDeltaRotation() - 1);
            }

            if (boat.getInputRight()) {
                boat.setDeltaRotation(boat.getDeltaRotation() + 1);
            }

            if (boat.getInputRight() != boat.getInputLeft() && !boat.getInputUp() && !boat.getInputDown()) {
                f += 0.02F;
            }

            this.setYRot(this.getYRot() + boat.getDeltaRotation());
            if (boat.getInputUp()) {
                f += 0.1F;
            }

            if (boat.getInputDown()) {
                f -= 0.02F;
            }

            this.setDeltaMovement(this.getDeltaMovement().add(Mth.sin(-this.getYRot() * ((float) Math.PI / 180F)) * f, 0.0D, Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * f));
            this.setPaddleState(boat.getInputRight() && !boat.getInputLeft() || boat.getInputUp(), boat.getInputLeft() && !boat.getInputRight() || boat.getInputUp());
        }
    }

    public ModType getModBoatType() {
        return ModType.byId(this.entityData.get(BOAT_TYPE));
    }

    public void setModBoatType(ModType boatType) {
        this.entityData.set(BOAT_TYPE, boatType.ordinal());
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BOAT_TYPE, ModType.OAK_TURTLE.ordinal());
    }


    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putString("Type", this.getModBoatType().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.contains("Type", 8)) {
            this.setModBoatType(ModType.getTypeFromString(compound.getString("Type")));
        }
    }

    @Override
    public void animateHurt() {
        this.setHurtDir(-this.getHurtDir());
        this.setHurtTime(10);
        this.setDamage(this.getDamage() * 11.0F);
    }

    public enum ModType {
        OAK_TURTLE("oak_turtle"),
        SPRUCE_TURTLE("spruce_turtle"),
        BIRCH_TURTLE("birch_turtle"),
        DARK_OAK_TURTLE("dark_oak_turtle"),
        JUNGLE_TURTLE("jungle_turtle"),
        ACACIA_TURTLE("acacia_turtle");


        private final String name;

        ModType(String string) {
            this.name = string;
        }

        public static ModType byId(int id) {
            ModType[] values = values();
            if (id < 0 || id >= values.length) {
                id = 0;
            }

            return values[id];
        }

        public static ModType getTypeFromString(String nameIn) {
            ModType[] values = values();

            for (ModType ModType : values) {
                if (ModType.getName().equals(nameIn)) {
                    return ModType;
                }
            }

            return values[0];
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }
    }
}
